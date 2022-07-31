package com.example.navbarapp

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment

import androidx.fragment.app.replace
import com.example.navbarapp.databinding.ActivityMainBinding
import com.example.navbarapp.fragments.*

class MainActivity : AppCompatActivity() {
    private val bottomf=bottomFragment()
    private val profilef=profileFragment()
    private val search=searchFragment()
    private lateinit var toogle: ActionBarDrawerToggle
    private val postsf=postsFragment()
    private val friensf=friendFragment()
    private val logoutf=logoutFragment()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replacefrag(bottomf)
        toogle= ActionBarDrawerToggle(this,binding.root,R.string.open,R.string.close)
        binding.root.addDrawerListener(toogle)
        toogle.syncState()
        if (savedInstanceState==null){
            binding.navbar.setOnItemSelectedListener {
                when (it.itemId)
                {
                    R.id.home1->replacefrag(bottomf)
                    R.id.search1->replacefrag(search)
                    R.id.profile1->replacefrag(profilef)


                }
                true
            }
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        binding.navbar2.setNavigationItemSelectedListener{

            when (it.itemId)
            {
                R.id.home3->{replacefrag(bottomf)
                    Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
                }
                R.id.posts->{replacefrag(postsf)
                    Toast.makeText(this, "Posts", Toast.LENGTH_SHORT).show()
                }
                R.id.friends->{replacefrag(friensf)
                    Toast.makeText(this, "Friends", Toast.LENGTH_SHORT).show()
                }
                R.id.logout->{replacefrag(logoutf)
                    Toast.makeText(this, "logged out successfully", Toast.LENGTH_SHORT).show()
                }



            }
            true


        }



    }
    private fun replacefrag(fragment:Fragment){
        if(fragment!=null){
            val transaction=supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frag,fragment)
            transaction.commit()
            binding.root.closeDrawer(GravityCompat.START)
        }
    }
    override fun   onOptionsItemSelected(item: MenuItem):Boolean {


        if (toogle.onOptionsItemSelected(item)) {

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}