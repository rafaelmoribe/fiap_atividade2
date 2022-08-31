package com.grupog.atividadefase2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.grupog.atividadefase2.databinding.ActivityImoveisBinding

class ImoveisActivity : AppCompatActivity() {
    lateinit var binding: ActivityImoveisBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imoveis)
        supportActionBar!!.hide()

        binding = ActivityImoveisBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonHeaderHome.setOnClickListener({
            var intent = Intent(this,HomeActivity::class.java)
            startActivity(intent)
        })

        binding.buttonHeaderLogout.setOnClickListener({
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        })

        binding.buttonCadastrar.setOnClickListener({
            var intent = Intent(this,CadastrarImovelActivity::class.java)
            startActivity(intent)
        })

        binding.imageButtonDeletarImovel1.setOnClickListener({
            var intent = Intent(this,DeletarImovelActivity::class.java)
            intent.putExtra("incrição_atual",binding.textViewInscricaoImovel1.text.toString())
            intent.putExtra("endereço_atual",binding.textViewEndereOImovel1.text.toString())
            startActivity(intent)
        })

        binding.imageButtonEditarImovel1.setOnClickListener({
            var intent = Intent(this,AtualizarImovelActivity::class.java)
            intent.putExtra("endereço_atual",binding.textViewEndereOImovel1.text.toString())
            intent.putExtra("cep_atual",binding.textViewCEPImovel1.text.toString())
            intent.putExtra("tamanho_atual",binding.textViewTamanhoImovel1.text.toString())
            startActivity(intent)
        })

    }
}