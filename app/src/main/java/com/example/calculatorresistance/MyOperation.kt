package com.example.calculatorresistance

import it.elsalamander.loaderclass.calculator.Operation
import it.elsalamander.loaderclass.calculator.data.OperationDataHelper
import it.elsalamander.loaderclass.calculator.data.OperationDataParameters
import it.elsalamander.loaderclass.calculator.data.OperationDataResult
import it.elsalamander.loaderclass.calculator.data.builder.OperationDataResultBuilder

class MyOperation : Operation() {
    private val helpers = ArrayList<OperationDataHelper>()

    init{
        helpers.add(OperationDataHelper("Resistance From V,I", listOf("V","I","R")))
    }

    override fun calcola(param: OperationDataParameters): OperationDataResult {
        val V = param.getParameters()["V"]
        val I = param.getParameters()["I"]
        val R = param.getParameters()["R"]

        //crea il builder per il risultatto
        val buildRes = OperationDataResultBuilder(param)

        //cerca il calcolo da fare
        if (V != null && I != null) {
            if(I == 0.0){
                buildRes.addResult("R", Double.POSITIVE_INFINITY)
            }else{
                buildRes.addResult("R", V/I)
            }
        }else if(V != null && R != null){
            if(R == 0.0){
                buildRes.addResult("I", Double.POSITIVE_INFINITY)
            }else{
                buildRes.addResult("I", V/R)
            }
        }else if(R != null && I != null){
            buildRes.addResult("V", R*I)
        }
        return buildRes.build()
    }

    override fun getHelperList(): List<OperationDataHelper> {
        return this.helpers
    }
}