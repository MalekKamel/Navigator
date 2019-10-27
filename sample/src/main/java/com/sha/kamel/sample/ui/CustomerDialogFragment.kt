package com.sha.kamel.sample.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.sha.kamel.sample.R
import com.sha.kamel.sample.model.CustomerInfo


/**
 * Created by Sha on 11/11/17.
 */

class CustomerDialogFragment : DialogFragment() {

    private var customerInfo: CustomerInfo? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_dialog_client_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getView()!!.findViewById<TextView>(R.id.tv_name).apply {
            text = "Name: ${customerInfo!!.name}"
        }
        getView()!!.findViewById<TextView>(R.id.tv_age).apply {
            text = "Age: ${customerInfo!!.age}"
        }
        getView()!!.findViewById<TextView>(R.id.tv_mobile).apply {
            text = "Mobile: ${customerInfo!!.mobile}"
        }
    }

    companion object {
        fun newInstance(customerInfo: CustomerInfo): CustomerDialogFragment {
            val fragment = CustomerDialogFragment()
            fragment.customerInfo = customerInfo
            return fragment
        }
    }


}
