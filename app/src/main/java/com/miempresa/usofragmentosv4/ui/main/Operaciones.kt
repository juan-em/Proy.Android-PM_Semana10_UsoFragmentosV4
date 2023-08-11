package com.miempresa.usofragmentosv4.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.miempresa.usofragmentosv4.R


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Operaciones.newInstance] factory method to
 * create an instance of this fragment.
 */
class Operaciones : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_operaciones, container, false)
        val spinner: Spinner = view.findViewById(R.id.spinner)
        val btnCalcular = view.findViewById<Button>(R.id.btnCalcular)


        val adapter = ArrayAdapter.createFromResource(
            spinner.context,
            R.array.operaciones,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        spinner.adapter = adapter
        var rpta:Double = 0.0

        btnCalcular.setOnClickListener({
            var opcion_seleccionada = spinner.selectedItem.toString()
            val num1 = view.findViewById<EditText>(R.id.numero1).getText().toString().toDouble()
            val num2 = view.findViewById<EditText>(R.id.numero2).getText().toString().toDouble()
            when (opcion_seleccionada){
                "Suma" -> rpta = num1 + num2
                "Resta" -> rpta = num1 - num2
                "Multiplicación" -> rpta = num1 * num2
                "División" -> rpta = num1 / num2
            }
            val respuesta = Respuesta()
            val args =Bundle()
            args.putString("num1", num1.toString())
            args.putString("num2", num2.toString())
            args.putString("operacion", opcion_seleccionada)
            args.putString("rpta", rpta.toString())
            respuesta.arguments = args
            val transaccion: FragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
            transaccion.replace(R.id.contenedor_af,respuesta)
            transaccion.commit()
        })
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Operaciones.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Operaciones().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}