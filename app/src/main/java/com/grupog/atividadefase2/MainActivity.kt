package com.grupog.atividadefase2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.ViewModelProvider
import com.grupog.atividadefase2.dao.CidadaoDAO
import com.grupog.atividadefase2.dao.ImovelDAO
import com.grupog.atividadefase2.databinding.ActivityMainBinding
import com.grupog.atividadefase2.model.Cidadao
import com.grupog.atividadefase2.model.Imovel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //vincular com a view model
        mainActivityViewModel = ViewModelProvider.NewInstanceFactory().create(MainActivityViewModel::class.java)

        //a cada alteração nos campos de usuário e senha, calcular a função de segurança
        /*
        binding.editTextTextUserCode.doAfterTextChanged {
            mainActivityViewModel.cidadao.value = it.toString().toInt()
            mainActivityViewModel.getSecurityData()
        }

        binding.editTextTextPassword.doAfterTextChanged {
            mainActivityViewModel.senha.value = it.toString()
            mainActivityViewModel.getSecurityData()
        }*/


        //Validar que ao clicar no botão de Login, o usuário está apto para explorar as outras áreas da aplicação
        binding.buttonLogin.setOnClickListener {

            val cidadaoDAO:CidadaoDAO = CidadaoDAO(this)
            //println("CODIGO DO USUARIAO")
            //println(binding.editTextTextUserCode.text.toString())

            var cidadao:Cidadao = cidadaoDAO.consultarCidadao(binding.editTextTextUserCode.text.toString())

            if(cidadao.id_cidadao>0){
                var intent = Intent(this,HomeActivity::class.java)
                Toast.makeText(this,"LOGIN BEM SUCEDIDO",Toast.LENGTH_SHORT).show()
                intent.putExtra("cidadao",cidadao)
                startActivity(intent)



            } else {
                Toast.makeText(this,"Acesso Negado. Favor revisar código de usuário e senha.", Toast.LENGTH_LONG).show()
            }
        }


        binding.buttonActivityCadastro.setOnClickListener {
            val intent = Intent(this,CadastrarDadosActivity::class.java)
            startActivity(intent)
        }

    }

}