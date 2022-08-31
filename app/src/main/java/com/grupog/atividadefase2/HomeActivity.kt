package com.grupog.atividadefase2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.grupog.atividadefase2.dao.DataBase
import com.grupog.atividadefase2.databinding.ActivityHomeBinding
import com.grupog.atividadefase2.databinding.ActivityMainBinding
import com.grupog.atividadefase2.model.Cidadao
import com.grupog.atividadefase2.dao.CidadaoDAO as CidadaoDAO1

class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding
    //lateinit var user: com.grupog.atividadefase2.dao.CidadaoDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportActionBar!!.hide()

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //var user_cpf = user.listarCpf("00").toString()
        //binding.textViewGreeting.text = "Olá, $user_cpf"
        var teste = DataBase.getDataBase(this).getCidadao("00")
        binding.textViewGreeting.text = "Olá, ${teste.nome}, tudo ${teste.senha}, com ${teste.cpf}, você ${teste.id_cidadao}"

        binding.buttonGerenciarMeusImoveis.setOnClickListener({
            var intent = Intent(this,ImoveisActivity::class.java)
            startActivity(intent)
        }
        )

        binding.buttonHeaderLogout2.setOnClickListener({
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        })
    }
}