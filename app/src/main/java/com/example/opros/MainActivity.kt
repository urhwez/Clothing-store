package com.example.opros

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.room.Room
import com.example.opros.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view : ConstraintLayout = binding.root
        setContentView(view)











        val userEmail: EditText = findViewById (R.id.user_email)
        val userPassword: EditText = findViewById (R.id.user_password)
        val reg_button: Button = findViewById (R.id.button)
        val auth: TextView = findViewById(R.id.auth)





        val db = ShopDB.getDB(this)
        val product = Product(null, "nb", "Беговые кроссовки New Balance","New Balance",9999,8999, "Кожа", "Зелёный", 1, true)
        val product1 = Product(null, "lewis", "Синие джинсы Lewi's", "Lewi's",9999,8999, "Хлопок", "Синий", 2, true)
        val product2 = Product(null, "adidas", "Спортивная футболка Adidas", "Adidas",2999,999, "Хлопок", "Синий", 3, true)
        db.getDao().insertProduct(product)
        db.getDao().insertProduct(product1)
        db.getDao().insertProduct(product2)

        auth.setOnClickListener {
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }

        reg_button.setOnClickListener {
            val email = userEmail.text.toString().trim()
            val password = userPassword.text.toString().trim()

            if (email == "" || password == "") {
                Toast.makeText(this, "Не все поля заполнены!", Toast.LENGTH_LONG).show()
            }
            else {
                val user = Users(null, email, password)
                Thread{
                    db.getDao().insertUsers(user)
                }.start()
                Toast.makeText(this, "Пользователь добавлен!", Toast.LENGTH_LONG).show()

            }
        }
    }
}