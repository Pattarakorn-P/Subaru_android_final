package com.example.myapplicationfirebase2


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction
import com.bumptech.glide.Glide

/**
 * A simple [Fragment] subclass.
 */
class fragment_detail : Fragment() {

    private var head : String = ""
    private var body : String = ""
    private var img : String = ""
    private var price_car : String = ""

    fun newInstance(head: String,body: String,img: String,price_car: String): fragment_detail {

        val fragment = fragment_detail()
        val bundle = Bundle()
        bundle.putString("head", head)
        bundle.putString("body", body)
        bundle.putString("img", img)
        bundle.putString("price_car",price_car)
        fragment.setArguments(bundle)

        return fragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bundle = arguments
        if (bundle != null) {
            head = bundle.getString("head").toString()
            body = bundle.getString("body").toString()
            img = bundle.getString("img").toString()
            price_car = bundle.getString("price_car").toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_fragment_detail, container, false)
        val imgVi : ImageView = view.findViewById(R.id.imgV)
        val headTxt : TextView = view.findViewById(R.id.tv_name)
        val bodyTxt : TextView = view.findViewById(R.id.tv_description)
        val priceTxt : TextView = view.findViewById(R.id.tv_price)

        val button2 = view.findViewById(R.id.button2) as Button

        headTxt.setText(head)
        bodyTxt.setText(body)
        priceTxt.setText(price_car)
        Glide.with(activity!!.baseContext)
            .load(img)
            .into(imgVi);

        // Inflate the layout for this fragment
        button2.setOnClickListener {
            val ShowData = ShowData()
            val fm = fragmentManager
            val transaction : FragmentTransaction = fm!!.beginTransaction()
            transaction.replace(R.id.layout, ShowData, "fragment_ShowData")
            transaction.addToBackStack("fragment_ShowData")
            transaction.commit()
        }
        return view
    }


}