package com.patriciaaleixo.bodyfatcontrol.ui.auth

interface AuthListener {
    fun onStarted()
    fun onSuccess()
    fun onFailure(message: String)
}