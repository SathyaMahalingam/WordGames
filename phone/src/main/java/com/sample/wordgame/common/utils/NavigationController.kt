package com.sample.wordgame.common.utils

import android.content.Context
import android.os.Bundle
import com.sample.wordgame.R
import com.sample.wordgame.wordfinder.ui.WordBoardFragment
import com.sample.wordgame.wordfinder.ui.WordResultFragment

/**
 * This class contains all navigation related logics
 */
class NavigationController(var context: Context, private var fragmentManager: androidx.fragment.app.FragmentManager) {

    /**
     * This method will launch Word Board screen of the application
     */
    fun launchWordBoardScreen() {
        val fragment = WordBoardFragment.newInstance()
        FragmentHelper.add(fragmentManager,android.R.id.content,fragment,
            fragment.javaClass.name
        )
    }


    /**
     * This method will launch the listing screen which contains available 3 letter words in the board
     */
    fun launchWordsListingScreen(wordsAvailable: ArrayList<String>?) {
        val fragment = WordResultFragment.newInstance()
        val bundle = Bundle()
        bundle.putStringArrayList(BundleConstants.WORDS_LIST, wordsAvailable)
        fragment.arguments = bundle
        FragmentHelper.addToBackStack(fragmentManager,android.R.id.content,fragment,
            fragment.javaClass.name)
    }


     /**
     * This method is used to show common user alert
     */
    fun showAlert(message: String, title: String? = "") {
        DialogUtils.displayAlertDialog(context, title = title ?: "",
            message = message,
            positiveButtonText = context.getString(R.string.ok)
        )
    }

}