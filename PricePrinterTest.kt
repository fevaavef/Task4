package com.example.dmitrii_korolev_shop

import org.junit.Test

import org.junit.Assert.*
import kotlin.math.roundToInt

class PricePrinterTest {
    @Test
    fun addition_isCorrect() {
        val assaultRifle = Product(5000.0, 10)
        val productPricePrinter = ProductPricePrinter()

        val discountAssaultRiflePrice = assaultRifle.calcDiscountPrice()
        productPricePrinter.print(discountAssaultRiflePrice)
    }

    class Product(
        private val price: Double,
        private val salePercent: Int = 0
    ) {
        fun calcDiscountPrice(): Double = price * (1 - salePercent / 100.0)
    }

    class ProductPricePrinter : PricePrinter{
        override fun print(price: Double) {
            var formatString: String = "%.2f₽\n"
            val roundedPrice = (100*price).roundToInt() / 100.0
            if (roundedPrice - price.roundToInt() == 0.0) {
                formatString = "%.0f₽\n"
            }
            print(formatString.format(roundedPrice))
        }
    }

    interface PricePrinter{
        fun print(price:Double)
    }
}
