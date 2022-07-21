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

        val buildRes = OperationDataResultBuilder(param)
        if (V != null && I != null) {
            buildRes.addResult("R", V/I)
        }
        return buildRes.build()
    }

    override fun getHelperList(): List<OperationDataHelper> {
        return this.helpers
    }
}