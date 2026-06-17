package com.example

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.uiautomator.UiDevice
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MyNewTest {

    @Test
    fun testAppInstalled() {
        val device = UiDevice.getInstance(
            androidx.test.platform.app.InstrumentationRegistry.getInstrumentation()
        )
        val packages = device.executeShellCommand("pm list packages com.whatsapp")
        assertTrue("WhatsApp should be installed", packages.contains("com.whatsapp"))
    }
}
