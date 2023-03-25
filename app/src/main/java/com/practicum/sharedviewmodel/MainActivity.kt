package com.practicum.sharedviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.practicum.sharedviewmodel.databinding.ActivityMainBinding
import com.practicum.sharedviewmodel.fragments.GetFragment
import com.practicum.sharedviewmodel.fragments.SaveFragment

lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity(), Navigator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null){
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container,SaveFragment.newInstance())
                .commit()
        }
    }

    override fun goBack() {
        onBackPressedDispatcher.onBackPressed()
    }

    override fun openSecondFragment() {
        val fragment = GetFragment.newInstance()

        supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(R.id.fragment_container,fragment)
            .commit()
    }
}