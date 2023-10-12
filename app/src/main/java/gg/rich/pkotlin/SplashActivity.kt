package gg.rich.pkotlin

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager.LayoutParams.*
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView


@Suppress("DEPRECATION")
class SplashActivity : Activity() {

    private var context: Context? = null
    private val WELCOME_TIMEOUT = 2000
    private var tv0: TextView? = null
    private var tv1: TextView? = null
    private var tv2: TextView? = null
    private var tv3: TextView? = null
    private var iv: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        supportActionBar?.hide()

        this.window.setFlags(
             FLAG_FULLSCREEN,
             FLAG_FULLSCREEN
        )

        context = this@SplashActivity
        setContentView(R.layout.activity_splash)

        tv0 = findViewById(R.id.tv0)
        tv1 = findViewById(R.id.tv1)
        tv2 = findViewById(R.id.tv2)
        tv3 = findViewById(R.id.tv3)
        iv = findViewById(R.id.iv)

        val myAnim = AnimationUtils.loadAnimation(this, R.anim.mytransition)
        tv0?.startAnimation(myAnim)
        tv1?.startAnimation(myAnim)
        tv2?.startAnimation(myAnim)
        tv3?.startAnimation(myAnim)
        iv?.startAnimation(myAnim)

        Handler().postDelayed({
            goToNextActivity(R.anim.fade_in, R.anim.fade_out)
        }, WELCOME_TIMEOUT.toLong())
    }

    private fun goToNextActivity(animationIn: Int, animationOut: Int) {
        val intent = Intent(context, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
        context?.startActivity(intent)
        overridePendingTransition(animationIn, animationOut)
    }
}