package com.grupog.atividadefase2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.grupog.atividadefase2.dao.ImovelDAO
import com.grupog.atividadefase2.databinding.ActivityCadastrarImovelBinding
import com.grupog.atividadefase2.model.Imovel

class CadastrarImovelActivity : AppCompatActivity() {
    lateinit var binding: ActivityCadastrarImovelBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastrar_imovel)
        supportActionBar!!.hide()

        binding = ActivityCadastrarImovelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonHeaderImovel.setOnClickListener({
            var intent = Intent(this,ImoveisActivity::class.java)
            startActivity(intent)
        })

        binding.buttonHeaderHome.setOnClickListener({
            var intent = Intent(this,HomeActivity::class.java)
            startActivity(intent)
        })

        binding.buttonHeaderLogout.setOnClickListener({
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        })

        binding.buttonCadastrarNovoImovel.setOnClickListener({
            gravarImovel()
            Toast.makeText(this,"Seu pedido de cadastro foi registrado.",Toast.LENGTH_LONG).show()
            var intent = Intent(this,ImoveisActivity::class.java)
            startActivity(intent)
        })

    }

    private fun gravarImovel() {
        var imovel = Imovel(
            0,
            binding.editTextTextInscriONovoImovel.text.toString(),
            binding.editTextTextEndereONovoImovel.text.toString(),
            binding.editTextTextCepNovoImovel.text.toString(),
            binding.editTextTextTamanhoNovoImovel.text.toString().toInt(),
            "",
            0
        )

        val imovelDAO = ImovelDAO(this, imovel)
        imovelDAO.createImovel()
    }
}