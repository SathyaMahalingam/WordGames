package com.sample.wordgame.common.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableField
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.sample.wordgame.R
import com.sample.wordgame.common.ui.utils.BaseCallback
import com.sample.wordgame.core.common.viewmodel.BaseViewModel
import com.sample.wordgame.databinding.CommonBaseFragmentBinding
import com.sample.wordgame.wordfinder.ui.utils.WordBoardCallback


/**
 * Base Fragments for all the fragments used in the application.
 */
abstract class BaseFragment : Fragment() {

    private lateinit var baseViewModel: BaseViewModel
    private lateinit var baseBinding: CommonBaseFragmentBinding
    private var themeColorId = 0
    private var baseCallback: BaseCallback? = null

    /**
     * List of HeaderView Modes
     */
    interface HeaderViewMode {
        companion object {
            /**
             * Header View will be added as a overlay over the content view.
             */
            const val OVERLAY = 0

            /**
             * Header View will be added above the content view.
             */
            const val ABOVE = 1
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        baseBinding = DataBindingUtil.inflate(layoutInflater, R.layout.common_base_fragment, container, false)
        return baseBinding.root
    }

    /**
     * Method to initialize base view models
     */
    private fun initViewModel(viewModel: BaseViewModel?) {
        baseViewModel = viewModel ?: ViewModelProviders.of(this).get(BaseViewModel::class.java)
        baseBinding.baseViewModel = baseViewModel
    }

    /**
     * This method will set the content view to the root layout
     *
     * @param view Content view to be shown.
     */
    protected fun setContentView(view : View?,  includeHeader : Boolean = false, viewModel: BaseViewModel? = null, headerViewMode: Int = HeaderViewMode.OVERLAY, themeColorId: Int = 0) {
        baseBinding.contentView.addView(view)
        initViewModel(viewModel)
        baseViewModel.showContentView()
        baseViewModel.showHeaderView(includeHeader)
        this.themeColorId = themeColorId
        if(includeHeader)
            renderHeaderView(headerViewMode)
    }



    /**
     * This method will render the header view based on the Header View Mode.
     *
     * @param headerViewMode Mode. By default Header will be added as overlay over the content.
     */
    private fun renderHeaderView(headerViewMode: Int) {
        var headerBackgroundColorId = themeColorId
        when(headerViewMode) {
            HeaderViewMode.ABOVE -> {
                baseViewModel.stackLayoutBehaviour = ObservableField(HeaderViewMode.ABOVE)
            }
            HeaderViewMode.OVERLAY -> {
                headerBackgroundColorId = R.color.transparent
            }
        }
        //By default back arrow will be added.
        baseViewModel.headerLeftImage(resources.getDrawable(R.drawable.ic_arrow_back, null))
        baseViewModel.screenTheme.set(themeColorId)
        baseViewModel.headerBackground.set(headerBackgroundColorId)
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
                    activity!!,
                    activity?.supportFragmentManager!!,
                    activity?.application!!
                )
            else -> baseCallback = BaseCallback(activity!!, activity?.supportFragmentManager!!, activity?.application!!)
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
