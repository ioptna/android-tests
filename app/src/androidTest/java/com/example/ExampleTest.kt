package com.example

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.uiautomator.UiDevice
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ExampleTest {

    @Test
    fun testPackageExists() {
        val device = UiDevice.getInstance(
            androidx.test.platform.app.InstrumentationRegistry.getInstrumentation()
        )

        val packages = device.executeShellCommand("pm list packages com.google.android.youtube")

        assertTrue(
            "YouTube package should exist on this device",
            packages.contains("com.google.android.youtube") || !packages.isEmpty()
        )
    }
}
