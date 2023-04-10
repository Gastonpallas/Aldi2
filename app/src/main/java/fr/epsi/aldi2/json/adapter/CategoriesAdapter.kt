package fr.epsi.aldi2.json.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fr.epsi.aldi2.ProductsActivity
import fr.epsi.aldi2.R
import fr.epsi.aldi2.json.Category

class CategoriesAdapter(val categories: ArrayList<Category>) :
    RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): CategoriesAdapter.ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.cell_categories, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoriesAdapter.ViewHolder, position: Int) {
        val category = categories.get(position)

        holder.textViewCategorieTitle.text = category.title
        holder.layoutContent.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(holder.layoutContent.context, ProductsActivity::class.java)
            newIntent.putExtra("title", category.title)
            newIntent.putExtra("products_url", category.products_url)
            holder.layoutContent.context.startActivity(newIntent)
        })
    }

    override fun getItemCount(): Int {
        return categories.size
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewCategorieTitle = view.findViewById<TextView>(R.id.textViewCategorieTitle)
        val layoutContent = view.findViewById<LinearLayout>(R.id.layoutContentCategories)
    }


}