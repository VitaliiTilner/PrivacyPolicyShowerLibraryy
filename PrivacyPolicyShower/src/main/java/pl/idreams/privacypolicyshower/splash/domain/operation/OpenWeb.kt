package pl.idreams.privacypolicyshower.splash.domain.operation

import android.app.Activity
import android.content.Intent
import pl.idreams.privacypolicyshower.core.common.Const.Companion.LINK_KEY
import pl.idreams.privacypolicyshower.core.common.Const.Companion.TITLE_KEY
import pl.idreams.privacypolicyshower.core.common.Const.Companion.TRACKER_KEY
import pl.idreams.privacypolicyshower.core.util.web.WebActivity

class OpenWeb(
    private val webActivity: Class<out WebActivity>,
) {
    operator fun invoke(
        activity: Activity,
        link : String,
        tracker : Boolean,
        title : String?,
    ){
        val intent = Intent(activity,webActivity)

        intent.putExtra(LINK_KEY,link)
        intent.putExtra(TRACKER_KEY,tracker)
        intent.putExtra(TITLE_KEY,title)

        activity.startActivity(intent)
    }
}