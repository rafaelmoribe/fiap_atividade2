package com.grupog.atividadefase2.dao

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.grupog.atividadefase2.model.Cidadao
import com.grupog.atividadefase2.model.Imovel
import java.sql.DatabaseMetaData


class DataBase(context: Context) : SQLiteOpenHelper(context, "prefeitura_Recife.db", null, 1) {

    companion object {
        fun getDataBase(context: Context) : DataBase{
            return DataBase(context)
        }
    }


    override fun onCreate(db: SQLiteDatabase?) {
        //primeira vez que o usuário interage com o banco de dados
        criarTabelaCidadao(db)
        criarTabelaImovel(db)

        populaBanco(db)


    }

    private fun populaBanco(db: SQLiteDatabase?) {

        var dadosCidadao = ContentValues()
        dadosCidadao.put("nome", "Ana") //String
        dadosCidadao.put("cpf", "1") //String
        dadosCidadao.put("telefone", "21-99777") //String
        dadosCidadao.put("senha", "99777") //String
        db?.insert("tbl_cidadao", null, dadosCidadao)

        dadosCidadao = ContentValues()
        dadosCidadao.put("nome", "Bruno") //String
        dadosCidadao.put("cpf", "2") //String
        dadosCidadao.put("telefone", "81-99479") //String
        dadosCidadao.put("senha", "99479") //String
        db?.insert("tbl_cidadao", null, dadosCidadao)

        dadosCidadao = ContentValues()
        dadosCidadao.put("nome", "Rafael") //String
        dadosCidadao.put("cpf", "3") //String
        dadosCidadao.put("telefone", "11-98394") //String
        dadosCidadao.put("senha", "98394") //String
        db?.insert("tbl_cidadao", null, dadosCidadao)

        dadosCidadao = ContentValues()
        dadosCidadao.put("nome", "Tiago") //String
        dadosCidadao.put("cpf", "4") //String
        dadosCidadao.put("telefone", "11-98583") //String
        dadosCidadao.put("senha", "98583") //String
        db?.insert("tbl_cidadao", null, dadosCidadao)

        dadosCidadao = ContentValues()
        dadosCidadao.put("nome", "Marcelo") //String
        dadosCidadao.put("cpf", "5") //String
        dadosCidadao.put("telefone", "11-99999") //String
        dadosCidadao.put("senha", "99999") //String
        db?.insert("tbl_cidadao", null, dadosCidadao)



        //Inserindo os imóveis



        var dadosImovel = ContentValues()
        dadosImovel.put("inscricao", "1984" ) //String
        dadosImovel.put("endereco", "Travessa Armando Fontes") //String
        dadosImovel.put("cep", "69099") //String
        dadosImovel.put("tamanho", 84) //Int
        dadosImovel.put("iptu", 3580.5) //Double
        dadosImovel.put("fk_cidadao", 1) //Int
        db?.insert("tbl_imovel", null, dadosImovel)

        dadosImovel = ContentValues()
        dadosImovel.put("inscricao", "8498" ) //String
        dadosImovel.put("endereco", "Avenida Normando Tedesco") //String
        dadosImovel.put("cep", "88330") //String
        dadosImovel.put("tamanho", 74) //Int
        dadosImovel.put("iptu", 1623.8) //Double
        dadosImovel.put("fk_cidadao", 1) //Int
        db?.insert("tbl_imovel", null, dadosImovel)


        dadosImovel = ContentValues()
        dadosImovel.put("inscricao", "8563" ) //String
        dadosImovel.put("endereco", "Rua Fabio Rodrigues") //String
        dadosImovel.put("cep", "23092") //String
        dadosImovel.put("tamanho", 92) //Int
        dadosImovel.put("iptu", 1728.9) //Double
        dadosImovel.put("fk_cidadao", 2) //Int
        db?.insert("tbl_imovel", null, dadosImovel)


        dadosImovel = ContentValues()
        dadosImovel.put("inscricao", "1462" ) //String
        dadosImovel.put("endereco", "Rua do Lamim") //String
        dadosImovel.put("cep", "88054") //String
        dadosImovel.put("tamanho", 164) //Int
        dadosImovel.put("iptu", 8237.9) //Double
        dadosImovel.put("fk_cidadao", 2) //Int
        db?.insert("tbl_imovel", null, dadosImovel)

        dadosImovel = ContentValues()
        dadosImovel.put("inscricao", "4617" ) //String
        dadosImovel.put("endereco", "Travessa Jansen de Almeida") //String
        dadosImovel.put("cep", "68906") //String
        dadosImovel.put("tamanho", 112) //Int
        dadosImovel.put("iptu", 2348.4) //Double
        dadosImovel.put("fk_cidadao", 3) //Int
        db?.insert("tbl_imovel", null, dadosImovel)


        dadosImovel = ContentValues()
        dadosImovel.put("inscricao", "5638" ) //String
        dadosImovel.put("endereco", "Rua Domingos de Abreu") //String
        dadosImovel.put("cep", "74423") //String
        dadosImovel.put("tamanho", 36) //Int
        dadosImovel.put("iptu", 1232.9) //Double
        dadosImovel.put("fk_cidadao", 3) //Int
        db?.insert("tbl_imovel", null, dadosImovel)

        dadosImovel = ContentValues()
        dadosImovel.put("inscricao", "1384" ) //String
        dadosImovel.put("endereco", "Rua Jose de Carvalho") //String
        dadosImovel.put("cep", "78735") //String
        dadosImovel.put("tamanho", 36) //Int
        dadosImovel.put("iptu", 1752.9) //Double
        dadosImovel.put("fk_cidadao", 4) //Int
        db?.insert("tbl_imovel", null, dadosImovel)

        dadosImovel = ContentValues()
        dadosImovel.put("inscricao", "4859" ) //String
        dadosImovel.put("endereco", "Rua Zilda Cintra") //String
        dadosImovel.put("cep", "18428") //String
        dadosImovel.put("tamanho", 97) //Int
        dadosImovel.put("iptu", 1983.7) //Double
        dadosImovel.put("fk_cidadao", 4) //Int
        db?.insert("tbl_imovel", null, dadosImovel)


        dadosImovel = ContentValues()
        dadosImovel.put("inscricao", "6329" ) //String
        dadosImovel.put("endereco", "Rua Mamoeiro") //String
        dadosImovel.put("cep", "69921") //String
        dadosImovel.put("tamanho", 97) //Int
        dadosImovel.put("iptu", 3463.3) //Double
        dadosImovel.put("fk_cidadao", 5) //Int
        db?.insert("tbl_imovel", null, dadosImovel)

        dadosImovel = ContentValues()
        dadosImovel.put("inscricao", "5684" ) //String
        dadosImovel.put("endereco", "Rua Botafogo") //String
        dadosImovel.put("cep", "45990") //String
        dadosImovel.put("tamanho", 74) //Int
        dadosImovel.put("iptu", 1845.7) //Double
        dadosImovel.put("fk_cidadao", 5) //Int
        db?.insert("tbl_imovel", null, dadosImovel)

    }

    private fun criarTabelaCidadao(db: SQLiteDatabase?){
        val sql = "CREATE TABLE tbl_cidadao (" +
                "id_cidadao INTEGER PRIMARY KEY, " +
                "nome TEXT NOT NULL, " +
                "cpf TEXT NOT NULL, " +
                "telefone TEXT NOT NULL, " +
                "senha TEXT NOT NULL)"

        db!!.execSQL(sql)
    }

    private fun criarTabelaImovel(db: SQLiteDatabase?){
        val sql = "CREATE TABLE tbl_imovel (" +
                "id_imovel INTEGER PRIMARY KEY, " +
                "inscricao TEXT NOT NULL, " +
                "endereco TEXT NOT NULL, " +
                "cep TEXT NOT NULL, " +
                "tamanho INTEGER NOT NULL, " +
                "iptu REAL NOT NULL, " +
                "fk_cidadao INTEGER NOT NULL)"
        db!!.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        //rotinas para atualizar o banco de dados quando mudar a versão
    }


}