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