package fr.epsi.aldi2

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("Aldi2","####################### onCreate "+ javaClass.simpleName)
    }

    fun setHeaderTitle( title:String?){
        val textViewTitle= findViewById<TextView>(R.id.textViewTitle)
        textViewTitle.setText(title)
    }

    fun showBack(){
        val imageViewBack=findViewById<ImageView>(R.id.imageViewBack)
        imageViewBack.visibility= View.VISIBLE
        imageViewBack.setOnClickListener(View.OnClickListener {
            finish()
        })
    }

    override fun onStart() {
        super.onStart()
        Log.e("Aldi2","####################### onStart "+ javaClass.simpleName)
    }

    override fun onResume() {
        super.onResume()
        Log.e("Aldi2","####################### onResume "+ javaClass.simpleName)
    }

    override fun onPause() {
        super.onPause()
        Log.e("Aldi2","####################### onPause "+ javaClass.simpleName)
    }

    override fun onStop() {
        super.onStop()
        Log.e("Aldi2","####################### onStop "+ javaClass.simpleName)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("Aldi2","####################### onDestroy "+ javaClass.simpleName)
    }
}