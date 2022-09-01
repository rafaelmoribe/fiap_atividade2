package com.grupog.atividadefase2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.grupog.atividadefase2.databinding.ActivityDeletarImovelBinding

class DeletarImovelActivity : AppCompatActivity() {
    lateinit var binding: ActivityDeletarImovelBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deletar_imovel)
        supportActionBar!!.hide()

        binding = ActivityDeletarImovelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //recebe as variáveis da Activity Anterior (Home Imóveis)
        var inscricaoAtual = intent.getStringExtra("incrição_atual")
        var enderecoAtual = intent.getStringExtra("endereço_atual")

        //Preenche o campo de texto com as informações atuais do imóvel a ser excluído
        var confirmacaoExclusao = "Tem certeza que quer deletar o Imóvel: $inscricaoAtual - $enderecoAtual"
        binding.textViewConfirmacaoDeletarImovel.text = confirmacaoExclusao

        //Ações atreladas aos cliques nos botões da tela de Deletar Imóveis
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

        binding.buttonConfirmacaoDeletarImovel.setOnClickListener({
            //falta inserir função para apagar imovel no banco
            //falta inserir toast de sucesso
            //Toast.makeText(activity, mensagem, Toast.LENGTH_LONG).show()
            var intent = Intent(this,ImoveisActivity::class.java)
            startActivity(intent)
        })

    }
}