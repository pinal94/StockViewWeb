package com.oozee.stockviewweb.Activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.oozee.stockviewweb.R
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        txtStockView.startAnimation(AnimationUtils.loadAnimation(this@SplashActivity, R.anim.fade))
        Handler().postDelayed({
            intent = Intent(this@SplashActivity, MainActivity::class.java)
                .putExtra("serviceURL","http://192.169.232.201:4345/")
            startActivity(intent)
            finish()
        }, 3000)

    }
}
