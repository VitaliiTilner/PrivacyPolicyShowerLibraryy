package pl.idreams.privacypolicyshower.core.data.local

import android.content.Context
import android.content.SharedPreferences
import pl.idreams.privacypolicyshower.core.data.local.LinkDatabase

class LinkSharedPref(
    private val context: Context
    ) : LinkDatabase {
    override suspend fun saveLink(link: String) {
        val sharedPref = context.getSharedPreferences("FithSharedPref",Context.MODE_PRIVATE)
        val editor : SharedPreferences.Editor  = sharedPref.edit()

        editor.putString("data",link)

        editor.apply()
    }

    override suspend fun getLink(): String? {
        val sharedPref = context.getSharedPreferences("FithSharedPref",Context.MODE_PRIVATE)

        return sharedPref.getString("data",null)
    }

}