package pl.idreams.privacypolicyshower.web.opearator

import pl.idreams.privacypolicyshower.web.opearator.CreateFile
import pl.idreams.privacypolicyshower.web.opearator.HandleOnBackPressed
import pl.idreams.privacypolicyshower.web.opearator.SaveLink
import pl.idreams.privacypolicyshower.web.opearator.SetWebSettings

internal data class WebOperator(
    val createFile: CreateFile,
    val setWebSettings: SetWebSettings,
    val saveLink : SaveLink,
    val handleOnBackPressed: HandleOnBackPressed,
)