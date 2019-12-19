package com.sample.wordgame.core.common.viewmodel

import android.app.Application
import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import androidx.databinding.ObservableField
import com.sample.wordgame.core.R

/**
 * This class acts as the base view model for all the view model used in this application
 * contains common codes
 */
open class BaseViewModel(app: Application) : AndroidViewModel(app) {

    var showContentView: Boolean = true

    var showEmptyView: Boolean = false

    var showProgressView: Boolean = false

    var showHeaderView: Boolean = false

    private var blockProgressView: ObservableField<Boolean> = ObservableField(true)

    private var progressViewBackground: ObservableField<Int> = ObservableField(R.color.transparent)

    var showTopOverlay: Boolean = false

    var stackLayoutBehaviour: ObservableField<Int> = ObservableField()

    var headerBackground: ObservableField<Int> = ObservableField()

    var screenTheme: ObservableField<Int> = ObservableField()

    var headerLeftImage: Drawable? = null

    var headerRightImage: Drawable? = null

    private var hideHeaderRightButton: ObservableField<Boolean> = ObservableField(false)

    private var hideHeaderLeftButton: ObservableField<Boolean> = ObservableField(false)

    var headerTitle: String = ""


    fun showContentView() {
        showContentView = true
        showEmptyView = false
        showProgressView = false
        notifyChange()
    }

    fun showProgressView() {
        showEmptyView = false
        showProgressView = true
        notifyChange()
    }

    fun showEmptyView() {
        showContentView = false
        showEmptyView = true
        showProgressView = false
        notifyChange()
    }

    fun showHeaderView(show: Boolean) {
        showHeaderView = show
        notifyChange()
    }


    fun setBlockProgressView(enable: Boolean) {
        blockProgressView.set(enable)
    }

    fun getBlockProgressView(): Boolean{
        return blockProgressView.get()  as Boolean
    }

    fun setProgressViewBackground(colorId: Int) {
        progressViewBackground.set(colorId)
        notifyChange()
    }

    fun getProgressViewBackground(): Int {
        return progressViewBackground.get() as Int
    }

    fun headerLeftImage(drawable: Drawable) {
        headerLeftImage = drawable
        notifyChange()
    }

    fun headerRightImage(drawable: Drawable?) {
        headerRightImage = drawable
        notifyChange()
    }
    fun getHideHeaderLeftButton(): Boolean {
        return hideHeaderLeftButton.get()  as Boolean
    }


    fun getHideHeaderRightButton(): Boolean {
        return hideHeaderRightButton.get()  as Boolean
    }

    /**
     * Called when left view is clicked.
     *
     * By default fragment will be popped
     */
    open fun onLeftViewClick(view: View) {
        popFragment(view.context)
    }

    /**
     * This method will pop the fragment from back stack
     */
    private fun popFragment(context: Context) {
        val activity = context as androidx.fragment.app.FragmentActivity
        activity.onBackPressed()
    }

    /**
     * Called when right view is clicked.
     */
    open fun onRightViewClick(view: View) {

    }

    fun headerTitle(title: String){
        headerTitle = title
        notifyChange()
    }
}