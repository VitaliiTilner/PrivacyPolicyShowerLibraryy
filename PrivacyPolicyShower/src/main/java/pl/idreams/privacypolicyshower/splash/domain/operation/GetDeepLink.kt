package pl.idreams.privacypolicyshower.splash.domain.operation

import android.content.Context
import com.facebook.FacebookSdk
import com.facebook.applinks.AppLinkData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

internal class GetDeepLink (private val context: Context) {
    suspend operator fun invoke(
        fbId:String,
        fbToken : String,
        cullBack : (String?)->Unit
    ){
        withContext(Dispatchers.IO){

            FacebookSdk.apply {
                setApplicationId(fbId)
                setClientToken(fbToken)
                sdkInitialize(context)
                setAdvertiserIDCollectionEnabled(true)
                setAutoInitEnabled(true)
                fullyInitialize()
            }
            AppLinkData.fetchDeferredAppLinkData(context) {
                cullBack(it?.targetUri?.toString())
            }
        }
    }
}