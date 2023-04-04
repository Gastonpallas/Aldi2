package fr.epsi.aldi2

import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val button: Button = itemView.findViewById(R.id.student_button)
}
