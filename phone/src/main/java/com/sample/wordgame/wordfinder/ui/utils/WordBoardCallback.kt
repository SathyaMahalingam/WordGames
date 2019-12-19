package com.sample.wordgame.wordfinder.ui.utils

import android.app.Application
import android.content.Context
import com.sample.wordgame.common.ui.BaseActivity
import com.sample.wordgame.common.ui.utils.BaseCallback
import com.sample.wordgame.core.wordfinder.viewmodel.utils.WordBoardEventListener

/**
 * This class acts as call back for word board modules
 */
class WordBoardCallback(context: Context, fragmentManager: androidx.fragment.app.FragmentManager, app: Application) : BaseCallback(context, fragmentManager, app),
    WordBoardEventListener {

    override fun launchWordListScreen(words: ArrayList<String>?) {
        (context as BaseActivity).navigationController?.launchWordsListingScreen(words)
    }
}