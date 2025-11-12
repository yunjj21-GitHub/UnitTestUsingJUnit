package com.yunjung.unittest

class MyCalc {
    private val pi = 3.14

    fun calculateCircumference(radius: Double): Double {
        return 2 * pi * radius
    }

    fun calculateArea(radius: Double): Double {
        return pi * radius * radius
    }
}