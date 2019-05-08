package com.ddddl.v2ex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.viewpager2.widget.ViewPager2
import com.ddddl.v2ex.adapter.MainVPAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var vpAdapter: MainVPAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        vpAdapter = MainVPAdapter(supportFragmentManager)
        vp_main.adapter = vpAdapter
        vp_main.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when (position) {
                    0 -> {
                        navigation.selectedItemId = R.id.navigation_home
                    }
                    1 -> {
                        navigation.selectedItemId = R.id.navigation_dashboard
                    }
                    else -> {
                        navigation.selectedItemId = R.id.navigation_notifications
                    }
                }
            }
        })

        navigation.setOnNavigationItemSelectedListener { item: MenuItem ->
            return@setOnNavigationItemSelectedListener when (item.itemId) {
                R.id.navigation_home -> {
                    vp_main.setCurrentItem(0, true)
                    true
                }
                R.id.navigation_dashboard -> {
                    vp_main.setCurrentItem(1, true)
                    true
                }
                R.id.navigation_notifications -> {
                    vp_main.setCurrentItem(2, true)
                    true
                }
                else -> {
                    false
                }
            }
        }


    }


}
