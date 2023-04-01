package pl.idreams.privacypolicyshower.splash.domain.operation

internal class ValidLink {
    operator fun invoke(link : String?) : Boolean{
        return link != null && link != "" && link != "null"
    }
}