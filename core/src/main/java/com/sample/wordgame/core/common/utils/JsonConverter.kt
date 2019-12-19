package com.sample.wordgame.core.common.utils

import android.content.ContentValues
import android.content.Context
import android.util.Log
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import java.io.InputStreamReader

/**
 * This class is used to convert json to specific types
 */
object JsonConverter {

    /**
     * Used to convert json to list of strings
     */
    fun getJSONResource(context: Context,fileName: String): List<String>? {
        try {
            context.assets.open(fileName).use { `is` ->
                val parser = JsonParser()
                var arrayOfWords =  parser.parse(InputStreamReader(`is`)).asJsonArray
                val gson = GsonBuilder().create()
                return gson.fromJson(arrayOfWords,Array<String>::class.java).toList()
            }
        } catch (e: Exception) {
            Log.e(ContentValues.TAG, e.message, e)
        }
        return null
    }
}