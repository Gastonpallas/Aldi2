package fr.epsi.aldi2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : BaseActivity() {

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


    }
}