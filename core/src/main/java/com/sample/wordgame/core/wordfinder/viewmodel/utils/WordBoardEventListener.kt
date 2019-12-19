package com.sample.wordgame.core.wordfinder.viewmodel.utils

import com.sample.wordgame.core.common.viewmodel.utils.BaseEventListener

/**
 * Interface for events happening in Word Board Screen
 *
 */
interface WordBoardEventListener : BaseEventListener{

    /**
     * This method is used to display the words available in board
     */
    fun launchWordListScreen(words: ArrayList<String>?)

}

