package com.developer.anishakd4.indihoodassignment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.developer.anishakd4.indihoodassignment.fragments.overview.OverviewFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(R.id.fragment, OverviewFragment()).commit()
    }
}
