package no.kristiania.prg208_1_21v_andriod_exam

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT: Long = 3000
    override fun onCreate(savedInstaceState: Bundle?) {
        super.onCreate(savedInstaceState)
        setContentView(R.layout.splash_activity)

        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))

            finish()
        }, SPLASH_TIME_OUT)
    }
}