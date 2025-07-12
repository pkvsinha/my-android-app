package com.prashantsinha.tv

import android.os.Bundle
import androidx.fragment.app.FragmentActivity

/**
 * Loads [MainTvFragment].
 */
class MainTvActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_tv)
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_browse_fragment, MainTvFragment())
                .commitNow()
        }
    }
}