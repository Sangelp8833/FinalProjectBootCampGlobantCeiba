package com.sangelp.proyectofinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import com.bumptech.glide.Glide
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_ProyectoFinal)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    override fun onStart() {
        super.onStart()
        val appleIcon : ImageView = findViewById(R.id.apple_icon)
        val facebookIcon : ImageView = findViewById(R.id.facebook_icon)
        val googleIcon : ImageView = findViewById(R.id.google_icon)

        val appleIconUrl = "https://1000marcas.net/wp-content/uploads/2019/11/Apple-logo-407x500.png"
        Glide.with(this).load(appleIconUrl)
            .circleCrop()
            .error(R.drawable.imdb)
            .into(appleIcon)

        val facebookIconUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/5/51/Facebook_f_logo_%282019%29.svg/1365px-Facebook_f_logo_%282019%29.svg.png"
        Glide.with(this).load(facebookIconUrl)
            .circleCrop()
            .error(R.drawable.imdb)
            .into(facebookIcon)

        val googleIconUrl = "data:image/png;base64,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"
        Glide.with(this).load(googleIconUrl)
            .circleCrop()
            .error(R.drawable.imdb)
            .into(googleIcon)

    }


    override fun onResume() {
        super.onResume()
        val loginButton :Button = findViewById(R.id.login_button)
        val userInputText : TextInputEditText = findViewById(R.id.user_login_edit)
        val passwordInputText : TextInputEditText = findViewById(R.id.psw_login_edit)
        val register : TextView = findViewById(R.id.register_txt)
        val guest : TextView = findViewById(R.id.guest_txt)

        userInputText.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int){
            }

            override fun afterTextChanged(p0: Editable?) {
                passwordInputText.addTextChangedListener {
                    loginButton.isEnabled = userInputText.text.toString().isNotEmpty()
                            && passwordInputText.text.toString().isNotEmpty()
                }
            }

        })

        passwordInputText.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                userInputText.addTextChangedListener {
                    loginButton.isEnabled = userInputText.text.toString().isNotEmpty()
                            && passwordInputText.text.toString().isNotEmpty()
                }
            }

        })

        register.setOnClickListener {
            val toRegister = Intent(this,RegisterActivity::class.java)
            startActivity(toRegister)
        }
        loginButton.setOnClickListener {
            val toNavigation = Intent(this,NavigationActivity::class.java)
            startActivity(toNavigation)
        }
        guest.setOnClickListener {
            val toNavigation = Intent(this,NavigationActivity::class.java)
            startActivity(toNavigation)
        }

    }

}
