package com.example.mbs.pmdmfinal


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_blank.*


/**
 * A simple [Fragment] subclass.
 */
class BlankFragment : Fragment() {
    var bundleMain : String =""

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_blank, container, false)
    }

    companion object {

        fun newInstance(): MainActivity {
            var main1 = MainActivity()
            return main1
        }
    }


    override fun onResume(){
        super.onResume()
        bundleMain = arguments.getString("111","error")

        texto1.setText(bundleMain)


    }

}// Required empty public constructor
