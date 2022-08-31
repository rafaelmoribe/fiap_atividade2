package com.grupog.atividadefase2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.grupog.atividadefase2.databinding.ActivityAtualizarImovelBinding

class AtualizarImovelActivity : AppCompatActivity() {
    lateinit var binding: ActivityAtualizarImovelBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_atualizar_imovel)
        supportActionBar!!.hide()

        binding = ActivityAtualizarImovelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val enderecoAtual = intent.getStringExtra("endereço_atual")
        val cepAtual = intent.getStringExtra("cep_atual")
        val tamanhoAtual = intent.getStringExtra("tamanho_atual")

        binding.editTextTextEndereOAtualizarImovel.setText(enderecoAtual)
        binding.editTextTextCEPAtualizarImovel.setText(cepAtual)
        binding.editTextTextTamanhoAtualizarImovel.setText(tamanhoAtual)

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

        binding.buttonCancelarAtualizacao.setOnClickListener({
            var intent = Intent(this,ImoveisActivity::class.java)
            startActivity(intent)
        })

        binding.buttonAtualizar.setOnClickListener({
            //inserir função para modificar no banco
            //toast de sucesso
            //Toast.makeText(activity, mensagem, Toast.LENGTH_LONG).show()
            var intent = Intent(this,ImoveisActivity::class.java)
            startActivity(intent)
        })
    }
}
