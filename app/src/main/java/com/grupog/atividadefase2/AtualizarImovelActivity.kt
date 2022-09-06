package com.grupog.atividadefase2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.grupog.atividadefase2.adapter.ItemAdapter
import com.grupog.atividadefase2.dao.ImovelDAO
import com.grupog.atividadefase2.databinding.ActivityAtualizarImovelBinding
import com.grupog.atividadefase2.databinding.ActivityDeletarImovelBinding
import com.grupog.atividadefase2.model.Cidadao
import com.grupog.atividadefase2.model.Imovel

class AtualizarImovelActivity : AppCompatActivity() {
    lateinit var binding: ActivityAtualizarImovelBinding

    lateinit var imovelPassado:Imovel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_atualizar_imovel)
        supportActionBar!!.hide()

        binding = ActivityAtualizarImovelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var cidadao: Cidadao = intent.getSerializableExtra("cidadao") as Cidadao


        var imovelDao: ImovelDAO = ImovelDAO(this)

        var listaDeImovel:MutableList<Imovel> = imovelDao.consultarImovel(cidadao.id_cidadao) // Arrumar


        binding = ActivityAtualizarImovelBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val recyclerView: RecyclerView = binding.recyclerView2
        recyclerView.adapter = ItemAdapter(this,listaDeImovel)


        //recebe as variáveis da Activity Anterior (Home Imóveis)
        val enderecoAtual = intent.getStringExtra("endereço_atual")
        val cepAtual = intent.getStringExtra("cep_atual")
        val tamanhoAtual = intent.getStringExtra("tamanho_atual")

        //Preenche os campos de texto editáveis com as informações atuais dos imóveis
        //binding.editTextTextEndereOAtualizarImovel.setText(enderecoAtual)
        //binding.editTextTextCEPAtualizarImovel.setText(cepAtual)
        //binding.editTextTextTamanhoAtualizarImovel.setText(tamanhoAtual)

        //Ações atreladas aos cliques nos botões da tela de Atualizar Imóvel
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

        /*
        binding.buttonCancelarAtualizacao.setOnClickListener({
            var intent = Intent(this,ImoveisActivity::class.java)
            startActivity(intent)
        })
        */

        binding.buttonConfirmacaoDeletarImovel.setOnClickListener({
            //falta inserir função para modificar no banco
            //falta inserir um toast de sucesso
            //Toast.makeText(activity, mensagem, Toast.LENGTH_LONG).show()
            var intent = Intent(this,AlterarDadosImovelActivity::class.java)

            var inscricaoImovel:Int = binding.editTextNumber.text.toString().toInt()


            for (imo in listaDeImovel){
                if (imo.inscricao.toString().toInt() == inscricaoImovel){
                    imovelPassado = imo
                    println("ACHOU ID + ID = ${imo.inscricao}")
                    break
                }
            }


            //imovelPassado = listaDeImovel.first()


            intent.putExtra("imovel", imovelPassado)
            intent.putExtra("cidadao",cidadao)
            startActivity(intent)
        })




    }
}

