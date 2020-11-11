package com.example.ejerciciolisteners

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val boton: Button = findViewById<Button>(R.id.boton);
        val et1: EditText = findViewById<EditText>(R.id.et1);
        val linear: LinearLayout = findViewById<LinearLayout>(R.id.linear)
        val batman: ImageView = findViewById<ImageView>(R.id.batman)
        var click: Int = 0

        boton.setOnClickListener {
            click++
            if (click % 2 != 0) {
                et1.isEnabled = true
                et1.isVisible = true
                boton.text = "FINALIZAR"
            } else {
                et1.isEnabled = false
                et1.isVisible = false
                et1.text.clear()
                et1.setBackgroundColor(Color.parseColor("#FA92D1"))
                et1.setTextColor(Color.BLACK)
                linear.setBackgroundColor(Color.parseColor("#F0CEE3"));
                batman.isVisible = false
                boton.text = "COMENZAR"
                boton.setTextColor(Color.WHITE);
                boton.setBackgroundColor(Color.parseColor("#4A042F"));
            }
        }

        et1.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                et1.hint = ""
            } else {
                et1.hint = "Introduce tu nombre"
            }
        }

        et1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
            ) {
            }

            override fun onTextChanged(
                    s: CharSequence?,
                    start: Int,
                    before: Int,
                    count: Int
            ) {
            }

            override fun afterTextChanged(s: Editable?){
                if (s != null) {
                    if (s.contains("Wayne")) {
                        batman.isVisible = true
                    } else if (s.contains("joker")) {
                        linear.setBackgroundColor(Color.GRAY);
                        et1.setTextColor(Color.GREEN);
                        et1.setBackgroundColor(Color.parseColor("#B51414"))
                        boton.setTextColor(Color.BLACK);
                        boton.setBackgroundColor(Color.YELLOW);
                        batman.isVisible = false
                    }
                }
            }
        })
    }
}