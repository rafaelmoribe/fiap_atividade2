package com.grupog.atividadefase2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.grupog.atividadefase2.dao.CidadaoDAO
import com.grupog.atividadefase2.dao.DataBase
import com.grupog.atividadefase2.dao.ImovelDAO
import com.grupog.atividadefase2.databinding.ActivityMainBinding
import com.grupog.atividadefase2.model.Cidadao
import com.grupog.atividadefase2.model.Imovel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()
        gravarCidadao()
        gravarImovel()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonLogin.setOnClickListener {
            var intent = Intent(this,HomeActivity::class.java)
            startActivity(intent)
        }


    }

    private fun gravarCidadao() {
        var cidadao = Cidadao(
            0,
            "Ariano Suassuna",
            "00",
            "",
            "marco0"
        )

        val cidadaoDAO = CidadaoDAO(this,cidadao)
        cidadaoDAO.createCidadao()
    }

    private fun gravarImovel() {
        var imovel = Imovel(
            0,
            "001",
            "Rua da Aurora, 268",
            "50050-010",
            88,
            "1969",
            0
        )

        val imovelDAO = ImovelDAO(this, imovel)
        imovelDAO.createImovel()
    }




}