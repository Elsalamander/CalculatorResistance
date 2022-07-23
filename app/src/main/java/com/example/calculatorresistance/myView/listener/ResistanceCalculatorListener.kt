package com.example.calculatorresistance.myView.listener

import android.view.KeyEvent
import android.view.View
import android.widget.EditText
import com.example.calculatorresistance.MyOperation
import com.example.calculatorresistance.myView.MyViewFactory

class ResistanceCalculatorListener(val myOperation: MyOperation, val myLayout : MyViewFactory) : View.OnKeyListener{

    /**
     * Called when a hardware key is dispatched to a view. This allows listeners to
     * get a chance to respond before the target view.
     *
     * Key presses in software keyboards will generally NOT trigger this method,
     * although some may elect to do so in some situations. Do not assume a
     * software input method has to be key-based; even if it is, it may use key presses
     * in a different way than you expect, so there is no way to reliably catch soft
     * input key presses.
     *
     * @param v The view the key has been dispatched to.
     * @param keyCode The code for the physical key that was pressed
     * @param event The KeyEvent object containing full information about
     * the event.
     * @return True if the listener has consumed the event, false otherwise.
     */
    override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
        if((event!!.action == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {

            val V = myLayout.value[MyViewFactory.NAME_TENSION]!!
            val I = myLayout.value[MyViewFactory.NAME_CURRENT]!!
            val R = myLayout.value[MyViewFactory.NAME_RESISTANCE]!!

            var setOn : EditText? = null
            var check : Boolean = true
            var key : String? = null

            val dataBuilder = myOperation.getHelperFor(listOf("V","I","R"))!!.createOperationDataParametersBuilder()
            if(V.text != null && V.text.toString() != ""){
                dataBuilder.putValue("V", V.text.toString().toDouble())
            }else{
                setOn = V
                key = "V"
            }
            if(I.text != null && I.text.toString() != ""){
                dataBuilder.putValue("I", I.text.toString().toDouble())
            }else{
                check = setOn == null
                setOn = I
                key = "I"
            }
            if(R.text != null && R.text.toString() != ""){
                dataBuilder.putValue("R", R.text.toString().toDouble())
            }else{
                check = setOn == null
                setOn = R
                key = "R"
            }

            val res = myOperation.calcola(dataBuilder.build())

            if(check){
                setOn?.setText(res.result[key]?.first().toString())
            }

            return true
        }
        return false;
    }

}