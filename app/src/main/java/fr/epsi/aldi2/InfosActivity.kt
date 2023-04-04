package fr.epsi.aldi2

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * La classe InfosActivity affiche des informations sur les étudiants du groupe ALDI
 * Elle étend la classe BaseActivity.
 */
class InfosActivity : BaseActivity() {
    /* La liste des étudiants.
    */
    private val students = listOf(
        Student(
            R.drawable.gastos,
            "Infos de l'étudiant",
            "PALLAS",
            "Gaston",
            "gaston.pallas@epsi.fr",
            "Groupe ALDI",
            "http://www.epsi.fr/"
        ),
        Student(
            R.drawable.clem,
            "Infos de l'étudiant",
            "LO-CASCIO",
            "Clément",
            "c.locascio@epsi.fr",
            "Groupe ALDI",
            "http://www.epsi.fr/"
        ),
        Student(
            R.drawable.alaa,
            "Infos de l'étudiant",
            "DHIEB",
            "Alaa",
            "alaa.dhieb@epsi.fr",
            "Groupe ALDI",
            "http://www.epsi.fr/"
        )
    )

    /**
     * La méthode onCreate est appelée lors de la création de l'activité.
     * Elle configure l'affichage de la liste des étudiants.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_infos)
        showBack()
        setHeaderTitle("Infos")
        val recyclerView = findViewById<RecyclerView>(R.id.student_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = StudentAdapter(students)
    }
}