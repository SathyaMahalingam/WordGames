package com.sample.wordgame.wordfinder.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.sample.wordgame.R
import com.sample.wordgame.common.ui.BaseActivity
import com.sample.wordgame.common.ui.BaseFragment
import com.sample.wordgame.core.wordfinder.viewmodel.WordBoardViewModel
import com.sample.wordgame.core.wordfinder.viewmodel.utils.WordBoardEventListener
import com.sample.wordgame.databinding.WordBoardFragmentBinding
import com.sample.wordgame.wordfinder.adapter.WordBoardAdapter

/**
 * This WordBoardFragment class acts as view for word board screen
 */

class WordBoardFragment : BaseFragment() {
    private lateinit var binding : WordBoardFragmentBinding
    private lateinit var viewModel : WordBoardViewModel
    private lateinit var boardAdapter : WordBoardAdapter
    private lateinit var eventListener: WordBoardEventListener


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    /**
     * This method is used to initialize essential component needed for this fragment
     * */
    private fun init(){
        viewModel = ViewModelProviders.of(this).get(WordBoardViewModel::class.java)  //  initialize the view model
        eventListener = getModuleCallback(BaseActivity.ModuleType.WORD_BOARD) as WordBoardEventListener  //initialize the Event Listener
        viewModel.setEventListener(eventListener)
        initObservers()
    }

    private fun initObservers() {
        val observerAlphabet = Observer<MutableList<Char>> { value ->
            // Update the UI, in this case, a TextView.
            boardAdapter.addItems(value)
            viewModel.isRandomAlphabetLoading = false
            viewModel.showContentView()
        }
        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        viewModel.randomAlphabet.observe(this, observerAlphabet)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val parentView: View? = super.onCreateView(inflater, container, savedInstanceState)
        binding = DataBindingUtil.inflate(inflater, R.layout.word_board_fragment, container, false)
        setContentView(binding.root,true,viewModel,HeaderViewMode.ABOVE, R.color.colorPrimaryDark)
        binding.viewModel = viewModel
        initViews()
        return parentView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setUpHeaderTheme()
        viewModel.getRandomAlphabet(SPAN_COUNT)
        viewModel.fetchAvailableWordsFromAsset()
    }

    /**
     * Method to initialize toolbar
     */
    private fun setUpHeaderTheme(){
        viewModel.headerTitle(getString(R.string.game_label))
        viewModel.headerLeftImage(resources.getDrawable(R.drawable.ic_menu))
        viewModel.headerRightImage(resources.getDrawable(R.drawable.ic_refresh))
    }

    /**
     * This method is used to Initialize the views
     */
    private fun initViews(){
       val layoutManager = GridLayoutManager(context,
           SPAN_COUNT
       )
        binding.recyclerView.layoutManager = layoutManager
        boardAdapter = WordBoardAdapter(
            context, viewModel.randomAlphabet.value
        )
        binding.recyclerView.adapter = boardAdapter
    }

    /**
     * This method is called to create a instance for this fragment
     */
    companion object {
        const val SPAN_COUNT = 5

        fun newInstance() : WordBoardFragment {
            return WordBoardFragment()
        }
    }

}