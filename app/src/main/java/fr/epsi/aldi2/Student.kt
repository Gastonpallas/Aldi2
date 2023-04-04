package fr.epsi.aldi2

import android.content.Context
import android.text.SpannableString
import android.text.Spanned
import android.text.style.URLSpan

/**
 * La classe Student représente un étudiant avec ses informations de base.
 * Elle peut fournir une URL pour son avatar et pour son site web, ainsi qu'un lien URL formatté pour son site web.
 */
data class Student(
    val avatarResourceId: Int,
    val title: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val group: String,
    val url: String
) {
    /**
     * Retourne l'URL de l'avatar de l'étudiant sous la forme d'une chaîne de caractères.
     */
    fun getAvatarUrl(context: Context): String {
        return "android.resource://${context.packageName}/$avatarResourceId"
    }

    /**
     * Retourne un lien URL formatté pour le site web de l'étudiant.
     */
    fun getUrlSpan(): SpannableString {
        val spannable = SpannableString(url)
        spannable.setSpan(
            URLSpan(url),
            0,
            url.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        return spannable
    }
}