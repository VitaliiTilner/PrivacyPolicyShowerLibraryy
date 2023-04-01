package pl.idreams.privacypolicyshower.splash.domain.operation

import android.content.Context
import android.os.BatteryManager
import android.provider.Settings
import com.appsflyer.AppsFlyerLib
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import pl.idreams.privacypolicyshower.splash.domain.model.ValuesData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

internal class GetSystemValues(private val appContext: Context) {
    suspend operator fun invoke(cullBack: (ValuesData) -> Unit){
        withContext(Dispatchers.IO) {

            val batteryLevel: Int? = try {
                val batteryManager =
                    appContext.getSystemService(Context.BATTERY_SERVICE) as BatteryManager

                batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY)
            } catch (e: Exception) {
                100
            }

            val appsFlyerId = AppsFlyerLib.getInstance().getAppsFlyerUID(appContext)

            var advertisingInfo: AdvertisingIdClient.Info? = null

            var gId: String? = null

            val isDevelopmentSettingEnabled = Settings.Global.getInt(
                appContext.contentResolver,
                Settings.Global.DEVELOPMENT_SETTINGS_ENABLED, 0
            ) != 0

            launch {
                try {
                    advertisingInfo =
                        AdvertisingIdClient.getAdvertisingIdInfo(appContext)
                } catch (_: Exception) {
                }
                gId = advertisingInfo?.id
            }.join()

            cullBack(
                ValuesData(
                    batteryLvl = batteryLevel?.toFloat().toString(),
                    appsFlyerId = appsFlyerId,
                    gId = gId,
                    isDevelopmentSettingEnabled = isDevelopmentSettingEnabled
                )
            )
        }
    }
}