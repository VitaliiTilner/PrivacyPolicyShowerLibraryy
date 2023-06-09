package pl.idreams.privacypolicyshower.splash.domain.operation

import android.app.Activity
import com.android.installreferrer.api.InstallReferrerClient
import com.android.installreferrer.api.InstallReferrerStateListener

internal class InitReferrer {
     operator fun invoke(activity: Activity,cullBack :(String?) -> Unit){

        try {
            val referrerClient = InstallReferrerClient.newBuilder(activity).build()

            referrerClient.startConnection(object : InstallReferrerStateListener {
                override fun onInstallReferrerSetupFinished(responseCode: Int) {
                    when (responseCode) {
                        InstallReferrerClient.InstallReferrerResponse.OK -> {
                            val installReferrer = referrerClient.installReferrer.installReferrer
                            cullBack(installReferrer)
                        }
                        else -> {
                             cullBack(null)
                        }
                    }
                    referrerClient.endConnection()
                }
                override fun onInstallReferrerServiceDisconnected() {
                    cullBack(null)
                }
            })
        }catch (e: Exception){
            cullBack(null)
        }

    }
}
