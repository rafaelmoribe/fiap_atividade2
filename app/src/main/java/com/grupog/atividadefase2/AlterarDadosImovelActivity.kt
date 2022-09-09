package com.grupog.atividadefase2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.grupog.atividadefase2.dao.ImovelDAO
import com.grupog.atividadefase2.databinding.ActivityAlterarDadosImovelBinding
import com.grupog.atividadefase2.databinding.ActivityAtualizarImovelBinding
import com.grupog.atividadefase2.model.Cidadao
import com.grupog.atividadefase2.model.Imovel

class AlterarDadosImovelActivity : AppCompatActivity() {


    lateinit var binding: ActivityAlterarDadosImovelBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alterar_dados_imovel)
        supportActionBar!!.hide()

        var imovel: Imovel = intent.getSerializableExtra("imovel") as Imovel
        var cidadao: Cidadao = intent.getSerializableExtra("cidadao") as Cidadao


        binding = ActivityAlterarDadosImovelBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.editTextTextEndereOAlteradoImovel.setText(
            "${imovel.endereco}",
            TextView.BufferType.EDITABLE
        )

        binding.editTextTextTamanhoAlteradoImovel.setText(
            "${imovel.tamanho.toString()}",
            TextView.BufferType.EDITABLE
        )

        var imovelDAO: ImovelDAO = ImovelDAO(this)

        binding.buttonAlterarDadosImovel.setOnClickListener() {
            if (binding.editTextTextEndereOAlteradoImovel.text.toString() != imovel.endereco) {

                //Alterar o Endereço
                imovelDAO.alterarEnderecoImovel(
                    binding.editTextTextEndereOAlteradoImovel.text.toString(),
                    imovel.inscricao
                )

            }
            if (binding.editTextTextTamanhoAlteradoImovel.text.toString()
                    .toInt() != imovel.tamanho
            ) {

                //Alterar o tamanho (e o IPTU)
                imovelDAO.alterarTamanhoImovel(
                    binding.editTextTextTamanhoAlteradoImovel.text.toString().toInt(),
                    imovel.inscricao
                )


            } else {
                Toast.makeText(this, "Inscrição não encontrada.", Toast.LENGTH_LONG)
            }
            var intent = Intent(this, ImoveisActivity::class.java)
            intent.putExtra("cidadao", cidadao)
            startActivity(intent)


        }


    }
}