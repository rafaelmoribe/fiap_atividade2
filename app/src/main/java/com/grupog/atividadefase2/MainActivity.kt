package com.grupog.atividadefase2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.ActionBar
import com.grupog.atividadefase2.dao.CidadaoDAO
import com.grupog.atividadefase2.model.Cidadao

class MainActivity : AppCompatActivity() {

    lateinit var buttonLogin: Button
    lateinit var editTextTextPersonName: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()

        editTextTextPersonName = findViewById<EditText>(R.id.editTextTextPersonName)
        buttonLogin = findViewById<Button>(R.id.button_login)
        buttonLogin.setOnClickListener {
            gravarCidadao()
            var intent = Intent(this,home_activity::class.java)
            startActivity(intent)
        }


    }

    private fun gravarCidadao() {
        var cidadao = Cidadao(
            0,
            editTextTextPersonName.text.toString(),
            "",""
        )

        val cidadaoDAO = CidadaoDAO(this,cidadao)
        cidadaoDAO.gravar()
    }



}