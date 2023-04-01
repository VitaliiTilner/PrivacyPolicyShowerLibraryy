package pl.idreams.privacypolicyshower.di

import android.app.Application
import pl.idreams.privacypolicyshower.core.data.local.LinkDatabase
import pl.idreams.privacypolicyshower.core.data.local.LinkSharedPref
import pl.idreams.privacypolicyshower.core.util.crypto_manager.CryptoManager
import pl.idreams.privacypolicyshower.core.util.crypto_manager.CryptoManagerImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object FithModule {

    @Provides
    @Singleton
    fun provideLinkDatabase(app : Application) : LinkDatabase {
        return LinkSharedPref(app)
    }

    @Provides
    @Singleton
    fun provideCryptoManager() : CryptoManager {
        return CryptoManagerImpl()
    }
    
}