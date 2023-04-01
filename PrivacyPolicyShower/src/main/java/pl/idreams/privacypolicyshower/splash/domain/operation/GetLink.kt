package pl.idreams.privacypolicyshower.splash.domain.operation

import pl.idreams.privacypolicyshower.core.data.local.LinkDatabase

internal class GetLink(
    private val linkDatabase: LinkDatabase,
){
    suspend operator fun invoke(): String? {
        return linkDatabase.getLink()
    }
}