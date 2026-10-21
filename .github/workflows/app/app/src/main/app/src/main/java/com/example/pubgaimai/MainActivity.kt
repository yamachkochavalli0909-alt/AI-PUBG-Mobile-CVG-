
package com.example.pubgaimai

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.ScrollView
import android.widget.SeekBar

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.statusBarColor = Color.rgb(7, 12, 25)
        window.navigationBarColor = Color.rgb(7, 12, 25)

        val root = LinearLayout(this)
        root.orientation = LinearLayout.VERTICAL
        root.setPadding(24, 30, 24, 24)
        root.setBackgroundColor(Color.rgb(7, 12, 25))

        val scroll = ScrollView(this)
        scroll.addView(root)

        val title = TextView(this)
        title.text = "PUBG AIM AI"
        title.textSize = 30f
        title.setTextColor(Color.rgb(42, 180, 255))
        title.gravity = Gravity.CENTER
        root.addView(title)

        val subtitle = TextView(this)
        subtitle.text = "CYBER BLUE • ИГРОВОЙ ПОМОЩНИК"
        subtitle.textSize = 14f
        subtitle.setTextColor(Color.LTGRAY)
        subtitle.gravity = Gravity.CENTER
        root.addView(subtitle)

        addSlider(root, "Камера", 35)
        addSlider(root, "ADS", 25)
        addSlider(root, "Гироскоп", 280)
        addSlider(root, "Гироскоп ADS", 300)

        val info = TextView(this)
        info.text = "\nПрофили оружия\n\nM416 — стабильный зажим\nAKM — короткие очереди\nTDM — ближний бой\n\nНастройки являются рекомендациями и не изменяют файлы PUBG."
        info.textSize = 17f
        info.setTextColor(Color.WHITE)
        root.addView(info)

        setContentView(scroll)
    }

    private fun addSlider(
        root: LinearLayout,
        name: String,
        initial: Int
    ) {
        val label = TextView(this)
        label.text = "$name: $initial"
        label.textSize = 18f
        label.setTextColor(Color.WHITE)
        label.setPadding(0, 22, 0, 0)
        root.addView(label)

        val slider = SeekBar(this)
        slider.max = 400
        slider.progress = initial
        slider.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(
                    seekBar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {
                    label.text = "$name: $progress"
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {}
                override fun onStopTrackingTouch(seekBar: SeekBar?) {}
            }
        )
        root.addView(slider)
    }
}
