package com.sha.kamel.sample.ui

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.sha.kamel.navigator.FragmentNavigator
import com.sha.kamel.sample.R
import com.sha.kamel.sample.model.CustomerInfo
import org.parceler.Parcels


/**
 * Created by Sha on 11/11/17.
 */

class CustomerDialogFragment : DialogFragment() {

    private var tv: TextView? = null
    private var tv_name: TextView? = null
    private var tv_age: TextView? = null
    private var tv_mobile: TextView? = null

    private var customerInfo: CustomerInfo? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_dialog_client_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tv = getView()!!.findViewById(R.id.tv)
        tv_name = getView()!!.findViewById(R.id.tv_name)
        tv_age = getView()!!.findViewById(R.id.tv_age)
        tv_mobile = getView()!!.findViewById(R.id.tv_mobile)

        tv_name!!.text = "Name: " + customerInfo!!.name
        tv_age!!.text = "Age: " + customerInfo!!.age
        tv_mobile!!.text = "Mobile: " + customerInfo!!.mobile
    }

    companion object {
        fun newInstance(customerInfo: CustomerInfo): CustomerDialogFragment {
            val fragment = CustomerDialogFragment()
            fragment.customerInfo = customerInfo
            return fragment
        }
    }


}
