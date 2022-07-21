package com.example.calculatorresistance.myView

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.calculatorresistance.R

class FragmentProva3 : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //view.findNavController().graph
        return inflater.inflate(R.id.provaId, container, false)
    }
}