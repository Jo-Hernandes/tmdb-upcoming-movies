package com.jhernandes.upcomingmovies.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jhernandes.upcomingmovies.R
import com.jhernandes.upcomingmovies.commons.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow()
        }
    }

}
