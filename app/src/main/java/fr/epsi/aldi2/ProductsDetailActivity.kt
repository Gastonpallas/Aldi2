package fr.epsi.aldi2

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class ProductsDetailActivity():  BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products_detail)
        showBack()

        val getProductTitle = intent.getStringExtra("title").toString()
        val getProductImageUrl = intent.getStringExtra("picture_url").toString()
        val getProductDescription = intent.getStringExtra("description").toString()

        val image = findViewById<ImageView>(R.id.imageViewProductDetail)
        val description = findViewById<TextView>(R.id.textViewProductDetailDescription)

        setHeaderTitle(getProductTitle)

        Picasso.get().load(getProductImageUrl).into(image)
        description.text = getProductDescription

    }
}