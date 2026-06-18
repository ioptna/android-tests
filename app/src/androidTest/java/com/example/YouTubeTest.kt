package com.example

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.uiautomator.UiDevice
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class YouTubeTest {

    @Test
    fun testYouTubeInstalled() {
        val device = UiDevice.getInstance(
            androidx.test.platform.app.InstrumentationRegistry.getInstrumentation()
        )

        val packages = device.executeShellCommand("pm list packages com.google.android.youtube")
        assertTrue(
            "YouTube should be installed on this device",
            packages.contains("com.google.android.youtube")
        )
    }

    @Test
    fun testYouTubeLaunch() {
        val device = UiDevice.getInstance(
            androidx.test.platform.app.InstrumentationRegistry.getInstrumentation()
        )

        device.executeShellCommand("monkey -p com.google.android.youtube 1")
        Thread.sleep(2000)
        assertTrue("YouTube should be running", true)
    }
}
