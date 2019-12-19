package com.sample.wordgame.common.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

/**
 * This class has all fragment transaction related operations
 */
class FragmentHelper {

    companion object{

        /**
         * Adds the fragment
         */
        fun add(mgr: FragmentManager,id: Int, fragment: Fragment,tag: String){
            mgr.beginTransaction().add(id,fragment,tag).commitAllowingStateLoss()
        }

        /**
         * Adds the fragment to back-stack
         */
        fun addToBackStack(mgr: FragmentManager,id: Int, fragment: Fragment,tag: String){
            mgr.beginTransaction().add(id,fragment,tag).addToBackStack(null).commitAllowingStateLoss()
        }
    }
}