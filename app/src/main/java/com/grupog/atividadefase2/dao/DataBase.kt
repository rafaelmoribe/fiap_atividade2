package com.grupog.atividadefase2.dao

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DataBase(context: Context) : SQLiteOpenHelper(context, "app.db", null, 1) {

    companion object {
        fun getDataBase(context: Context) : DataBase{
            return DataBase(context)
        }
    }


    override fun onCreate(db: SQLiteDatabase?) {
        //primeira vez que o usuário interage com o banco de dados
        criarTabelaCidadao(db)
        criarTabelaImovel(db)
    }

    private fun criarTabelaImovel(db: SQLiteDatabase?){
        val sql = "CREATE TABLE tbl_imovel (" +
                "id_imovel INTEGER PRIMARY KEY, " +
                "inscricao TEXT NOT NULL, " +
                "endereco TEXT NOT NULL, " +
                "cep TEXT NOT NULL, " +
                "tamanho INTEGER, " +
                "iptu TEXT NOT NULL, " +
                "id_cidadao TEXT NOT NULL, " +
                "FOREIGN KEY(id_cidadao) REFERENCES tbl_cidadao(id_cidadao))"
        db!!.execSQL(sql)
    }

    private fun criarTabelaCidadao(db: SQLiteDatabase?){
        val sql = "CREATE TABLE tbl_cidadao (" +
                "id_cidadao INTEGER PRIMARY KEY, " +
                "nome TEXT NOT NULL, " +
                "cpf TEXT NOT NULL, " +
                "telefone TEXT NOT NULL)"

        db!!.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        //rotinas para atualizar o banco de dados quando mudar a versão
    }

}