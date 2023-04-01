package pl.idreams.privacypolicyshower.core.util.crypto_manager

internal interface CryptoManager {
    fun decrypt(string : String) : String
}