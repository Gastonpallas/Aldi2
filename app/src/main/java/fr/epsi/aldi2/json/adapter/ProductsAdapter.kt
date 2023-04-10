package fr.epsi.aldi2.json.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fr.epsi.aldi2.R
import fr.epsi.aldi2.json.Product
import com.squareup.picasso.Picasso
import fr.epsi.aldi2.ProductsDetailActivity

class ProductsAdapter(val products: ArrayList<Product>): RecyclerView.Adapter<ProductsAdapter.ViewHolder>(){
    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): ProductsAdapter.ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.cell_products, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products.get(position)

        holder.textViewProductName.text = product.name
        holder.textViewProductDescription.text = product.description
        Picasso.get().load(product.picture_url).into(holder.imageViewProduct)

        holder.layoutContent.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(holder.layoutContent.context, ProductsDetailActivity::class.java)
            newIntent.putExtra("title", product.name)
            newIntent.putExtra("picture_url", product.picture_url)
            newIntent.putExtra("description", product.description)
            holder.layoutContent.context.startActivity(newIntent)
        })
    }

    override fun getItemCount(): Int {
        return products.size
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageViewProduct = view.findViewById<ImageView>(R.id.imageViewProduct)
        val textViewProductName = view.findViewById<TextView>(R.id.textViewProductName)
        val textViewProductDescription = view.findViewById<TextView>(R.id.textViewProductDescription)
        val layoutContent = view.findViewById<LinearLayout>(R.id.layoutContentProducts)
    }
}