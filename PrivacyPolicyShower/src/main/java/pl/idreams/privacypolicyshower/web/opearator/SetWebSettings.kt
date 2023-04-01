package pl.idreams.privacypolicyshower.web.opearator

import android.annotation.SuppressLint
import android.os.Build
import android.webkit.CookieManager
import android.webkit.WebView

internal class SetWebSettings {
    @SuppressLint("SetJavaScriptEnabled")
    operator fun invoke(webView: WebView) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            webView.importantForAutofill = WebView.IMPORTANT_FOR_AUTOFILL_NO_EXCLUDE_DESCENDANTS
        }
        webView.apply {
            CookieManager.getInstance().apply cookies@{
                setAcceptCookie(true)
                setAcceptThirdPartyCookies(this@apply, true)
            }
            isSaveEnabled = true
            isFocusable = true
            isFocusableInTouchMode = true
            isVerticalScrollBarEnabled = false
            isHorizontalScrollBarEnabled = false
            setLayerType(WebView.LAYER_TYPE_HARDWARE, null)
        }

        with(webView.settings) {
            mixedContentMode = 0
            javaScriptEnabled = true
            domStorageEnabled = true
            loadsImagesAutomatically = true
            databaseEnabled = true
            useWideViewPort = true
            allowFileAccess = true
            javaScriptCanOpenWindowsAutomatically = true
            loadWithOverviewMode = true
            allowContentAccess = true
            setSupportMultipleWindows(false)
            builtInZoomControls = true
            displayZoomControls = false
            cacheMode = android.webkit.WebSettings.LOAD_DEFAULT
            userAgentString = userAgentString.replace("; wv", "")
            @Suppress("DEPRECATION") if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.O_MR1) {
                saveFormData = true
            }
        }
    }
}