package com.pthw.composebookstore.testcase

import com.pthw.composebookstore.codelab.testcase.PriceCalculator
import org.junit.Test
import org.junit.Assert.*

/**
 * Created by P.T.H.W on 17/09/2023.
 */
class PriceCalculatorTest {

    private val classUnderTest = PriceCalculator()

    @Test
    fun `validate calculation`() {
        val result = classUnderTest.calculatePrice(
            price1 = 3.00,
            price2 = 5.00,
            taxRate = 0.20
        )

        assertEquals(9.60, result, 0.001)
    }

}