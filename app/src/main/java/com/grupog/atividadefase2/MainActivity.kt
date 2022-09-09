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


        mainActivityViewModel =
            ViewModelProvider.NewInstanceFactory().create(MainActivityViewModel::class.java)


        binding.buttonLogin.setOnClickListener {

            val cidadaoDAO: CidadaoDAO = CidadaoDAO(this)


            var cidadao: Cidadao =
                cidadaoDAO.consultarCidadao(binding.editTextTextUserCode.text.toString())

            if (cidadao.id_cidadao > 0) {
                var intent = Intent(this, HomeActivity::class.java)
                Toast.makeText(this, "LOGIN BEM SUCEDIDO", Toast.LENGTH_SHORT).show()
                intent.putExtra("cidadao", cidadao)
                startActivity(intent)


            } else {
                Toast.makeText(this, "Acesso Negado. CPF não encontrado", Toast.LENGTH_LONG).show()
            }
        }


        binding.buttonActivityCadastro.setOnClickListener {
            val intent = Intent(this, CadastrarDadosActivity::class.java)
            startActivity(intent)
        }

    }

}