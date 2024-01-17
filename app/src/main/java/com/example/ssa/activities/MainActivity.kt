package com.example.ssa.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.ssa.R
import com.example.ssa.databinding.ActivityMainBinding
import com.example.ssa.main_ui.MainFragment
import com.example.ssa.utilites.Navigator

class MainActivity : AppCompatActivity(), Navigator {

    private lateinit var bind: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        bind.skipLoginText.setOnClickListener{
            fragNavigation(MainFragment(), false)
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