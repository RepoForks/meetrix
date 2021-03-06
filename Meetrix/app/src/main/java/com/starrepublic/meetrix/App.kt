package com.starrepublic.meetrix

import android.content.Context
import android.os.Handler
import android.support.multidex.MultiDex
import android.support.multidex.MultiDexApplication
import com.starrepublic.meetrix.injections.AppComponent
import com.starrepublic.meetrix.injections.AppModule
import com.starrepublic.meetrix.injections.DaggerAppComponent

/**
 * Created by richard on 2016-11-02.
 */
class App() : MultiDexApplication() {
    var appComponent: AppComponent? = null
    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(newBase)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()


        appComponent = DaggerAppComponent.builder().appModule(AppModule(this, Handler())).build();
    }
}

