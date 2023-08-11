package com.miempresa.usofragmentosv4.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.miempresa.usofragmentosv4.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Respuesta.newInstance] factory method to
 * create an instance of this fragment.
 */
class Respuesta : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_respuesta, container, false)
        var num1 = view.findViewById<TextView>(R.id.lbl_num1)
        var num2 = view.findViewById<TextView>(R.id.lbl_num2)
        var operacion = view.findViewById<TextView>(R.id.lbl_operacion)
        var rpta = view.findViewById<TextView>(R.id.rpta)
        if (arguments != null){
            val r_num1 = requireArguments().getString("num1")
            val r_num2 = requireArguments().getString("num2")
            val r_operacion = requireArguments().getString("operacion")
            val r_rpta = requireArguments().getString("rpta")
            num1.setText(r_num1)
            num2.setText(r_num2)
            operacion.setText(r_operacion)
            rpta.setText(r_rpta)
        }
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Respuesta.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Respuesta().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}