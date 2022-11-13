package com.miu.recycleview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.recycler.*
import kotlin.collections.List

class RecycleView : AppCompatActivity(), com.miu.recycleview.List.ItemClickListener {

    val products = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recycler)
        supportActionBar?.title = "Electronics List"

        products.add(Product("Apple AirTag", 27.98, "White & Gray", R.drawable.image2, "#2341234", "Keep track of and find your items alongside friends and devices in the Find My app. AirTag is splash, water, and dust resistant and was tested under controlled laboratory conditions with a rating of IP67 under IEC standard 60529 (maximum depth of 1 meter up to 30 minutes). Splash, water, and dust resistance are not permanent conditions and resistance might decrease as a result of normal wear. Refer to the Safety and Handling documentation for cleaning and drying instructions.\n" +
                "KEEP YOUR PROJECTS SAFE: Experience peace of mind that comes with the most secure Windows ever built with Office, Microsoft Edge, Bing Search, Windows Defender and more\n" +
                "OFFICE 365 FOR ONE YEAR: Get full access to Microsoft Excel, Word, PowerPoint, OneNote, Access, and 1 TB of OneDrive Storage for one year"))
        products.add(Product("Apple AirPods Pro (2nd Generation)", 234.00, "White", R.drawable.image3, "#5554341", "AirPods (each): 0.94 by 0.86 by 1.22 inches (24.0 by 21.8 by 30.9 mm), MagSafe Charging Case: 1.78 by 0.85 by 2.39 inches (45.2 by 21.7 by 60.6 mm).\n" +
                "Up to 6 hours of listening time on a single charge (up to 5.5 hours with Personalized Spatial Audio and Head Tracking enabled), Up to 4.5 hours of talk time with a single charge. AirPods Pro with MagSafe Charging Case: Up to 30 hours of listening time, Up to 24 hours of talk time, 5 minutes in the case provides around 1 hour of listening time or around 1 hour of talk time."))
        products.add(Product("Apple AirPods (3rd Generation)", 159.99, "White", R.drawable.image1, "#4123121", "Apple AirPods (3rd Generation) Wireless Earbuds with Lightning Charging Case. Spatial Audio, Sweat and Water Resistant, Up to 30 Hours of Battery Life. Bluetooth Headphones for iPhone. \n" +
                "Personalized Spatial Audio with dynamic head tracking places sound all around you.\n" +
                "Up to 6 hours of listening time."))
        products.add(Product("Apple AirPods Max", 479.00, "Gray & Silver", R.drawable.image4, "#3382791", "Apple AirPods Max Wireless Over-Ear Headphones. Active Noise Cancelling, Transparency Mode, Spatial Audio, Digital Crown for Volume Control. Bluetooth Headphones for iPhone - Space Gray.\n" +
                "Active Noise Cancellation blocks outside noise, so you can immerse yourself in music.\n" +
                "Transparency mode for hearing and interacting with the world around you.\n"))

        recycler.layoutManager = LinearLayoutManager(this)
        val adapter = List(products, this)
        recycler.adapter = adapter
    }

    override fun onItemClick(position: Int) {
        val detailIntent = Intent(applicationContext, ProductDetail::class.java)
        detailIntent.putExtra("PRODUCT", products[position])
        startActivity(detailIntent)
    }
}