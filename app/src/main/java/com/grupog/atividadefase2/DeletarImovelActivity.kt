package com.grupog.atividadefase2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.grupog.atividadefase2.adapter.ItemAdapter
import com.grupog.atividadefase2.dao.ImovelDAO
import com.grupog.atividadefase2.databinding.ActivityDeletarImovelBinding
import com.grupog.atividadefase2.model.Cidadao
import com.grupog.atividadefase2.model.Imovel

class DeletarImovelActivity : AppCompatActivity() {
    lateinit var binding: ActivityDeletarImovelBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deletar_imovel)
        supportActionBar!!.hide()

        var cidadao: Cidadao = intent.getSerializableExtra("cidadao") as Cidadao


        var imovelDao: ImovelDAO = ImovelDAO(this)

        var listaDeImovel: MutableList<Imovel> =
            imovelDao.consultarImovel(cidadao.id_cidadao) // Arrumar


        binding = ActivityDeletarImovelBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val recyclerView: RecyclerView = binding.recyclerView2
        recyclerView.adapter = ItemAdapter(this, listaDeImovel)


        //recebe as variáveis da Activity Anterior (Home Imóveis)
        var inscricaoAtual = intent.getStringExtra("incrição_atual")
        var enderecoAtual = intent.getStringExtra("endereço_atual")

        //Preenche o campo de texto com as informações atuais do imóvel a ser excluído
        var confirmacaoExclusao = "Tem certeza que quer deletar o Imóvel?"
        binding.textViewConfirmacaoDeletarImovel.text = confirmacaoExclusao

        //Ações atreladas aos cliques nos botões da tela de Deletar Imóveis
        binding.buttonHeaderImovel.setOnClickListener({
            var intent = Intent(this, ImoveisActivity::class.java)
            startActivity(intent)
        })

        binding.buttonHeaderHome.setOnClickListener({
            var intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        })

        binding.buttonHeaderLogout.setOnClickListener({
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })

        binding.buttonConfirmacaoDeletarImovel.setOnClickListener({

            var possuiImovelComInscricao: Boolean = false
            var inscricao = binding.editTextNumber.text.toString().toInt()
            for (imovel in listaDeImovel) {
                if (imovel.inscricao.toString().toInt() == inscricao) {
                    possuiImovelComInscricao = true
                    break
                }
            }
            if (possuiImovelComInscricao) {
                imovelDao.apagarImovel(inscricao)
                Toast.makeText(this, "Imóvel apagado com sucesso", Toast.LENGTH_LONG).show()
                finish()
            } else {
                Toast.makeText(this, "Número de inscrição inválido", Toast.LENGTH_LONG).show()
                //finish()
            }

        })

    }
}