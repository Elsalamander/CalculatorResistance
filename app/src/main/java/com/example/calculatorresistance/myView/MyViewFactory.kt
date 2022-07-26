package com.example.calculatorresistance.myView

import android.content.Context
import android.graphics.Typeface
import android.text.InputType
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import com.example.calculatorresistance.MyOperation
import com.example.calculatorresistance.myView.listener.ResistanceCalculatorListener
import java.util.*
import kotlin.properties.Delegates

/**
 * colorText.setBackgroundColor(0x00FF00)
 * colorText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10f)
 */
/****************************************************************
 * Builder della View
 *
 * @author: Elsalamander
 * @data: 14 luglio 2022
 * @version: v1.0
 ****************************************************************/
class MyViewFactory {

    companion object{
        const val NAME_TENSION = "Tensione"
        const val NAME_CURRENT = "Corrente"
        const val NAME_RESISTANCE = "Resistenza"
    }

    lateinit var mylayout : LinearLayout

    var dp10 by Delegates.notNull<Int>()
    var dp15 by Delegates.notNull<Int>()
    var dp20 by Delegates.notNull<Int>()
    var dp40 by Delegates.notNull<Int>()
    var dp60 by Delegates.notNull<Int>()
    var dp100 by Delegates.notNull<Int>()
    var dp120 by Delegates.notNull<Int>()
    var dp200 by Delegates.notNull<Int>()

    val value = TreeMap<String, EditText>()

    val myOperation = MyOperation()

    fun createLayout(context: Context): View {
        this.setParameters(context)

        mylayout = LinearLayout(context)
        mylayout.orientation = LinearLayout.VERTICAL
        //parametri
        mylayout.layoutParams = ViewGroup.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT)


        mylayout.addView(this.getTitleLayout(context))
        mylayout.addView(this.getCalculatorLayout(context))
        mylayout.addView(this.getColorCodeLayout(context))

        return mylayout
    }

    private fun setParameters(context: Context) {
        dp10 = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10f, context.resources.displayMetrics).toInt()
        dp15 = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 15f, context.resources.displayMetrics).toInt()
        dp20 = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20f, context.resources.displayMetrics).toInt()
        dp40 = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 40f, context.resources.displayMetrics).toInt()
        dp60 = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 60f, context.resources.displayMetrics).toInt()
        dp100 = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 100f, context.resources.displayMetrics).toInt()
        dp120 = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 120f, context.resources.displayMetrics).toInt()
        dp200 = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 200f, context.resources.displayMetrics).toInt()
    }


    /**
     * Crea un parte del layout il TITOLO
     */
    private fun getTitleLayout(context: Context): View {
        val title = TextView(context)
        title.text = "Calcolatrice resistenze"
        //parametri
        title.layoutParams = ViewGroup.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT)
        title.textSize = dp15.toFloat()
        title.setTypeface(title.typeface, Typeface.BOLD_ITALIC)

        return title
    }

    /**
     * Crea il layout per la parte della calcolatrice
     */
    private fun getCalculatorLayout(context: Context): View? {
        val calcLayout = LinearLayout(context)
        calcLayout.orientation = LinearLayout.VERTICAL
        //parametri
        calcLayout.layoutParams = ViewGroup.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT)


        calcLayout.addView(this.getCalcElementLayout(context, NAME_TENSION, "0", "V"))
        calcLayout.addView(this.getCalcElementLayout(context, NAME_CURRENT, "0", "I"))
        calcLayout.addView(this.getCalcElementLayout(context, NAME_RESISTANCE, "0", String(Character.toChars(0x03A9))))

        return calcLayout
    }

    private fun getCalcElementLayout(context: Context, name: String, hint: String, unit: String): View {
        val elementLayout = LinearLayout(context)
        elementLayout.orientation = LinearLayout.HORIZONTAL
        //parametri
        elementLayout.layoutParams = ViewGroup.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT)

        //primo elemento
        val textViewName = TextView(context)
        textViewName.text = name
        textViewName.textSize = dp10.toFloat()
        //parametri
        textViewName.layoutParams = ViewGroup.LayoutParams(dp120,LinearLayout.LayoutParams.WRAP_CONTENT)
        //inserisci
        elementLayout.addView(textViewName)

        //secondo elemento
        val editTextInput = EditText(context)
        editTextInput.hint = hint
        editTextInput.textSize = dp10.toFloat()
        editTextInput.inputType = InputType.TYPE_CLASS_NUMBER
        //listener
        editTextInput.setOnKeyListener(ResistanceCalculatorListener(myOperation, this))
        //parametri
        editTextInput.layoutParams = ViewGroup.LayoutParams(dp120,LinearLayout.LayoutParams.WRAP_CONTENT)
        elementLayout.addView(editTextInput)

        value[name] = editTextInput

        //terzo elemento
        val unitText = TextView(context)
        unitText.text = unit
        unitText.textSize = dp10.toFloat()
        //parametri
        unitText.layoutParams = ViewGroup.LayoutParams(dp40,LinearLayout.LayoutParams.WRAP_CONTENT)
        elementLayout.addView(unitText)

        return elementLayout
    }


    /**
     * Crea il loyout per la parte dei colori
     */
    private fun getColorCodeLayout(context: Context): View? {
        val layout = LinearLayout(context)
        layout.orientation = LinearLayout.VERTICAL


        return layout
    }

}