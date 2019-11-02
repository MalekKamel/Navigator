package com.sha.kamel.navigator

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class FragmentNavigatorTest {

    private lateinit var navigator: FragmentNavigator

    private lateinit var activity: TestActivity

    private lateinit var fragmentManager: FragmentManager

    lateinit var fragmentTransaction: FragmentTransaction

    @Before
    fun setup() {
        activity = mock(TestActivity::class.java)
        fragmentManager = mock(FragmentManager::class.java)
        fragmentTransaction = mock(FragmentTransaction::class.java)

        `when`(activity.supportFragmentManager).thenReturn(fragmentManager)
        `when`(fragmentManager.beginTransaction()).thenReturn(fragmentTransaction)

        navigator = FragmentNavigator(activity, 2)
    }

    @Test
    fun add() {
        val fragment = TestFragment()
        navigator.add(fragment)

        verify(fragmentTransaction).add(
                2,
                fragment,
                fragment.javaClass.name
        )

        verify(fragmentTransaction).commitAllowingStateLoss()
    }

    @Test
    fun replace() {
        val fragment = TestFragment()
        navigator.replace(fragment)

        verify(fragmentTransaction).replace(
                2,
                fragment,
                fragment.javaClass.name
        )

        verify(fragmentTransaction).commitAllowingStateLoss()
    }

    @Test
    fun remove() {
        `when`(fragmentTransaction.remove(any())).thenReturn(fragmentTransaction)

        val fragment = TestFragment()
        navigator.remove(fragment)

        verify(fragmentTransaction).remove(fragment)
        verify(fragmentTransaction).commitAllowingStateLoss()
    }

    @Test
    fun showDialogFragment() {
        val dialog = mock(TestDialog::class.java)
        navigator.showDialogFragment(dialog)

        verify(dialog).show(fragmentManager, dialog.javaClass.name)
    }

}