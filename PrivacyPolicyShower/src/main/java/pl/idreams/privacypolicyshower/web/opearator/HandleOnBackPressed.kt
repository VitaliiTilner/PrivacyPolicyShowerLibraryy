package pl.idreams.privacypolicyshower.web.opearator

import android.os.Handler
import android.os.Looper
import android.webkit.WebView
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.lifecycle.LifecycleOwner

internal class HandleOnBackPressed {
    private var doublePress = false
    operator fun invoke(
        lifecycleOwner : LifecycleOwner,
        webView: WebView,
        url : String,
        onBackPressedDispatcher: OnBackPressedDispatcher
    ){
        onBackPressedDispatcher.addCallback(
            lifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    with(webView) {
                        if (canGoBack()) {
                            if (doublePress) {
                                loadUrl(url)
                            }

                            doublePress = true
                            goBack()
                            Handler(Looper.getMainLooper()).postDelayed({
                                doublePress = false
                            }, 2000)
                        }
                    }
                }
            }
        )
    }
}