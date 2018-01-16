package com.example.pranit.mvpshop.util;

import java.util.concurrent.Executor

/**
 * Allow instant execution of tasks.
 */
class SingleExecutors : AppExecutors(instant, instant, instant) {
    companion object {
        private val instant = Executor { command -> command.run() }
    }
}