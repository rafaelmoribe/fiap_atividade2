package com.grupog.atividadefase2.dao

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import com.grupog.atividadefase2.model.Imovel

class ImovelDAO (val context: Context, val imovel: Imovel) {

    val dbhelper = DataBase.getDataBase(context)

    public fun createImovel() {
        val db = dbhelper.writableDatabase

        val dados = ContentValues()
        dados.put("inscricao", imovel.inscricao)
        dados.put("endereco", imovel.endereco)
        dados.put("cep", imovel.cep)
        dados.put("tamanho", imovel.tamanho)
        dados.put("iptu", imovel.iptu)
        dados.put("id_cidadao", imovel.fk_cidadao)

        db.insert("tbl_imovel", null, dados)

        db.close()
    }

}

