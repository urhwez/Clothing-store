package com.example.opros

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.opros.databinding.ActivityAuthBinding

class AuthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAuthBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        val view : ConstraintLayout = binding.root
        setContentView(view)

        val userEmail: EditText = findViewById (R.id.user_email_auth)
        val userPassword: EditText = findViewById (R.id.user_password_auth)
        val auth_button: Button = findViewById (R.id.button_auth)
        val reg1: TextView = findViewById(R.id.reg)
        val db = ShopDB.getDB(this)

        auth_button.setOnClickListener {
            val email = userEmail.text.toString().trim()
            val password = userPassword.text.toString().trim()

            if (email == "" || password == "") {
                Toast.makeText(this, "Не все поля заполнены!", Toast.LENGTH_LONG).show()
            }
            else {
                val isAuth = db.getDao().isAuth("sdsd", "sda")

                if (isAuth) {
                    Toast.makeText(this, "Пользователь авторизирован!", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                }
                else {
                    Toast.makeText(this, "Неправильный пароль или логин!", Toast.LENGTH_LONG).show()
                }

            }
        }

        reg1.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}