package com.sample.wordgame.core.common

import android.app.Application
import com.sample.wordgame.core.common.utils.RandomGenerator
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class RandomGeneratorTest {

    @Mock
    private var randomGenerator: RandomGenerator? = null

    @Mock
    private var app: Application? = null

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
    }


    @Test
    fun testReturnsRandomAlphabet(){
        var string1: CharArray= randomGenerator!!.generateRandomAlphabet(5)
        var string2 : CharArray= randomGenerator!!.generateRandomAlphabet(5)
        Assert.assertNotEquals(string2,string1)
    }


    @After
    fun cleanup() {
        randomGenerator = null
    }

}