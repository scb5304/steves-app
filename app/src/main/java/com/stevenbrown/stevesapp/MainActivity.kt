package com.stevenbrown.stevesapp

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import com.stevenbrown.stevesapp.databinding.ActivityMainBinding
import com.stevenbrown.stevesapp.places.PlacesFragment

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.stevesDrawerNavigationView.setNavigationItemSelectedListener(this)
        setContentView(binding.root)
        navigateToMenuItemId(R.id.navigation_places)
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        navigateToMenuItemId(menuItem.itemId)
        return true
    }

    private fun navigateToMenuItemId(menuItemId: Int) {
        val fragmentInstance: Fragment = when (menuItemId) {
            R.id.navigation_places -> PlacesFragment.newInstance()
            else -> MainFragment.newInstance()
        }
        supportFragmentManager.beginTransaction()
            .replace(R.id.steves_main_activity_frame, fragmentInstance)
            .commit()
        binding.stevesDrawerLayout.closeDrawers()
    }
}