package pl.idreams.privacypolicyshower.web.opearator

import pl.idreams.privacypolicyshower.core.data.local.LinkDatabase

internal class SaveLink(
    private val linkDatabase: LinkDatabase
) {
    suspend operator fun invoke(link : String){
        return linkDatabase.saveLink(link)
    }
}