package com.sample.wordgame.common.ui.utils

import android.app.Application
import android.content.Context
import com.sample.wordgame.common.ui.BaseActivity
import com.sample.wordgame.core.common.viewmodel.utils.BaseEventListener
/**
 * This class is the base call back for other modules
 */
open class BaseCallback(var context: Context, var fragmentManager: androidx.fragment.app.FragmentManager, var app: Application): BaseEventListener {


    override fun showError(message: String, title: String?) {
        val activity = context as BaseActivity
        activity.navigationController?.showAlert(message, title)
    }

}