package com.sha.kamel.sample.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.sha.kamel.navigator.FragmentNavigator
import com.sha.kamel.sample.R

/**
 * Created by Sha on 11/11/17.
 */

class ExampleFragment : Fragment() {

    private var message: String? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_example, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tv = view.findViewById<TextView>(R.id.tv)
        tv.text = message

        view.findViewById<View>(R.id.btnRemove).setOnClickListener { FragmentNavigator(activity!!).remove(this) }
    }

    companion object {

        fun newInstance(message: String): ExampleFragment {
            val fragment = ExampleFragment()
            fragment.message = message
            return fragment
        }
    }

}
