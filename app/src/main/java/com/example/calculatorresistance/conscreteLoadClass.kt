package com.example.calculatorresistance

import android.content.Context
import androidx.fragment.app.Fragment
import com.example.calculatorresistance.myView.FragmentResistance
import it.elsalamander.loaderclass.AbstractLoadClass


class conscreteLoadClass : AbstractLoadClass(MyOperation()) {


    override fun getTitle(): String {
        return "Calculator Resistance"
    }

    override fun getDescription(): String {
        return "Specializzata per resistenze"
    }

    override fun getFragment(context: Context): Fragment {
        return FragmentResistance(context)
    }

}