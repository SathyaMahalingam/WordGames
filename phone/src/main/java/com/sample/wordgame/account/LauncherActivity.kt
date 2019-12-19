package com.sample.wordgame.account

import android.os.Bundle
import com.sample.wordgame.common.ui.BaseActivity

/**
 * This is launcher screen which hold launcher logic of the application
 */
class LauncherActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navigateToWordBoardScreen()
    }

    /**
     * This method is used to take user to the word board game screen
     */
    private fun navigateToWordBoardScreen(){
        navigationController?.launchWordBoardScreen()
    }
}
