package com.grupog.atividadefase2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.ViewModelProvider
import com.grupog.atividadefase2.dao.ImovelDAO
import com.grupog.atividadefase2.databinding.ActivityMainBinding
import com.grupog.atividadefase2.model.Imovel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()
        gravarImovel()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //vincular com a view model
        mainActivityViewModel = ViewModelProvider.NewInstanceFactory().create(MainActivityViewModel::class.java)

        //a cada alteração nos campos de usuário e senha, calcular a função de segurança
        binding.editTextTextUserCode.doAfterTextChanged {
            mainActivityViewModel.cidadao.value = it.toString().toInt()
            mainActivityViewModel.getSecurityData()
        }

        binding.editTextTextPassword.doAfterTextChanged {
            mainActivityViewModel.senha.value = it.toString()
            mainActivityViewModel.getSecurityData()
        }

        //Validar que ao clicar no botão de Login, o usuário está apto para explorar as outras áreas da aplicação
        binding.buttonLogin.setOnClickListener {
            if (mainActivityViewModel.autorization.value == true){
                var intent = Intent(this,HomeActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this,"Acesso Negado. Favor revisar código de usuário e senha.", Toast.LENGTH_LONG).show()
            }
        }


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