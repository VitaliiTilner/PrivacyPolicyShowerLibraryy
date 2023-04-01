package pl.idreams.privacypolicyshower.core.data.local

interface LinkDatabase {
    suspend fun saveLink(link : String)

    suspend fun getLink() : String?
}