package com.example.calculatorresistance

import android.content.Context
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.calculatorresistance.myView.FragmentResistance
import it.elsalamander.loaderclass.AbstractLoadClass
import it.elsalamander.loaderclass.Holder

import it.elsalamander.loaderclass.OnStartUpExtension
import it.elsalamander.loaderclass.calculator.execute.Calculator

/****************************************************************
 * Classe da caricare dell'estensione
 *
 * @author: Elsalamander
 * @data: 14 luglio 2022
 * @version: v1.0
 ****************************************************************/
class conscreteLoadClass : AbstractLoadClass(MyOperation()), OnStartUpExtension {


    override fun getTitle(): String {
        return "Calculator Resistance"
    }

    override fun getDescription(): String {
        return "Specializzata per resistenze"
    }

    override fun getFragment(context: Context): Fragment {
        return FragmentResistance(context)
    }

    override fun doOnStartUp(param: Holder, newLoad: Boolean) {
        Log.d("Test loading", "LOADING TEST-------------------------------------")
    }


}