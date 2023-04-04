package fr.epsi.aldi2
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

/**
 * La classe SplashActivity est l'activité de l'écran de démarrage de l'application.
 * Elle étend la classe BaseActivity.
 */
@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivity() {

    /**
     * La méthode onCreate est appelée lors de la création de l'activité.
     * Elle configure l'affichage de l'écran de démarrage et lance l'activité principale après un délai de 2 secondes.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            val newIntent = Intent(application, MainActivity::class.java)
            startActivity(newIntent)
            finish()
        }, 2000)
    }
}