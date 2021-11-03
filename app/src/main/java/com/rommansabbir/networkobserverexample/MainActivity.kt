package com.rommansabbir.networkobserverexample

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rommansabbir.networkx.NetworkXProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //
        NetworkXProvider.isInternetConnectedLiveData.observe(this) {
            it?.let {
                textView.text = "Internet connection status: $it"
            }
        }

        NetworkXProvider.lastKnownSpeedLiveData.observe(this) {
            it?.let {
                textView2.text =
                    "Last Known Speed: Speed - ${it.speed} | Type - ${it.networkTypeNetwork} | Simplified Speed - ${it.simplifiedSpeed}"
            }
        }

    }

}