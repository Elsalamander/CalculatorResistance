package com.example.calculatorresistance.myView

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/****************************************************************
 * Fragment dell'estensione
 *
 * @author: Elsalamander
 * @data: 14 luglio 2022
 * @version: v1.0
 ****************************************************************/
class FragmentResistance(val cont: Context) : Fragment() {

    val layout = MyViewFactory()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = layout.createLayout(cont)
        return view
    }

}