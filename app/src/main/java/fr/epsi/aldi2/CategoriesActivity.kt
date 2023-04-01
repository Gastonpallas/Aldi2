package fr.epsi.aldi2

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.epsi.aldi2.json.Categories
import fr.epsi.aldi2.json.adapter.CategoriesAdapter
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class CategoriesActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)
        setHeaderTitle(getString(R.string.titre_categories))
        showBack()

        val categories = arrayListOf<Categories>()


        val recyclerViewStudents = findViewById<RecyclerView>(R.id.recyclerViewCategories)
        recyclerViewStudents.layoutManager = LinearLayoutManager(this)

        val categoriesAdapter = CategoriesAdapter(categories)
        recyclerViewStudents.adapter = categoriesAdapter


        val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
        val mRequestURL = "https://www.ugarit.online/epsi/categories.json"
        val request = Request.Builder()
            .url(mRequestURL)
            .get()
            .cacheControl(CacheControl.FORCE_NETWORK)
            .build()

        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("Epsi", "############## " + e.message.toString())
            }

            override fun onResponse(call: Call, response: Response) {
                val data = response.body?.string()
                Log.e("Aldi2", "################# response.code:" + response.code)
                if (data != null && response.code == 200) {
                    Log.e("Aldi2", data)
                    val jsCategories = JSONObject(data)
                    val jsArrayCategories = jsCategories.getJSONArray("items")
                    for (i in 0 until jsArrayCategories.length()) {
                        val js = jsArrayCategories.getJSONObject(i)
                        val categorie = Categories(
                            js.optString("title", "Not Found")
                        )
                        categories.add(categorie)
                        runOnUiThread(Runnable {
                            categoriesAdapter.notifyDataSetChanged()
                        })
                    }
                }
            }
        })

    }

}