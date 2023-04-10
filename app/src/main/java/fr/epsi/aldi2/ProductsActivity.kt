package fr.epsi.aldi2

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.*
import fr.epsi.aldi2.json.Product
import fr.epsi.aldi2.json.adapter.ProductsAdapter
import org.json.JSONObject
import java.io.IOException

class ProductsActivity() : BaseActivity() {

    var products: ArrayList<Product> = arrayListOf<Product>()
    var productsAdapter: ProductsAdapter = ProductsAdapter(products);

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)
        showBack()

        val category_title = intent.getStringExtra("title").toString()
        val products_url = intent.getStringExtra("products_url").toString()

        setHeaderTitle(category_title)

        val recyclerViewProducts = findViewById<RecyclerView>(R.id.recyclerViewProducts)
        recyclerViewProducts.layoutManager = LinearLayoutManager(this)

        recyclerViewProducts.adapter = this.productsAdapter

        getProductsForCategory(products_url)

    }

    private fun getProductsForCategory(url: String){
        val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
        val request = Request.Builder()
            .url(url)
            .get()
            .cacheControl(CacheControl.FORCE_NETWORK)
            .build()

        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("Epsi", "############## " + e.message.toString())
            }

            override fun onResponse(call: Call, response: Response) {
                val data = response.body?.string()
                if (data != null && response.code == 200) {
                    Log.e("Aldi2", data)
                    val jsCategories = JSONObject(data)
                    val jsArrayCategories = jsCategories.getJSONArray("items")
                    for (i in 0 until jsArrayCategories.length()) {
                        val js = jsArrayCategories.getJSONObject(i)
                        val product = Product(
                            js.optString("name", "Not Found"),
                            js.optString("description", "Not Found"),
                            js.optString("picture_url", "Not Found")
                        )
                        products.add(product)
                        runOnUiThread(Runnable {
                            productsAdapter.notifyDataSetChanged()
                        })
                    }
                }
            }
        })
    }
}