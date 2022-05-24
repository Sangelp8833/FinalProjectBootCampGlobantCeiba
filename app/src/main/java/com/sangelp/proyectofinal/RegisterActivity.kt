package com.sangelp.proyectofinal

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.google.android.material.textfield.TextInputEditText

class RegisterActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)
    }

    override fun onResume() {
        super.onResume()
        val arrowBack : ImageView = findViewById(R.id.arrow_back)
        val inputNombre : TextInputEditText = findViewById(R.id.input_nombre)
        val inputCorreo : TextInputEditText = findViewById(R.id.input_correo)
        val inputContrasenia : TextInputEditText = findViewById(R.id.input_contraseña)
        val registerButton : Button = findViewById(R.id.register_button)


        arrowBack.setOnClickListener {
            finish()
        }

        inputNombre.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                inputCorreo.addTextChangedListener {
                    inputContrasenia.addTextChangedListener {
                        registerButton.isEnabled = inputNombre.text.toString().isNotEmpty()
                                && inputCorreo.text.toString().isNotEmpty()
                                && inputContrasenia.text.toString().isNotEmpty()
                    }
                }
            }
        })

    }
}