package com.yunjung.unittest

import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Timeout
import java.util.concurrent.TimeUnit
import kotlin.test.assertEquals

class MyCalcTest {
    private lateinit var myCalc: MyCalc

    companion object {
        @JvmStatic
        @BeforeAll
        fun setUpForAll(){
            // TODO("Not yet implemented")
        }

        @JvmStatic
        @AfterAll
        fun tearDownForAll(){
            // TODO("Not yet implemented")
        }
    }

    @BeforeEach
    fun setup() {
        myCalc = MyCalc()
    }

    @AfterEach
    fun tearDown() {

    }

    @Timeout(5, unit = TimeUnit.SECONDS)
    @Test
    fun calculateCircumference_radiusGiven_returnsCorrectResult() {
        val result = myCalc.calculateCircumference(2.1)
        assertEquals(result, 13.188)
    }

    @Test
    fun calculateCircumference_zeroRadius_returnsCorrectResult() {
        val result = myCalc.calculateCircumference(0.0)
        assertEquals(result, 0.0)
    }

    @Test
    fun calculateArea_radiusGiven_returnsCorrectResult() {
        val result = myCalc.calculateArea(2.1)
        assertEquals(result, 13.8474)
    }

    @Test
    fun calculateArea_zeroRadius_returnsCorrectResult() {
        val result = myCalc.calculateArea(0.0)
        assertEquals(result, 0.0)
    }
}