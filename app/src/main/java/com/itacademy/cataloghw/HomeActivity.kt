package com.itacademy.cataloghw

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.itacademy.cataloghw.fragments.GridFragment
import com.itacademy.cataloghw.fragments.LinearFragment

class HomeActivity : AppCompatActivity() {

    private lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        bottomNav = findViewById(R.id.bottom_nav)

        bottomNav.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.linearFragment_bn -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container_home, LinearFragment()).commit()
                }

                R.id.gridFragment_bn -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container_home, GridFragment()).commit()

                }
            }
            true
        }

    }
}