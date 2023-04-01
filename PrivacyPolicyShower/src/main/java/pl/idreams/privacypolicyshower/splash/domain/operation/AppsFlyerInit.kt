package pl.idreams.privacypolicyshower.splash.domain.operation

import android.app.Activity
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib
import pl.idreams.privacypolicyshower.core.util.crypto_manager.CryptoManager
import pl.idreams.privacypolicyshower.core.util.crypto_manager.CryptoManagerImpl
import pl.idreams.privacypolicyshower.splash.domain.model.AppsData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

internal class AppsFlyerInit {
    operator fun invoke(
        activity: Activity,
        afKey : String,
        cullBack: (AppsData?) -> Unit
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            launch {
                AppsFlyerLib
                    .getInstance()
                    .init(afKey, getConversionListener(cullBack), activity)
                    .start(activity)
            }.join()
        }
    }

    private fun getConversionListener(cullBack: (AppsData?) -> Unit): AppsFlyerConversionListener {
        val crypto : CryptoManager = CryptoManagerImpl()

        return object : AppsFlyerConversionListener {
            override fun onConversionDataSuccess(data: MutableMap<String, Any>?) {
                cullBack(
                    AppsData(
                        aS = data?.getOrDefault(
                            crypto.decrypt("in") +
                                "_${crypto.decrypt("abibca")}",null) as String?,
                        aC = data?.getOrDefault(
                            crypto.decrypt("in") +
                                "_${crypto.decrypt("kpivvmt")}",null) as String?,
                        camp = data?.getOrDefault(crypto.decrypt("kiuxiqov"),null)
                                as String?,
                        mS = data?.getOrDefault(
                            crypto.decrypt("umlqi") +
                                "_${crypto.decrypt("awczkm")}",null) as String?,
                        aA = data?.getOrDefault(
                            crypto.decrypt("in") +
                                "_${crypto.decrypt("il")}",null) as String?,
                        cI = data?.getOrDefault(
                            crypto.decrypt("kiuxiqov") +
                                "_${crypto.decrypt("ql")}",null) as String?,
                        aSI = data?.getOrDefault(
                            crypto.decrypt("ilamb") +
                                "_${crypto.decrypt("ql")}",null) as String?,
                        aI = data?.getOrDefault(
                            crypto.decrypt("il") +
                                "_${crypto.decrypt("ql")}",null) as String?,
                        adS = data?.getOrDefault(crypto.decrypt("ilamb"),null)
                                as String?,
                    )
                )
            }

            override fun onConversionDataFail(error: String?) {
                cullBack(null)
            }

            override fun onAppOpenAttribution(data: MutableMap<String, String>?) {
                cullBack(null)
            }

            override fun onAttributionFailure(error: String?) {
                cullBack(null)
            }

        }
    }
}