package com.stevenbrown.stevesapp

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import com.stevenbrown.stevesapp.databinding.ActivityMainBinding

class MainActivity: AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.stevesDrawerNavigationView.setNavigationItemSelectedListener(this)

        supportFragmentManager.beginTransaction()
            .replace(R.id.steves_main_activity_frame, MainFragment.newInstance())
            .commit()

        setContentView(binding.root)
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        Toast.makeText(this, "You reposted $menuItem in the wrong neighborhood!", Toast.LENGTH_SHORT).show()
        binding.stevesDrawerLayout.closeDrawers()
        return true
    }
}