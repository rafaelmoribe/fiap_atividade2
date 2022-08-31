package com.grupog.atividadefase2.dao

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.grupog.atividadefase2.model.Cidadao
import com.grupog.atividadefase2.model.Imovel
import java.sql.DatabaseMetaData


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
                "tamanho INTEGER, " +
                "iptu TEXT NOT NULL, " +
                "id_cidadao TEXT NOT NULL, " +
                "FOREIGN KEY(id_cidadao) REFERENCES tbl_cidadao(id_cidadao))"
        db!!.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        //rotinas para atualizar o banco de dados quando mudar a versão
    }

    @SuppressLint("Range")
    public fun getCidadao(cpf: String): Cidadao {
        val cidadao = Cidadao()
        val db = this.readableDatabase
        val selectionArgs = arrayOf(cpf.toString())
        val cursor = db.query(
            "tbl_cidadao",   // The table to query
            null,             // The array of columns to return (pass null to get all)
            null,              // The columns for the WHERE clause
            null, // The values for the WHERE clause
            null,                   // don't group the rows
            null,                   // don't filter by row groups
            null,               // The sort order
        )

        if (cursor != null){
            cursor?.moveToFirst()
            cidadao.nome = cursor.getInt(cursor.getColumnIndex("nome")).toString()
            cidadao.cpf = cursor.getInt(cursor.getColumnIndex("cpf")).toString()
            cidadao.telefone = cursor.getInt(cursor.getColumnIndex("telefone")).toString()
            cidadao.senha = cursor.getInt(cursor.getColumnIndex("senha")).toString()
        }

        cursor.close()
        return cidadao
    }

    @SuppressLint("Range")
    public fun getImovel(inscricao: String): Imovel {
        val imovel = Imovel()
        val db = this.readableDatabase
        //val selectQuery = "SELECT * FROM tbl_imovel WHERE inscricao = $inscricao"
        //val cursor = db.rawQuery(selectQuery, null)
        val selectionArgs = arrayOf(inscricao.toString())
        val cursor = db.query(
            "tbl_imovel",   // The table to query
            null,             // The array of columns to return (pass null to get all)
            "inscricao = ?",              // The columns for the WHERE clause
            selectionArgs, // The values for the WHERE clause
            null,                   // don't group the rows
            null,                   // don't filter by row groups
            null,               // The sort order
        )

        if (cursor != null){
            cursor?.moveToFirst()
            imovel.inscricao = cursor.getInt(cursor.getColumnIndex("inscricao")).toString()
            imovel.endereco = cursor.getInt(cursor.getColumnIndex("endereco")).toString()
            imovel.cep = cursor.getInt(cursor.getColumnIndex("cep")).toString()
            imovel.tamanho = cursor.getInt(cursor.getColumnIndex("tamanho"))
        }

        cursor.close()
        return imovel
    }


    public fun updateImovel(imovel: Imovel): Boolean{
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put("endereco", imovel.endereco)
            put("cep", imovel.cep)
            put("tamanho", imovel.tamanho)
        }
        val _success = db.update("tbl_imovel", values, "inscricao" + "=?", arrayOf(imovel.inscricao.toString())).toLong()
        db.close()
        return ("$_success").toInt() != -1
    }

    public fun deleteImovel(inscricao: String): Boolean {
        val db = this.writableDatabase
        val _success = db.delete("tbl_imovel", "inscricao" + "=?", arrayOf(inscricao.toString())).toLong()
        return ("$_success").toInt() != -1
    }

}