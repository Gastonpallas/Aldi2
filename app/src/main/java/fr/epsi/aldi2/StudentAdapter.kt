package fr.epsi.aldi2

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * Adapter pour afficher une liste d'étudiants dans un RecyclerView.
 * @param students la liste d'étudiants à afficher
 */
class StudentAdapter(private val students: List<Student>) : RecyclerView.Adapter<StudentViewHolder>() {

    /**
     *  Crée un nouveau StudentViewHolder pour afficher un élément de la liste.
     *  @param parent le ViewGroup dans lequel la vue sera contenue
     *  @param viewType le type de vue à créer
     *  @return le StudentViewHolder créé
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false)
        return StudentViewHolder(view)
    }

    /**
     *  Lie les données d'un étudiant à la vue correspondante dans le StudentViewHolder.
     *  @param holder le StudentViewHolder dans lequel les données doivent être affichées
     *  @param position la position de l'étudiant dans la liste
     */
    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = students[position]
        holder.button.text = student.lastName
        holder.button.setOnClickListener {
            val intent = Intent(holder.itemView.context, StudentDetailActivity::class.java)
            intent.putExtra("avatarResourceId", student.avatarResourceId)
            intent.putExtra("title", student.title)
            intent.putExtra("firstName", "Nom : " + student.firstName)
            intent.putExtra("lastName", "Prénom : " + student.lastName)
            intent.putExtra("email","Adresse : " + student.email)
            intent.putExtra("group","Groupe : " + student.group)
            intent.putExtra("url","Lien : " + student.url)
            holder.itemView.context.startActivity(intent)
        }
    }

    /**
     *  Retourne le nombre d'étudiants dans la liste.
     *  @return le nombre d'étudiants dans la liste
     */
    override fun getItemCount() = students.size
}