package com.grupog.atividadefase2.dao

import android.content.ContentValues
import android.content.Context
import com.grupog.atividadefase2.model.Cidadao

class CidadaoDAO (val context: Context) {

    val dbhelper = DataBase.getDataBase(context)

    public fun createCidadao(cidadao: Cidadao) {
        val db = dbhelper.writableDatabase

        val dados = ContentValues()
        dados.put("nome", cidadao.nome)
        dados.put("cpf", cidadao.cpf)
        dados.put("telefone", cidadao.telefone)
        dados.put("senha", cidadao.senha)


        db.insert("tbl_cidadao", null, dados)

        db.close()
    }


    public fun consultarCidadao(codigo:String):Cidadao{
        val dbConsulta = dbhelper.readableDatabase
        //println("FEZ CONSULTA")
        val cursor = dbConsulta.rawQuery("SELECT * FROM tbl_cidadao WHERE tbl_cidadao.cpf like '${codigo}'",null)
        //println("SAIU CONSULTA")
        var cidadao:Cidadao = Cidadao(
            -1,
            "vazio",
            "vazio",
            "vazio",
            "vazio"
        )
        //var cidadao:Cidadao
        if(cursor.moveToFirst()){
            println(cursor.getString(cursor.getColumnIndex("nome")))
            println("RODOU CONSULTA DE NOVO")
            cidadao.nome= cursor.getString(cursor.getColumnIndex("nome"))
            cidadao.cpf =  cursor.getString(cursor.getColumnIndex("cpf"))
            cidadao.id_cidadao =cursor.getInt(cursor.getColumnIndex("id_cidadao"))
            cidadao.telefone =cursor.getString(cursor.getColumnIndex("telefone"))
            cidadao.senha = cursor.getString(cursor.getColumnIndex("senha"))
        }else{
            print("Cursor Vazio")
        }
        cursor.close()
        dbConsulta.close()
        return cidadao

    }

}
