package com.example.calculatorresistance.myView

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment


class FragmentResistance(val cont: Context) : Fragment() {

    val layout = MyViewFactory()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = layout.createLayout(cont)
        return view
    }

}