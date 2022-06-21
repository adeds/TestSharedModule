package id.adeds.testsharedmodulelibandroid

import android.app.Application
import id.adeds.sharedmodulekmmlibs.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class MainApp : Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidContext(this@MainApp)
            androidLogger()
            appModule
        }
    }
}