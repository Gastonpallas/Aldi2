package fr.epsi.aldi2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setHeaderTitle(getString(R.string.txt_menu))

        val infosButton = findViewById<Button>(R.id.buttonInfos)

        infosButton.setOnClickListener {
            val intent = Intent(this, InfosActivity::class.java)
            startActivity(intent)
        }
    }
}