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

    val boton: Button = findViewById<Button>(R.id.boton);
    val et1: EditText = findViewById<EditText>(R.id.et1);
    val linear: LinearLayout = findViewById<LinearLayout>(R.id.linear)
    val batman: ImageView = findViewById<ImageView>(R.id.batman)
    private var click = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        boton.setOnClickListener {
            click++;
            if (click == 1) {
                et1.isEnabled = true
                et1.isVisible = true
                boton.text = "FINALIZAR"
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

                    override fun afterTextChanged(s: Editable?) {
                        if (s != null) {
                            if (s.contains("Wayne")) {
                                batman.isVisible = true
                            } else if (s.contains("joker")) {
                                linear.setBackgroundColor(Color.RED);
                                et1.setTextColor(Color.CYAN);
                                boton.setTextColor(Color.CYAN);
                                boton.setBackgroundColor(Color.GRAY);
                                batman.isVisible = false
                            }
                        }
                    }

                })

            } else {
                et1.isEnabled = false
                et1.isVisible = false
                batman.isVisible = false

            }
        }
    }
}