package pl.idreams.privacypolicyshower.splash.domain.model

data class InputData(
    val FBID : String,
    val FBToken : String,
    val FBDecryptionKey : String,
    val AppsFlayerKey : String,
    val OneSignalId : String,
    val bundle : String
)