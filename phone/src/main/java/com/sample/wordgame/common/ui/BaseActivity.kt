package com.sample.wordgame.common.ui

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.sample.wordgame.common.ui.utils.BaseCallback
import com.sample.wordgame.common.utils.NavigationController
import com.sample.wordgame.wordfinder.ui.utils.WordBoardCallback

/**
 * Base Activity for all the activities used in the application
 *
 */
abstract class BaseActivity : FragmentActivity() {

    var navigationController: NavigationController? = null
    private var baseCallback: BaseCallback? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    /**
     * Initialization related code
     */
    private fun init() {
        navigationController = NavigationController(this, supportFragmentManager)
    }


    /**
     * This method will return the implementation of Event Listeners.
     *
     * @param moduleType Module Type
     */
    fun getModuleCallback(moduleType: Int = BaseActivity.ModuleType.NONE): BaseCallback {
        when (moduleType) {
            ModuleType.WORD_BOARD -> baseCallback =
                WordBoardCallback(
                    this,
                    supportFragmentManager,
                    application
                )
            else -> baseCallback = BaseCallback(this, supportFragmentManager, application)
        }
        return baseCallback as BaseCallback
    }

    /**
     * Type of modules in the word game app
     */
    interface ModuleType {
        companion object {
            const val NONE = -1
            const val WORD_BOARD = 0
        }
    }

}
