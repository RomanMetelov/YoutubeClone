package com.example.youtubeclone

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.FrameLayout
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.youtubeclone.databinding.ActivityMainBinding
import com.example.youtubeclone.fragment.ExploreFragment
import com.example.youtubeclone.fragment.HomeFragment
import com.example.youtubeclone.fragment.LibraryFragment
import com.example.youtubeclone.fragment.SubscriptionsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var toolbar: androidx.appcompat.widget.Toolbar
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var frameLayout: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toolbar = binding.toolbar
        setSupportActionBar(toolbar)

        supportActionBar?.setTitle("")

        bottomNavigationView = binding.bottomNavigation
        frameLayout = binding.frameLayout

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    val homeFragment = HomeFragment()
                    selectedFragment(homeFragment)
                    true
                }
                R.id.explore -> {
                    val exploreFragment = ExploreFragment()
                    selectedFragment(exploreFragment)
                    true
                }
                R.id.publish -> {
                    Toast.makeText(this, "Add a video", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.subscriptions -> {
                    val subscriptionsFragment = SubscriptionsFragment()
                    selectedFragment(subscriptionsFragment)
                    true
                }
                R.id.library -> {
                    val libraryFragment = LibraryFragment()
                    selectedFragment(libraryFragment)
                    true
                }
                else -> false
            }
        }

        bottomNavigationView.selectedItemId = R.id.home

    }

    private fun selectedFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.notification ->{
                Toast.makeText(this, "Notification", Toast.LENGTH_SHORT).show()
            }
            R.id.search -> {
                Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show()

            }
            R.id.account -> {
                Toast.makeText(this, "Account", Toast.LENGTH_SHORT).show()

            }
            else -> super.onOptionsItemSelected(item)
        }
        return false
    }

}
