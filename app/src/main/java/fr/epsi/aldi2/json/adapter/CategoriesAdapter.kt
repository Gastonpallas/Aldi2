package fr.epsi.aldi2.json.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fr.epsi.aldi2.R
import fr.epsi.aldi2.json.Categories

class CategoriesAdapter(val categories: ArrayList<Categories>) :
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
        val categories = categories.get(position)
        holder.textViewCategorieTitle.text = categories.title
    }

    override fun getItemCount(): Int {
        return categories.size
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewCategorieTitle = view.findViewById<TextView>(R.id.textViewCategorieTitle)

    }


}