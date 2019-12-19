package com.sample.wordgame.common.utils

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.text.TextUtils
import com.sample.wordgame.R
/**
 * This class contains all alert dialogs used in the applications
 */
object DialogUtils {

    /**
     * This method displays system default alert dialog.
     *
     * @param context Context
     * @param title Title (optional).
     * @param message Message
     * @param positiveButtonText Positive button text
     * @param negativeButtonText Negative button text (optional).
     * @param positiveButtonListener Positive button callback listener (optional).
     * @param negativeButtonListener Negative button callback listener (optional).
     * @param cancelable Boolean variable to check whether dialog is cancelable or not (optional). By default its cancelable.
     */
    fun displayAlertDialog(context: Context, title: String = "", message: String,
                           positiveButtonText: String, negativeButtonText: String = "",
                           positiveButtonListener: DialogInterface.OnClickListener? = null, negativeButtonListener: DialogInterface.OnClickListener? = null,
                           cancelable: Boolean = true) {
        val builder = AlertDialog.Builder(context, R.style.AppCompatAlertDialogStyle).setMessage(message)
            .setPositiveButton(positiveButtonText, positiveButtonListener).setCancelable(cancelable)
        if (!TextUtils.isEmpty(title))
            builder.setTitle(title)
        if (!TextUtils.isEmpty(negativeButtonText))
            builder.setNegativeButton(negativeButtonText, negativeButtonListener)
        builder.create().show()
    }
}