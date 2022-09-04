package com.grupog.atividadefase2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextWatcher
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.ViewModelProvider
import com.grupog.atividadefase2.dao.ImovelDAO
import com.grupog.atividadefase2.databinding.ActivityCadastrarImovelBinding
import com.grupog.atividadefase2.model.Cidadao
import com.grupog.atividadefase2.model.Imovel

class CadastrarImovelActivity : AppCompatActivity() {
    lateinit var binding: ActivityCadastrarImovelBinding
    lateinit var cadastrarImovelViewModel: CadastrarImovelActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastrar_imovel)
        supportActionBar!!.hide()
        var cidadao: Cidadao = intent.getSerializableExtra("cidadao") as Cidadao


        var imovelDao:ImovelDAO = ImovelDAO(this)
        binding = ActivityCadastrarImovelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //vincular com a view model
        cadastrarImovelViewModel = ViewModelProvider.NewInstanceFactory().create(CadastrarImovelActivityViewModel::class.java)

        //a cada alteração no campo de tamanho do imóvel, atualiza o valor do tamanho na View Model e calcula o IPTU
        binding.editTextTextTamanhoNovoImovel.doAfterTextChanged {
            cadastrarImovelViewModel.tamanho.value = it.toString().toInt()
            cadastrarImovelViewModel.calcularIptu()
        }

        //Ações atreladas aos cliques nos botões da tela de Cadastro
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

        //Ao clicar em cadastrar, será adicionado um novo Imóvel ao banco de dados
        // e será apresentado o valor previsto de IPTU, conforme calculado na View Model
        binding.buttonCadastrarNovoImovel.setOnClickListener({
            gravarImovel(imovelDao,cidadao)
            Toast.makeText(this,"Solicitação Registrada. Previsão de IPTU: R$ ${String.format("%,.2f",cadastrarImovelViewModel.iptu.value)}",Toast.LENGTH_LONG).show()
            var intent = Intent(this,ImoveisActivity::class.java)
            startActivity(intent)
        })

    }

    private fun gravarImovel(imovelDAO: ImovelDAO, cidadao: Cidadao) {

        var imovel = Imovel(
            0,
            binding.editTextTextInscriONovoImovel.text.toString(),
            binding.editTextTextEndereONovoImovel.text.toString(),
            binding.editTextTextCepNovoImovel.text.toString(),
            binding.editTextTextTamanhoNovoImovel.text.toString().toInt(),
            binding.editTextTextTamanhoNovoImovel.text.toString().toInt()*(1+Math.random()), // Nao entendi aqui direito como chamar o metodo para calcular o IPTU...
            cidadao.id_cidadao
        )
        imovelDAO.createImovel(imovel)
        //val imovelDAO = ImovelDAO(this)
        //imovelDAO.createImovel(imovel)
    }



}