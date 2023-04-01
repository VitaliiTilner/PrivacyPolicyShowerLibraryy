package pl.idreams.privacypolicyshower.web.di

import pl.idreams.privacypolicyshower.core.data.local.LinkDatabase
import pl.idreams.privacypolicyshower.web.opearator.CreateFile
import pl.idreams.privacypolicyshower.web.opearator.HandleOnBackPressed
import pl.idreams.privacypolicyshower.web.opearator.SaveLink
import pl.idreams.privacypolicyshower.web.opearator.SetWebSettings
import pl.idreams.privacypolicyshower.web.opearator.WebOperator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
internal object WebModule {

    @Provides
    @ActivityScoped
    fun provideWebOperator(
        linkDatabase: LinkDatabase,
    ): WebOperator {
        return WebOperator(
            createFile = CreateFile(),
            handleOnBackPressed = HandleOnBackPressed(),
            setWebSettings = SetWebSettings(),
            saveLink = SaveLink(linkDatabase),
        )
    }
}