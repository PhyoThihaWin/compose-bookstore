package com.pthw.composebookstore.codelab.testcase

/**
 * Created by P.T.H.W on 17/09/2023.
 */
class PriceCalculator {

    fun calculatePrice(
        price1: Double,
        price2: Double,
        taxRate: Double
    ): Double {
        return (price1 + price2) * (1.0 + taxRate)
    }
}