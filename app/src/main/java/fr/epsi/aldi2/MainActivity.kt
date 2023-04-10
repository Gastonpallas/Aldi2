package fr.epsi.aldi2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button

/**
 * La classe MainActivity est l'activité principale de l'application.
 * Elle étend la classe BaseActivity.
 */
class MainActivity : BaseActivity() {

    /**
     * La méthode onCreate est appelée lors de la création de l'activité.
     * Elle configure l'affichage de l'interface utilisateur et les actions des boutons.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setHeaderTitle(getString(R.string.txt_menu))

        //Products
        val buttonStudentsWS = findViewById<Button>(R.id.buttonProduits)
        buttonStudentsWS.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application, CategoriesActivity::class.java)
            startActivity(newIntent)
        })

        // Partie des infos et détails étudiants
        val infosButton = findViewById<Button>(R.id.buttonInfos)
        infosButton.setOnClickListener {
            val intent = Intent(this, InfosActivity::class.java)
            startActivity(intent)
        }
    }
}