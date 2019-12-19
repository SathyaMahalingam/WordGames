package com.sample.wordgame.core.wordfinder.viewmodel

import android.app.Application

import android.view.View
import androidx.lifecycle.MutableLiveData
import com.sample.wordgame.core.R
import com.sample.wordgame.core.common.utils.JsonConverter
import com.sample.wordgame.core.common.utils.RandomGenerator
import com.sample.wordgame.core.common.viewmodel.BaseViewModel
import com.sample.wordgame.core.wordfinder.viewmodel.utils.WordBoardEventListener
import java.util.*


/**
 * WordBoardViewModel class acts as a view model of the word board screen
 */

class WordBoardViewModel(app: Application) : BaseViewModel(app) {
    private lateinit var eventListener: WordBoardEventListener
    var randomAlphabet: MutableLiveData<MutableList<Char>> = MutableLiveData()
    var availableWords: MutableList<String> = mutableListOf()
    var isRandomAlphabetLoading: Boolean = false
    private var resultItems: MutableList<String> = mutableListOf()
    private var gameBoard : Array<CharArray> = Array(5) {CharArray(5)}
    /*private var arrayBoard : Array<CharArray> = arrayOf(
        charArrayOf('c','o','t','a','t'),
        charArrayOf('c','o','t','i','t'),
        charArrayOf('c','o','d','o','g'),
        charArrayOf('a','n','d','a','t'),
        charArrayOf('c','o','m','a','t')
    )*/


    /**
     * This method is used to get random alphabet
     */
    fun getRandomAlphabet(length: Int) {
        if(isRandomAlphabetLoading) return
        showProgressView()
        isRandomAlphabetLoading = true
        var element = mutableListOf<Char>()
        for(i in 0 until length){
            var charArray = (RandomGenerator.generateRandomAlphabet(length))
            gameBoard[i] = charArray
            element.addAll(charArray.toList())
        }
        randomAlphabet.value = element
    }


    /**
     * This method is used to get available words from assets
     */
    fun fetchAvailableWordsFromAsset(){
        val element:  List<String>? = JsonConverter.getJSONResource(
            getApplication(),getApplication<Application>().getString(R.string.file_name))
        availableWords.addAll(element as MutableList<String>)
    }


    /**
     * This method is called on tapping left view header icon
     */
    override fun onLeftViewClick(view: View) {
        //super.onLeftViewClick(view)
    }

    /**
     * This method is called on tapping right view header icon
     */
    override fun onRightViewClick(view: View) {
        //super.onRightViewClick(view)
        //Refresh the board
        getRandomAlphabet(5)
    }


    /**
     * This method is used to set event listener of word board screen
     */
    fun setEventListener(eventListener: WordBoardEventListener) {
      this.eventListener = eventListener
    }


    /**
     * This method is used to scan all the character in the board horizontally and find words
     */
    fun onScanButtonTapped(){
        if(availableWords == null && availableWords.size == 0) {
            eventListener.showError(getApplication<Application>().getString(R.string.loading_wait),"")
        }else {
            //resultItems = findWordsInBoard(arrayBoard, arrayListOf("cot","sam","pet","nap","dog","gat","man","pan",
             //   "men","pad","and","mat")) as MutableList<String>
            showProgressView()
            resultItems.clear()
            resultItems.addAll(findWordsInBoard(gameBoard, availableWords) as MutableList<String>)
            eventListener.launchWordListScreen(resultItems as ArrayList<String>?)
            showContentView()
        }
    }


    inner class TrieNode {
        var children = arrayOfNulls<TrieNode>(26)
        var item = ""
    }

    inner class Trie {

        var root = TrieNode()

        fun insert(word: String) {
            var node = root
            for (c in word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = TrieNode()
                }
                node = node.children[c - 'a']!!
            }
            node.item = word
        }

        fun search(word: String): Boolean {
            var node = root
            for (c in word.toCharArray()) {
                if (node.children[c - 'a'] == null)
                    return false
                node = node.children[c - 'a']!!
            }
            return node.item == word
        }

        fun startsWith(prefix: String): Boolean {
            var node = root
            for (c in prefix.toCharArray()) {
                if (node.children[c - 'a'] == null)
                    return false
                node = node.children[c - 'a']!!
            }
            return true
        }
    }

    /**
     * This method is used to find words present on the board
     */
    private fun findWordsInBoard(board: Array<CharArray>, words: List<String>): List<String> {
        var result = HashSet<String>()
        val trie = Trie()
        for (word in words) {
            trie.insert(word)
        }
        val m = board.size
        val n = board[0].size
        val visited = Array(m) { BooleanArray(n) }
        for (i in 0 until m) {
            for (j in 0 until n) {
                search(board, visited, result,"", i, j, trie)
            }
        }
        return ArrayList(result)
    }

    /**
     * This method uses to search the word available in board
     */
    private fun search(
        board: Array<CharArray>,
        visited: Array<BooleanArray>,
        result: HashSet<String>,
        nodeValue: String,
        i: Int,
        j: Int,
        trie: Trie
    ) {
        var nodeValue = nodeValue
        val m = board.size
        val n = board[0].size

        if (i < 0 || j < 0 || i >= m || j >= n) {
            return
        }

        if (visited[i][j])
            return

        nodeValue += board[i][j]

        if (!trie.startsWith(nodeValue))
            return

        if (trie.search(nodeValue)) {
            result.add(nodeValue)
        }

        visited[i][j] = true
        search(board, visited, result, nodeValue, i, j - 1, trie)
        search(board, visited, result, nodeValue, i, j + 1, trie)
        visited[i][j] = false
    }


}