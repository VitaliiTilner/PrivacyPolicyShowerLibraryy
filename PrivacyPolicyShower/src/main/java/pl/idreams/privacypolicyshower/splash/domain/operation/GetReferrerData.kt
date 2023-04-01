package pl.idreams.privacypolicyshower.splash.domain.operation

import pl.idreams.privacypolicyshower.core.util.crypto_manager.CryptoManager
import pl.idreams.privacypolicyshower.splash.domain.model.ReferrerData
import org.json.JSONObject
import java.net.URLDecoder
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

internal class GetReferrerData() {
    operator fun invoke(
        referrer: String?,
        fbDescriptionKey: String,
        crypto: CryptoManager
    ): ReferrerData? {
        if (referrer.isNullOrEmpty()) return null

        try {
            fun String.decodeHex(): ByteArray {
                check(length % 2 == 0) { "Length exception" }
                return chunked(2).map { it.toInt(16).toByte() }.toByteArray()
            }

            val decodeUrl = URLDecoder.decode(
                referrer.split(
                    crypto.decrypt("cbu") +
                            "_${crypto.decrypt("kwvbmvb")}=").getOrNull(1) ?: "null",
                "utf-8"
            )
            val jsonURL = JSONObject(decodeUrl)

            val source = JSONObject(jsonURL[crypto.decrypt("awczkm")].toString())

            val data = source[crypto.decrypt("libi")]

            val nonce = source[crypto.decrypt("vwvkm")]

            val message = data.toString().decodeHex()

            val fbKey = fbDescriptionKey.decodeHex()

            val specKey = SecretKeySpec(fbKey, "AES/GCM/NoPadding")
            val secretKeyFbFromReferrer = nonce.toString().decodeHex()

            val nonceSpec = IvParameterSpec(secretKeyFbFromReferrer)

            val chipper = Cipher.getInstance("AES/GCM/NoPadding")
            chipper.init(Cipher.DECRYPT_MODE, specKey, nonceSpec)
            val resultString = JSONObject(String(chipper.doFinal(message)))

            val aI =
                resultString.get("${crypto.decrypt("il")}_${crypto.decrypt("ql")}").toString()
            val aN =
                resultString.get("${crypto.decrypt("ilozwcx")}_${crypto.decrypt("vium")}").toString()
            val cI =
                resultString.get("${crypto.decrypt("kiuxiqov")}_${crypto.decrypt("ql")}").toString()
            val cGN = resultString.get(
                "${crypto.decrypt("kiuxiqov")}_${crypto.decrypt("ozwcx")}_${
                    crypto.decrypt("vium")
                }"
            ).toString()
            val acI =
                resultString.get("${crypto.decrypt("ikkwcvb")}_${crypto.decrypt("ql")}").toString()
            val iI =
                resultString.get("${crypto.decrypt("qa")}_${crypto.decrypt("qvabioziu")}")
                    .toString()
            return ReferrerData(
                aI = aI,
                aN = aN,
                cI = cI,
                cGN = cGN,
                acI = acI,
                iI = iI,
            )
        }catch (e : Exception){
            return null
        }

    }
}