package fr.epsi.aldi2

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter(private val students: List<Student>) : RecyclerView.Adapter<StudentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = students[position]
        holder.button.text = student.lastName
        holder.button.setOnClickListener {
            val intent = Intent(holder.itemView.context, StudentDetailActivity::class.java)
            intent.putExtra("avatarResourceId", student.avatarResourceId)
            intent.putExtra("title", student.title)
            intent.putExtra("firstName", student.firstName)
            intent.putExtra("lastName", student.lastName)
            intent.putExtra("email", student.email)
            intent.putExtra("group", student.group)
            intent.putExtra("url", student.url)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount() = students.size
}
