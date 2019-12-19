package com.sample.wordgame.core.common.utils

/**
 * This class represents trie data structure
 */
class Trie {

    var root = TrieNode()
    /**
     * This method is used to insert word in trie DS
     */
    fun insert(word: String) {
        var node = root
        for (c in word.toCharArray()) {
            if (node.children[c.minus('a')] == null) {
                node.children[c.minus('a')] = TrieNode()
            }
            node = node.children[c.minus('a')]!!
        }
        node.item = word
    }
    /**
     * This method is used to search word in trie DS
     */
    fun search(word: String): Boolean {
        var node = root
        for (c in word.toCharArray()) {
            if (node.children[c.minus('a')] == null)
                return false
            node = node.children[c.minus('a')]!!
        }
        return node.item == word
    }
    /**
     * This method is used to get word starts with particular string in trie DS
     */
    fun startsWith(prefix: String): Boolean {
        var node = root
        for (c in prefix.toCharArray()) {
            if (node.children[c.minus('a')] == null)
                return false
            node = node.children[c.minus('a')]!!
        }
        return true
    }

    /**
     * This class represents nodes in trie data structure
     */
    inner class TrieNode {
        var children = arrayOfNulls<TrieNode>(26)
        var item = ""
    }
}