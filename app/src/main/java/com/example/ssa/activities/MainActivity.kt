package com.example.ssa.activities

import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.ssa.R
import com.example.ssa.databinding.ActivityMainBinding
import com.example.ssa.main_ui.MainFragment
import com.example.ssa.main_ui.RegisterFragment
import com.example.ssa.utilites.Navigator

class MainActivity : AppCompatActivity(), Navigator {

    private lateinit var bind: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        //skip past user login + register to access the application
        bind.skipLoginText.setOnClickListener{
            fragNavigation(MainFragment(), false)
        }

        //initiate log in pop up dialog and check authorization
        bind.loginButton.setOnClickListener {
          bind.loginPopUp.logInDialog.visibility = View.VISIBLE
            TODO("Set on touch listener to check for outside touch to close the popup")
            TODO("Inside touch listener block add logic for user interaction of the submit+login button")
        }

        //switch to register screen
        bind.registerButton.setOnClickListener {
            fragNavigation(RegisterFragment(), false)
        }

        //google log in logic and screen switch
        bind.googleSignIn.setOnClickListener {
            TODO(" Add logic for google sign in...integrate google OAuth")
        }
        bind.adminLogin.setOnClickListener {
            val intent = Intent(this, AgentAdminActivity::class.java)
            startActivity(intent)
        }

    }

    override fun fragNavigation(fragment: Fragment, addToStack: Boolean) {
        val container = findViewById<ViewGroup>(R.id.mainActivity)
        container.removeAllViews()

       val transaction = supportFragmentManager
           .beginTransaction()
           .replace(R.id.mainActivity,fragment)
        if(addToStack){
            transaction.addToBackStack(null)
        }
        transaction.commit()
    }
}