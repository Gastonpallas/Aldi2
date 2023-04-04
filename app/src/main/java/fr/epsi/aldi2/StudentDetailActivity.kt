package fr.epsi.aldi2

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

/**
 *
 *
 */
class StudentDetailActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_detail)
        showBack()

        val avatarResourceId = intent.getIntExtra("avatarResourceId", R.drawable.logo)
        val title = intent.getStringExtra("title")
        val firstName = intent.getStringExtra("firstName")
        val lastName = intent.getStringExtra("lastName")
        val email = intent.getStringExtra("email")
        val group = intent.getStringExtra("group")
        val url = intent.getStringExtra("url")

        setHeaderTitle(firstName)

        val avatarImageView = findViewById<ImageView>(R.id.avatar_image_view)
        val titleView = findViewById<TextView>(R.id.titleView)
        val firstNameView = findViewById<TextView>(R.id.firstNameView)
        val lastNameView = findViewById<TextView>(R.id.lastNameView)
        val emailView = findViewById<TextView>(R.id.emailView)
        val groupView = findViewById<TextView>(R.id.groupView)
        val urlView = findViewById<TextView>(R.id.urlView)

        avatarImageView.setImageResource(avatarResourceId)
        titleView.text = title
        firstNameView.text = firstName
        lastNameView.text = lastName
        emailView.text = email
        groupView.text = group
        urlView.text = url
    }

}
