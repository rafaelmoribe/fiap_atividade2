package com.grupog.atividadefase2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.grupog.atividadefase2.dao.CidadaoDAO
import com.grupog.atividadefase2.dao.ImovelDAO
import com.grupog.atividadefase2.databinding.ActivityCadastrarDadosBinding
import com.grupog.atividadefase2.databinding.ActivityMainBinding
import com.grupog.atividadefase2.model.Cidadao
import com.grupog.atividadefase2.model.Imovel

class CadastrarDadosActivity : AppCompatActivity() {

    lateinit var binding: ActivityCadastrarDadosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastrar_dados)

        binding = ActivityCadastrarDadosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCadastrarPessoa.setOnClickListener {
            val cidadao:Cidadao = Cidadao(
                0,
                binding.editTextCadastroNome.text.toString(),
                binding.editTextCPF.text.toString(),
                binding.editTextTelefone.text.toString(),
                binding.editTextSenha.text.toString()
            )
            val cidadaoDAO:CidadaoDAO = CidadaoDAO(this)
            cidadaoDAO.createCidadao(cidadao)
        }



        binding.buttonCadastrarImovel.setOnClickListener {
            val imovel: Imovel = Imovel(
                0,
                binding.editTextInscricao.text.toString(),
                binding.editTextEndereco.text.toString(),
                binding.editTextCEP.text.toString(),
                binding.editTextTamanho.text.toString().toInt(),
                binding.editTextIPTU.text.toString().toDouble(),
                binding.editTextIdCidadao.text.toString().toInt()
            )
            println("CHEGOU AQUI CRIOU O BJETO")
            val imovelDAO:ImovelDAO = ImovelDAO(this)
            imovelDAO.createImovel(imovel)

        }




    }

}