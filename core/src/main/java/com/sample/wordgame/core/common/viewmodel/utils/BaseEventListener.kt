package com.sample.wordgame.core.common.viewmodel.utils

/**
 * Interface for events happening in Base Fragment
 *
 */
interface BaseEventListener {

    /**
     * This method is used to show error banners throughout the app
     */
    fun showError(message: String, title: String? = "")

}