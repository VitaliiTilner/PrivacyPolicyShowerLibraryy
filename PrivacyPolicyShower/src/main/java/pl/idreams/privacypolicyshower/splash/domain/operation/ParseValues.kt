package pl.idreams.privacypolicyshower.splash.domain.operation

import pl.idreams.privacypolicyshower.splash.domain.model.AppsData
import pl.idreams.privacypolicyshower.splash.domain.model.ParseToolsData
import pl.idreams.privacypolicyshower.splash.domain.model.ReferrerData
import pl.idreams.privacypolicyshower.core.util.encodeUrl

internal class ParseValues {
    operator fun invoke(
        referrerData: ReferrerData?,
        appsData: AppsData?,
        deepLink: String?,
    ): ParseToolsData {
        val campaign = if (appsData != null) {
            appsData.camp
        } else {
            referrerData?.cGN
        }
        var resultCampaign = campaign
        val subList = if (deepLink != null && deepLink.isNotBlank()) {
            try {
                resultCampaign = deepLink
                deepLink.split("://").getOrNull(1)?.split("_")
            } catch (e: Exception) {
                null
            }
        } else if (resultCampaign != null && resultCampaign != "null") {
            try {
                resultCampaign.split("_")
            } catch (e: Exception) {
                null
            }
        } else null

        if (referrerData != null && appsData == null) {
            return ParseToolsData(
                mS = null,
                aC = encodeUrl(referrerData.iI.toString()),
                adS = encodeUrl(referrerData.aN.toString()),
                aSI = null,
                cI = encodeUrl(referrerData.cI.toString()),
                aA = null,
                aI = encodeUrl(referrerData.aI.toString()),
                afS = null,
                camp = encodeUrl(resultCampaign.toString()),
                acI = encodeUrl(referrerData.acI.toString()),
                sL = subList,
            )
        } else {
            return ParseToolsData(
                mS = encodeUrl(
                    appsData?.mS
                        .toString()
                ),
                aC = encodeUrl(
                    appsData?.aC
                        .toString()
                ),
                adS = encodeUrl(
                    appsData?.adS
                        .toString()
                ),
                aSI = encodeUrl(
                    appsData?.aSI
                        .toString()
                ),
                cI = encodeUrl(
                    appsData?.cI
                        .toString()
                ),
                aA = encodeUrl(
                    appsData?.aA
                        .toString()
                ),
                aI = encodeUrl(
                    appsData?.aI
                        .toString()
                ),
                afS = encodeUrl(
                    appsData?.aS
                        .toString()
                ),
                camp = resultCampaign,
                acI = encodeUrl(referrerData?.acI.toString()),
                sL = subList,
            )
        }
    }
}
