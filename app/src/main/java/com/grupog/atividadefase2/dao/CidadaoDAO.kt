package com.grupog.atividadefase2.dao

import android.content.ContentValues
import android.content.Context
import com.grupog.atividadefase2.model.Cidadao

class CidadaoDAO (val context: Context, val cidadao: Cidadao) {

    val dbhelper = DataBase.getDataBase(context)

    public fun createCidadao() {
        val db = dbhelper.writableDatabase

        val dados = ContentValues()
        dados.put("nome", cidadao.nome)
        dados.put("cpf", cidadao.cpf)
        dados.put("telefone", cidadao.telefone)
        dados.put("senha", cidadao.senha)


        db.insert("tbl_cidadao", null, dados)

        db.close()
    }

}
