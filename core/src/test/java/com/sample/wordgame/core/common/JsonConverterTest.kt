package com.sample.wordgame.core.common

import android.app.Application
import com.sample.wordgame.core.common.utils.JsonConverter
import org.junit.After
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.mockito.Mock

import org.mockito.MockitoAnnotations

class JsonConverterTest {

    @Mock
    private var jsonConverter: JsonConverter? = null

    @Mock
    private var app: Application? = null

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
    }


    @Test
    fun testReturnsJsonSource(){
        var string = jsonConverter?.getJSONResource(app!!,"words")
        assertNotNull(string)
    }


    @After
    fun cleanup() {
        jsonConverter = null
    }
}