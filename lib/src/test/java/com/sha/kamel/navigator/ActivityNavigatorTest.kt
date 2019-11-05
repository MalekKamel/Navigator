package com.sha.kamel.navigator

import android.content.Context
import android.content.Intent
import android.os.Parcelable
import com.nhaarman.mockitokotlin2.any
import com.sha.kamel.navigator.model.Flags
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ActivityNavigatorTest {

    private lateinit var navigator: ActivityNavigator

    @Mock
    lateinit var context: Context

    @Mock
    private lateinit var activity: TestActivity

    @Before
    fun setup() {
        navigator = ActivityNavigator(activity)
    }

    @Test
    fun navigate_shouldCallStartActivity() {
        navigator.navigate(TestActivity::class.java)
        verify(activity).startActivity(any())
    }

    @Test
    fun navigateWithIntent_shouldCallStartActivity() {
        val intent = Intent(context, TestActivity::class.java)
        navigator.navigate(intent)
        verify(activity).startActivity(intent)
    }

    @Test
    fun navigate_testParcelableAndFlags() {
        val intent = mock(Intent::class.java)
        val parcelable = mock(Parcelable::class.java)

        navigator
                .withParcelable(parcelable, "parcelable")
                .withFlags(Flags().newTask().singleTop())
                .navigate(intent)

        verify(activity).startActivity(intent)

        verify(intent).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        verify(intent).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)

        verify(intent).putExtra("parcelable", parcelable)
    }

    @Test
    fun startActivityForResult_shouldCallStartActivityForResult() {
        navigator.startActivityForResult(TestActivity::class.java, 1, activity)
        verify(activity).startActivityForResult(any(), any())
    }

    @Test
    fun startActivityForResultWithIntent_shouldCallStartActivityForResult() {
        val intent = Intent(context, TestActivity::class.java)
        navigator.startActivityForResult(intent, 1, activity)
        verify(activity).startActivityForResult(intent, 1)
    }

    @Test
    fun startActivityForResult_testParcelableAndFlags() {
        val parcelable = mock(Parcelable::class.java)
        val intent = mock(Intent::class.java)

        navigator
                .withParcelable(parcelable, "parcelable")
                .withFlags(Flags().newTask().singleTop())
                .startActivityForResult(intent, 1, activity)

        verify(activity).startActivityForResult(intent, 1)

        verify(intent).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        verify(intent).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)

        verify(intent).putExtra("parcelable", parcelable)
    }

    @Test
    fun showRouteInGoogleMap_shouldCallStartActivity() {
        navigator
                .withFlags(Flags().newTask().singleTop())
                .showRouteInGoogleMap(0.0, 0.0, 0.0, 0.0)

        verify(activity).startActivity(any())
    }

    @Test
    fun showRouteInGoogleMapWithObj_shouldCallStartActivity() {
        navigator
                .withFlags(Flags().newTask().singleTop())
                .showRouteInGoogleMap(MapRoute(0.0, 0.0, 0.0, 0.0))

        verify(activity).startActivity(any())
    }

    @Test
    fun navigateToSystemSettings_shouldCallStartActivity() {
        navigator.navigateToSystemSettings()

        verify(activity).startActivity(any())
    }

    @Test
    fun openCameraApp_shouldCallStartActivity() {
        navigator.openCameraApp(activity,1)

        verify(activity).startActivityForResult(any(), any())
    }

    @Test
    fun openInGooglePlay_shouldCallStartActivity() {
        navigator.openInGooglePlay("app")

        verify(activity).startActivity(any())
    }
}