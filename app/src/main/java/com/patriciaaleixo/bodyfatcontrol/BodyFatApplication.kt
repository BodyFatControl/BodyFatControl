package com.patriciaaleixo.bodyfatcontrol

import android.app.Application
import com.google.firebase.FirebaseApp
import com.patriciaaleixo.bodyfatcontrol.data.firebase.FirebaseSource
import com.patriciaaleixo.bodyfatcontrol.data.repositories.UserRepository
import com.patriciaaleixo.bodyfatcontrol.ui.auth.AuthViewModelFactory
import com.patriciaaleixo.bodyfatcontrol.ui.home.HomeViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class BodyFatApplication : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@BodyFatApplication))
      //  FirebaseApp.initializeApp(this@BodyFatApplication.applicationContext)
        bind() from singleton { FirebaseSource() }
        bind() from singleton { UserRepository(instance()) }
        bind() from provider { AuthViewModelFactory(instance()) }
        bind() from provider { HomeViewModelFactory(instance()) }

    }
}