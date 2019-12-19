package com.sample.wordgame.account

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.sample.wordgame.wordfinder.ui.WordBoardFragment
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.sample.wordgame.R
import org.junit.Test


@RunWith(AndroidJUnit4::class)
@LargeTest
class LauncherActivityTest {

    @Rule
    @JvmField
    var rule = ActivityTestRule(LauncherActivity::class.java)

    @Before
    fun setup() {
        rule.activity
            .supportFragmentManager.beginTransaction()
            .replace(android.R.id.content, WordBoardFragment.newInstance()).commit()
    }

    @Test
    fun testScanBtnIsDisplayed() {
        onView(withId(R.id.scan_label)).check(matches(isDisplayed()))
    }

    @Test
    fun testBoardViewIsDisplayed() {
        onView(withId(R.id.recyclerView)).check(matches(isDisplayed()))
    }

    @Test
    fun testScanBtnIsClickable() {
        onView(withId(R.id.scan_label)).check(matches(isClickable()))
    }

    @Test
    fun testRefreshIconIsDisplayed() {
        onView(withId(R.id.right_view)).check(matches(isDisplayed()))
    }

    @Test
    fun testMenuIconIsDisplayed() {
        onView(withId(R.id.left_view)).check(matches(isDisplayed()))
    }

    @Test
    fun testRefreshIconIsClickable() {
        onView(withId(R.id.right_view)).check(matches(isClickable()))
    }

    @Test
    fun testMenuIconIsClickable() {
        onView(withId(R.id.left_view)).check(matches(isClickable()))
    }

}