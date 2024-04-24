package com.example.opros

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.opros.databinding.ActivityAuthBinding

class AuthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAuthBinding
    private val viewModel by lazy { dbHelper(Dependencies.dbrepository)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        Dependencies.init(applicationContext)
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        val view : ConstraintLayout = binding.root
        setContentView(view)

        val userEmail: EditText = findViewById (R.id.user_email_auth)
        val userPassword: EditText = findViewById (R.id.user_password_auth)
        val auth_button: Button = findViewById (R.id.button_auth)
        val reg1: TextView = findViewById(R.id.reg)


        //val testCategory3 = Category(1, "одежда", "футболка", "спортивная футболка", 3)
        //val testProduct3 = Product(5, "adidas", "Спортивная футболка adidas черного цвета", "adidas", 1999, null,  "хлопок - 100%","черный",1,  1, true)
        // val testCategory1 = Category(2, "одежда", "джинсы", "джинсы", 3)
        //val testProduct1 = Product(2, "lewis", "Джинсы Levi's синего цвета", "lewi's", 14999, null, "хлопок - 100%", "синий",1 , 2, true)
        // val testCategory2 = Category(3, "обувь", "кроссовки", "спортивные кроссовки", 3)
        // val testProduct2 = Product(3, "nb", "Кроссовки new balance серого цвета", "new balance", 14999, null, "кожа - 50%, хлопок - 50% ",  "серый", 3,3, true)

        //viewModel.insertCategory(testCategory3)
         //viewModel.insertNewProduct(testProduct3)
        // viewModel.insertCategory(testCategory1)
        // viewModel.insertNewProduct(testProduct1)
        // viewModel.insertCategory(testCategory2)
        // viewModel.insertNewProduct(testProduct2)




        auth_button.setOnClickListener {
            val email = userEmail.text.toString().trim()
            val password = userPassword.text.toString().trim()

            if (email == "" || password == "") {
                Toast.makeText(this, "Не все поля заполнены!", Toast.LENGTH_LONG).show()
            }
            else {
                viewModel.isAuth(email)
                val a: String = viewModel.auth.toString()



                if (a != "") {
                    Toast.makeText(this, "Пользователь авторизирован!", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, HomeActivity::class.java)
                    Log.d("PIZDA", a)


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