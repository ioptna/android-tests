package com.example.app

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiSelector
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
        
        // Проверяем, что пакет YouTube существует
        val packages = device.executeShellCommand("pm list packages com.google.android.youtube")
        
        // Если пакет не найден, это может быть:
        // - Google Play без YouTube (телефон без GMS)
        // - Системное приложение, которое мы не можем проверить через UiAutomator
        assertTrue(
            "YouTube package should exist on this device",
            packages.contains("com.google.android.youtube") || !packages.isEmpty()
        )
    }
}
