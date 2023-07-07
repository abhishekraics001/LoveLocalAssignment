package com.example.lovelocalassigment.ui.main

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.lovelocalassigment.R
import com.example.lovelocalassigment.databinding.ActivityMainBinding
import com.example.lovelocalassigment.databinding.CustomeHeaderBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.Calendar


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        supportActionBar?.hide();
        val toolBarView : CustomeHeaderBinding = binding!!.toolbaView;

        toolBarView.imgLeftMenu.setBackgroundResource(R.drawable.hammer_menu_icon)
        setSupportActionBar(toolBarView.toolbar);

        toolBarView.tvHeaderTitle.text = getHeaderTitle()
        toolBarView.imgLeftMenu.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "This is the dummy implementation", Toast.LENGTH_SHORT).show();
        });
        toolBarView.imgNotificationIcon.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "This is the dummy implementation", Toast.LENGTH_SHORT).show();
        });


        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_dashboard,
                R.id.navigation_shoping,
                R.id.navigation_wallet
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

    }


    fun getHeaderTitle(): String{
         var headerTitleMsg = "John"
        val c: Calendar = Calendar.getInstance()
        val timeOfDay: Int = c.get(Calendar.HOUR_OF_DAY)

        if (timeOfDay >= 0 && timeOfDay < 12) {
            headerTitleMsg = "Good Morning ${headerTitleMsg}"
        } else if (timeOfDay >= 12 && timeOfDay < 16) {
            headerTitleMsg = "Good Afternoon ${headerTitleMsg}"
        } else if (timeOfDay >= 16 && timeOfDay < 21) {
            headerTitleMsg = "Good Evening ${headerTitleMsg}"
        } else if (timeOfDay >= 21 && timeOfDay < 24) {
            headerTitleMsg = "Good Night ${headerTitleMsg}"
        }

        return headerTitleMsg
    }
}