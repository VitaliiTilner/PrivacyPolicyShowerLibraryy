package pl.idreams.privacypolicyshower.splash.domain.operation

import android.content.Context
import pl.idreams.privacypolicyshower.core.data.local.LinkSharedPref
import pl.idreams.privacypolicyshower.core.util.web.WebActivity

internal data class SplashOperator(
    val webActivity : Class<out WebActivity>,
    val context : Context,
    val appsFlyerInit: AppsFlyerInit = AppsFlyerInit(),
    val generateLink: GenerateLink = GenerateLink(),
    val getDeepLink: GetDeepLink = GetDeepLink(context),
    val getReferrerData: GetReferrerData = GetReferrerData(),
    val getSystemValues: GetSystemValues = GetSystemValues(context),
    val oneSignalInit: OneSignalInit = OneSignalInit(context),
    val parseValues: ParseValues = ParseValues(),
    val sendOneSignal: SendOneSignal = SendOneSignal(),
    val validLink: ValidLink = ValidLink(),
    val initReferrer: InitReferrer = InitReferrer(),
    val openWeb: OpenWeb = OpenWeb(webActivity),
    val getLink : GetLink = GetLink(LinkSharedPref(context)),
)