package fr.epsi.aldi2

import android.os.Bundle
import android.text.util.Linkify
import android.widget.ImageView
import android.widget.TextView

class StudentDetailActivity : BaseActivity() {

    // La méthode onCreate est appelée lorsque l'activité est créée
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Définit le layout à utiliser pour cette activité
        setContentView(R.layout.activity_student_detail)

        // Affiche un bouton "Retour" dans la barre d'action
        showBack()

        // Récupère les données passées à l'activité via l'intent
        val avatarResourceId = intent.getIntExtra("avatarResourceId", R.drawable.logo)
        val title = intent.getStringExtra("title")
        val firstName = intent.getStringExtra("firstName")
        val lastName = intent.getStringExtra("lastName")
        val email = intent.getStringExtra("email")
        val group = intent.getStringExtra("group")
        val url = intent.getStringExtra("url")

        // Définit le titre de l'activité comme étant le prénom de l'étudiant
        setHeaderTitle(firstName)

        // Récupère les vues du layout
        val avatarImageView = findViewById<ImageView>(R.id.avatar_image_view)
        val titleView = findViewById<TextView>(R.id.titleView)
        val firstNameView = findViewById<TextView>(R.id.firstNameView)
        val lastNameView = findViewById<TextView>(R.id.lastNameView)
        val emailView = findViewById<TextView>(R.id.emailView)
        val groupView = findViewById<TextView>(R.id.groupView)
        val urlView = findViewById<TextView>(R.id.urlView)

        // Met à jour les vues avec les données de l'étudiant
        avatarImageView.setImageResource(avatarResourceId)
        titleView.text = title
        firstNameView.text = firstName
        lastNameView.text = lastName
        emailView.text = email
        groupView.text = group
        urlView.text = url

        // Ajoute un lien cliquable à la vue URL
        Linkify.addLinks(urlView, Linkify.WEB_URLS)
    }
}
