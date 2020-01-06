package com.oozee.stockviewweb.Activity

import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.oozee.stockviewweb.Global.Utils
import com.oozee.stockviewweb.R
import kotlinx.android.synthetic.main.actionbar.*
import kotlinx.android.synthetic.main.actionbar_app_bar_layout.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var utils: Utils? = null
    private var strURL = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        utils = Utils()
        setActionBar()

        if (utils!!.checkInternetConnection(this)) {
            if (!intent.getStringExtra("serviceURL").equals("")) {
                strURL = intent.getStringExtra("serviceURL")
            }
            progressbar.max = 100
            progressbar.progress = 1
            wvMainView.settings.javaScriptEnabled = true

            wvMainView.webChromeClient = object : WebChromeClient(){
                override fun onProgressChanged(view: WebView?, newProgress: Int) {
                    super.onProgressChanged(view, newProgress)
                    progressbar.progress = newProgress
                }
            }

            wvMainView.loadUrl(strURL)

            wvMainView.webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                    view?.loadUrl(url)
                    return true
                }

                override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                    super.onPageStarted(view, url, favicon)
                    progressbar.visibility = View.VISIBLE
                }

                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    progressbar.visibility = View.GONE
                }
            }
        }
    }

    private fun setActionBar() {
        setSupportActionBar(toolbar)
        txtActionBarTitle.setText(resources.getString(R.string.stockView))
    }
}
