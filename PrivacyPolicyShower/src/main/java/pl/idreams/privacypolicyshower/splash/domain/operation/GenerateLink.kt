package pl.idreams.privacypolicyshower.splash.domain.operation

import pl.idreams.privacypolicyshower.core.util.crypto_manager.CryptoManagerImpl
import pl.idreams.privacypolicyshower.splash.domain.model.InputData
import pl.idreams.privacypolicyshower.splash.domain.model.ParseToolsData
import pl.idreams.privacypolicyshower.splash.domain.model.ValuesData


internal class GenerateLink{
    operator fun invoke(
        tracker : String,
        parseToolsData: ParseToolsData,
        valuesData: ValuesData?,
        inputData: InputData,
    ): String {
       val crypto = CryptoManagerImpl()
       val linkBuilder = StringBuilder()

        val aC = when (parseToolsData.aC) {
            crypto.decrypt("bzcm") -> {
                crypto.decrypt("Qvabioziu")
            }
            crypto.decrypt("nitam") -> {
                crypto.decrypt("Nikmjwws")
            }
            else -> {
                parseToolsData.aC
            }
        }
        val mS = parseToolsData.mS
            ?: when (parseToolsData.aC) {
                crypto.decrypt("bzcm") -> {
                    crypto.decrypt("Qvabioziu")
                }
                crypto.decrypt("nitam") -> {
                    "${crypto.decrypt("Nikmjwws")} ${crypto.decrypt("Ila")}"
                }
                else -> {
                    parseToolsData.aC
                }
            }

        linkBuilder.apply {
            append(tracker)
            append("${crypto.decrypt("acj")}1=${parseToolsData.sL?.getOrNull(0) ?: "null"}&")
            append("${crypto.decrypt("acj")}2=${parseToolsData.sL?.getOrNull(2) ?: ""}&")
            append("${crypto.decrypt("acj")}3=${parseToolsData.sL?.getOrNull(3) ?: ""}&")
            append("${crypto.decrypt("acj")}4=${parseToolsData.sL?.getOrNull(4) ?: ""}&")
            append("${crypto.decrypt("acj")}5=${parseToolsData.sL?.getOrNull(5) ?: ""}&")
            append("${crypto.decrypt("acj")}6=${parseToolsData.sL?.getOrNull(6) ?: ""}&")
            append("${crypto.decrypt("acj")}7=${parseToolsData.sL?.getOrNull(7) ?: ""}&")
            append("${crypto.decrypt("acj")}8=${parseToolsData.sL?.getOrNull(8) ?: ""}&")
            append("${crypto.decrypt("acj")}9=${parseToolsData.sL?.getOrNull(9) ?: ""}&")
            append("${crypto.decrypt("acj")}10=${parseToolsData.sL?.getOrNull(10) ?: ""}&")
            append("${crypto.decrypt("kiuxiqov")}=${parseToolsData.camp}&")
            append("${crypto.decrypt("ikkwcvb")}_${crypto.decrypt("ql")}=${parseToolsData.acI}&")
            append("${crypto.decrypt("owwotm")}_${crypto.decrypt("ilql")}=${valuesData?.gId}&")
            append("${crypto.decrypt("in")}_${crypto.decrypt("camzql")}=${valuesData?.appsFlyerId}&")
            append("${crypto.decrypt("umlqi")}_${crypto.decrypt("awczkm")}=$mS&")
            append("${crypto.decrypt("in")}_${crypto.decrypt("kpivvmt")}=$aC&")
            append("${crypto.decrypt("in")}_${crypto.decrypt("abibca")}=${parseToolsData.afS}&")
            append("${crypto.decrypt("ilj")}=${valuesData?.isDevelopmentSettingEnabled}&")
            append("${crypto.decrypt("jibbmzg")}=${valuesData?.batteryLvl}&")
            append("${crypto.decrypt("in")}_${crypto.decrypt("il")}=${parseToolsData.aA}&")
            append("${crypto.decrypt("kiuxiqov")}_${crypto.decrypt("ql")}=${parseToolsData.cI}&")
            append("${crypto.decrypt("ilamb")}_${crypto.decrypt("ql")}=${parseToolsData.aSI}&")
            append("${crypto.decrypt("il")}_${crypto.decrypt("ql")}=${parseToolsData.aI}&")
            append("${crypto.decrypt("ilamb")}=${parseToolsData.adS}&")
            append("${crypto.decrypt("jcvltm")}=${inputData.bundle}&")
            append("${crypto.decrypt("xcap")}=${parseToolsData.sL?.getOrNull(1) ?: "null"}&")
            append("${crypto.decrypt("lmd")}_${crypto.decrypt("smg")}=${inputData.AppsFlayerKey}&")
            append("${crypto.decrypt("nj")}_${crypto.decrypt("ixx")}_" +
                    "${crypto.decrypt("ql")}=${inputData.FBID}&")
            append("${crypto.decrypt("nj")}_${crypto.decrypt("ib")}=${inputData.FBToken}&")
        }
        return linkBuilder.toString()
    }
}