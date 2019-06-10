package com.example.convenientplanner

import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.GestureDetector
import android.view.View
import android.view.animation.AnimationUtils

class Doki : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doki)
        fun hideSystemUI() {
            window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE
                    or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_FULLSCREEN)
        }
        hideSystemUI()
        val ban : View = findViewById(R.id.vam_ban)
        val sprite : View = findViewById(R.id.Monika)
        val screamerAnimation: View = findViewById(R.id.screamer_Monika)
        screamerAnimation.visibility = View.INVISIBLE
        sprite.visibility = View.INVISIBLE
        ban.visibility = View.INVISIBLE
        fun monAni(){
        screamerAnimation.visibility = View.VISIBLE
        AnimationUtils.loadAnimation(this, R.anim.screamer).also { screamer_Mon ->
            screamerAnimation.startAnimation(screamer_Mon)
        }
        screamerAnimation.visibility = View.INVISIBLE
        sprite.visibility = View.VISIBLE
        }
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setMessage("Just Monika.")
            .setCancelable(false)
            .setPositiveButton("Ok", DialogInterface.OnClickListener { dialog, i ->
                monAni()
            })
        val alert = dialogBuilder.create()
        alert.setTitle("")
        alert.show()
    }
}
