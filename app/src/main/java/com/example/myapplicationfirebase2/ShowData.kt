package com.example.myapplicationfirebase2


import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction

/**
 * A simple [Fragment] subclass.
 */
class ShowData : Fragment() {


    lateinit var textview : TextView
    lateinit var button: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_show_data, container, false)
        // Inflate the layout for this fragment

        //Instantiate new instance of our class
        val getRequest = HttpGetRequest()


        textview = view.findViewById(R.id.text)
        //  textview.setText(result)

        button = view.findViewById(R.id.button)

        button.setOnClickListener {
            val builder: AlertDialog.Builder = AlertDialog.Builder(this.context)
            builder.setMessage("ต้องการดูข้อมูลสถิติการขาย?")
            builder.setPositiveButton("ใช่",
                DialogInterface.OnClickListener{ dialog, id ->
                    Toast.makeText(this.context, "ขอบคุณครับ", Toast.LENGTH_SHORT).show()
                    val MainChart = MainChart()
                    val fm = fragmentManager
                    val transaction : FragmentTransaction = fm!!.beginTransaction()
                    transaction.replace(R.id.layout, MainChart,"fragment_MainChart")
                    transaction.addToBackStack("fragment_MainChart")
                    transaction.commit()

                })

            builder.setNegativeButton("ไม่ใช่",
                DialogInterface.OnClickListener { dialog, which ->
                    dialog.dismiss()
                })
            builder.show()
        }
        return view
    }

}
