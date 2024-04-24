package com.example.opros

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.opros.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()  {
    private lateinit var binding: ActivityMainBinding
    private val viewModel by lazy { dbHelper(Dependencies.dbrepository)}
    override fun onCreate(savedInstanceState: Bundle?) {
        Dependencies.init(applicationContext)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view : ConstraintLayout = binding.root
        setContentView(view)
        val db = Dependencies.shopDB




        val userEmail: EditText = findViewById (R.id.user_email)
        val userPassword: EditText = findViewById (R.id.user_password)
        val reg_button: Button = findViewById (R.id.button)
        val auth: TextView = findViewById(R.id.auth)







        auth.setOnClickListener {
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }

        reg_button.setOnClickListener {
            val email = userEmail.text.toString().trim()
            val password = userPassword.text.toString().trim()
            val newUser = Users(null, email, password)

            if (email == "" || password == "") {
                Toast.makeText(this, "Не все поля заполнены!", Toast.LENGTH_LONG).show()
            }
            else {
                viewModel.insertNewUser(newUser)
                Toast.makeText(this, "Пользователь добавлен!", Toast.LENGTH_LONG).show()

            }
        }
    }
}