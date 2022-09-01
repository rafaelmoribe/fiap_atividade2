package com.grupog.atividadefase2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.grupog.atividadefase2.databinding.ActivityHomeBinding


class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Ações atreladas aos cliques nos botões da tela Home
        binding.buttonGerenciarMeusImoveis.setOnClickListener({
            var intent = Intent(this,ImoveisActivity::class.java)
            startActivity(intent)
        }
        )

        binding.buttonIPTU.setOnClickListener( {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://recifeemdia.recife.pe.gov.br/emitirDamIptu"))
            startActivity(i)
        })

        binding.buttonLicitacoes.setOnClickListener( {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.recife.pe.gov.br/portalcompras/app/home.php"))
            startActivity(i)
        })

        binding.buttonRegulacoes.setOnClickListener( {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("http://transparencia.recife.pe.gov.br/codigos/web/estaticos/estaticos.php?nat=CON#filho"))
            startActivity(i)
        })

        binding.buttonCovid19.setOnClickListener( {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://minhavacina.recife.pe.gov.br/"))
            startActivity(i)
        })

        binding.buttonOutrosServicos.setOnClickListener( {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www2.recife.pe.gov.br/servicos/cidadao"))
            startActivity(i)
        })

        binding.buttonHeaderLogout2.setOnClickListener({
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        })
    }
}