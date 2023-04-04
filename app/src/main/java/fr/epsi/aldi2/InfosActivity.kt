package fr.epsi.aldi2

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class InfosActivity : BaseActivity() {
    private val students = listOf(
        Student(
            R.drawable.icon_back,
            "Infos de l'étudiant",
            "PALLAS",
            "Gaston",
            "gaston.pallas@epsi.fr",
            "Groupe ALDI",
            "http://www.epsi.fr/"
        ),
        Student(
            R.drawable.logo,
            "Infos de l'étudiant",
            "LO-CASCIO",
            "Clément",
            "c.locascio@epsi.fr",
            "Groupe ALDI",
            "http://www.epsi.fr/"
        ),
        Student(
            R.drawable.logo,
            "Infos de l'étudiant",
            "DHIEB",
            "Alaa",
            "alaa.dhieb@epsi.fr",
            "Groupe ALDI",
            "http://www.epsi.fr/"
        )
    )
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