package com.sample.wordgame

import androidx.test.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import junit.framework.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ApplicationInstrumentedTest {

    @Test
    fun testApplicationPackageName() {
     // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.sample.wordgame", appContext.packageName)
    }

    @Test
    fun testApplicationName() {
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals(R.string.app_name, appContext.applicationInfo.labelRes)
    }

    @Test
    fun testInitialScreenIsLauncherActivity() {
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals(
            "com.sample.wordgame.account.LauncherActivity",
            appContext.packageManager.getLaunchIntentForPackage(appContext.packageName)?.component?.className
        )
    }
}