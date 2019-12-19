package com.sample.wordgame.core.wordfinder

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.sample.wordgame.core.wordfinder.viewmodel.WordBoardViewModel
import com.sample.wordgame.core.wordfinder.viewmodel.utils.WordBoardEventListener
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class WordBoardViewModelTest {

    @Mock
    private var listener: WordBoardEventListener? = null

    @Mock
    private var app: Application? = null

    private var viewModel: WordBoardViewModel? = null


    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        viewModel = WordBoardViewModel(app!!)
    }


    @After
    fun cleanup() {
        viewModel = null
        listener = null
    }
}
