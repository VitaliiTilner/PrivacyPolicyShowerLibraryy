package pl.idreams.privacypolicyshower.splash.domain.operation

import pl.idreams.privacypolicyshower.core.util.crypto_manager.CryptoManager
import com.onesignal.OneSignal

internal class SendOneSignal {
    operator fun invoke(push: String?, appsId: String?,crypto : CryptoManager) {
        OneSignal.setExternalUserId(appsId ?: "")
        OneSignal.sendTag(
            "${crypto.decrypt("acj")}_${crypto.decrypt("ixx")}",
            (push ?: crypto.decrypt("wzoivqk"))
        )
    }
}