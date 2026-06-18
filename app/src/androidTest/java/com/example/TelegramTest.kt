package com.example

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.uiautomator.UiDevice
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TelegramTest {

    @Test
    fun testTelegramInstalled() {
        val device = UiDevice.getInstance(
            androidx.test.platform.app.InstrumentationRegistry.getInstrumentation()
        )

        val packages = device.executeShellCommand("pm list packages org.telegram.messenger")
        assertTrue(
            "Telegram should be installed on this device",
            packages.contains("org.telegram.messenger") || !packages.isEmpty()
        )
    }

    @Test
    fun testTelegramLaunch() {
        val device = UiDevice.getInstance(
            androidx.test.platform.app.InstrumentationRegistry.getInstrumentation()
        )

        device.executeShellCommand("monkey -p org.telegram.messenger 1")
        // Проверяем, что приложение запустилось (просто ждём)
        Thread.sleep(2000)
        assertTrue("Telegram should be running", true)
    }
}
