package com.yunjung.unittest

import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Timeout
import org.mockito.Mock
import org.mockito.Mockito.atLeast
import org.mockito.Mockito.atMost
import org.mockito.Mockito.mock
import org.mockito.Mockito.never
import org.mockito.Mockito.only
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import java.util.concurrent.TimeUnit
import kotlin.test.assertEquals

class MyCalcTest {
    private lateinit var myCalc: MyCalc

    @Mock
    private lateinit var mockListUnsingAnno: MutableList<String>

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

    @Test
    fun verifyMockList(){
        mockListUnsingAnno.add("one")
        mockListUnsingAnno.add("two")

        val mockListUsingMethod = mock<MutableList<String>>(mutableListOf())
        mockListUsingMethod.add("one")
        mockListUsingMethod.add("two")

        val mockListUsingInline: MutableList<String> = mock()
        mockListUsingInline.add("one")
        mockListUsingInline.add("two")

        verify(mockListUnsingAnno).add("one")
        verify(mockListUsingMethod).add("one")
        verify(mockListUsingInline).add("one")

        verify(mockListUnsingAnno, times(2)).add("two")
        verify(mockListUnsingAnno, never()).add("three")
        verify(mockListUnsingAnno, atLeast(2)).add("two")
        verify(mockListUnsingAnno, atMost(2)).add("two")
        verify(mockListUnsingAnno, only()).add("two")
    }

    private inline fun <reified T> mock(): T {
        return mock(T::class.java)
    }
}