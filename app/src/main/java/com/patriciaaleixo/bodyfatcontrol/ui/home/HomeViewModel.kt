package com.patriciaaleixo.bodyfatcontrol.ui.home

import android.view.View
import androidx.lifecycle.ViewModel
import com.patriciaaleixo.bodyfatcontrol.data.repositories.UserRepository
import com.patriciaaleixo.bodyfatcontrol.utils.startLoginActivity

class HomeViewModel(
    private val repository: UserRepository
) : ViewModel() {

    val user by lazy {
        repository.currentUser()
    }

    fun logout(view: View){
        repository.logout()
        view.context.startLoginActivity()
    }
}