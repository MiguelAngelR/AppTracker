package com.mike.core.commons

import android.app.Activity

object ValidationLifeCycle {

    fun isActiveAlive(actiity: Activity) : Boolean {
        return !actiity.isFinishing && !actiity.isDestroyed
    }

}