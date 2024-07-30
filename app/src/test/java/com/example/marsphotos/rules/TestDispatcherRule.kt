package com.example.marsphotos.rules

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.rules.TestWatcher
import org.junit.runner.Description

@OptIn(ExperimentalCoroutinesApi::class)
class TestDispatcherRule(
    private val testDispatcher: TestDispatcher = UnconfinedTestDispatcher(),
) : TestWatcher() {

    // this function executes before any test executes

    override fun starting(description: Description) {
        // changing the test thread to 'testDispatcher' rather than 'main'
        Dispatchers.setMain(testDispatcher)
    }

    override fun finished(description: Description) {
        // resetting back to use the default main thread
        Dispatchers.resetMain()
    }
}