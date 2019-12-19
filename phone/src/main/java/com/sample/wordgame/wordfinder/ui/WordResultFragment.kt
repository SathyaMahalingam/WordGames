package com.sample.wordgame.wordfinder.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.sample.wordgame.R
import com.sample.wordgame.common.ui.BaseFragment
import com.sample.wordgame.common.utils.BundleConstants
import com.sample.wordgame.core.wordfinder.viewmodel.WordResultViewModel
import com.sample.wordgame.databinding.WordResultFragmentBinding
import com.sample.wordgame.wordfinder.adapter.WordResultAdapter


/**
 * This WordResultFragment class acts as view for word listing screen
 */
class WordResultFragment : BaseFragment() {
    private lateinit var binding : WordResultFragmentBinding
    private lateinit var viewModel : WordResultViewModel
    private lateinit var listAdapter : WordResultAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    /**
     * This method is used to initialize essential component needed for this fragment
     * */
    private fun init(){
        viewModel = ViewModelProviders.of(this).get(WordResultViewModel::class.java)  //  initialize the view model
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val parentView: View? = super.onCreateView(inflater, container, savedInstanceState)
        binding = DataBindingUtil.inflate(inflater, R.layout.word_result_fragment, container, false)
        setContentView(binding.root,true,viewModel,HeaderViewMode.ABOVE, R.color.colorPrimaryDark)
        initViews()

        return parentView
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setUpHeaderTheme()
    }

    /**
     * Method to initialize toolbar
     */
    private fun setUpHeaderTheme(){
        viewModel.headerTitle(getString(R.string.list_words_label))
        viewModel.headerLeftImage(resources.getDrawable(R.drawable.ic_arrow_back))
    }

    /**
     * This method is used to Initialize the views
     */
    private fun initViews(){
        val listFromActivity : MutableList<String>? = arguments?.getStringArrayList(BundleConstants.WORDS_LIST)
        val layoutManager = LinearLayoutManager(context)
        binding.recyclerView.layoutManager = layoutManager
        if(listFromActivity != null && listFromActivity.isNotEmpty()) {
            listAdapter = WordResultAdapter(
                context, listFromActivity
            )
            binding.recyclerView.adapter = listAdapter
        } else {
            viewModel.showEmptyView()
        }

    }

    /**
     * This method is called to create a instance for this fragment
     */
    companion object {
        fun newInstance() : WordResultFragment {
            return WordResultFragment()
        }
    }

}
