package fr.epsi.aldi2

import android.content.Context

data class Student(
    val avatarResourceId: Int,
    val title: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val group: String,
    val url: String
) {
    fun getAvatarUrl(context: Context): String {
        return "android.resource://${context.packageName}/$avatarResourceId"
    }
}
