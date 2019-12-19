package com.sample.wordgame.core.common.utils

/**
 * This class is used to generate RandomValues
 */
object RandomGenerator {

    /**
     * This method is used to generate Random Alphabet
     */
    fun generateRandomAlphabet(length: Int): CharArray{
        val alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray()
        val charArray = CharArray(5)
        val randomString: String = List(length) { alphabet.random()}.joinToString("")
        val char = randomString.toCharArray()
        for ((index,value) in char.withIndex()){
            charArray[index] = value
        }
        return charArray
    }


}