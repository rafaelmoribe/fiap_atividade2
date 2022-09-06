package com.grupog.atividadefase2.dao

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import com.grupog.atividadefase2.model.Imovel

class ImovelDAO(val context: Context) {

    val dbhelper = DataBase.getDataBase(context)

    public fun createImovel(imovel: Imovel) {
        val db = dbhelper.writableDatabase

        val dados = ContentValues()
        dados.put("inscricao", imovel.inscricao)
        dados.put("endereco", imovel.endereco)
        dados.put("cep", imovel.cep)
        dados.put("tamanho", imovel.tamanho)
        dados.put("iptu", imovel.iptu)
        dados.put("fk_cidadao", imovel.fk_cidadao)
        db.insert("tbl_imovel", null, dados)

        db.close()
    }

    public fun alterarEnderecoImovel(endereco:String, inscricao:String){
        /*
         val dbConsulta = dbhelper.writableDatabase
        dbConsulta.delete("tbl_imovel","tbl_imovel.inscricao = $inscricao",null)
        dbConsulta.close()
         */

        val dbConsulta = dbhelper.writableDatabase

        val dados = ContentValues()
        //dados.put("inscricao",inscricao)
        dados.put("endereco", endereco)

        print("INSCRICAOOOOOO")
        println(inscricao)
        print("ENDERECO")
        println(endereco)
        println("RESULTADO")
        println(dbConsulta.update("tbl_imovel",dados,"inscricao like "+inscricao,null))

        //dbConsulta.rawQuery("update tbl_imovel set endereco = '$endereco'  where tbl_imovel.id_imovel = '$id_imovel'",null)
        dbConsulta.close()

    }
    public fun alterarTamanhoImovel(tamanho:Int, inscricao: String){
        val dbConsulta = dbhelper.writableDatabase

        val dados = ContentValues()

        dados.put("tamanho", tamanho)

        dbConsulta.update("tbl_imovel",dados,"inscricao like "+inscricao,null)
        //dbConsulta.rawQuery()
        dbConsulta.close()

    }





    public fun consultarImovel(id_cidadao: Int): MutableList<Imovel> {
        val dbConsulta = dbhelper.readableDatabase
        var listaImoveis: MutableList<Imovel> = mutableListOf()
        val cursor = dbConsulta.rawQuery(
            "select * from tbl_imovel where tbl_imovel.fk_cidadao like '${id_cidadao}'",
            null
        )
        if (cursor.moveToFirst()) {
            do {
                listaImoveis.add(
                    Imovel(
                        0,
                        cursor.getString(cursor.getColumnIndex("inscricao")),
                        cursor.getString(cursor.getColumnIndex("endereco")),
                        cursor.getString(cursor.getColumnIndex("cep")),
                        cursor.getInt(cursor.getColumnIndex("tamanho")),
                        cursor.getDouble(cursor.getColumnIndex("iptu")),
                        cursor.getInt(cursor.getColumnIndex("fk_cidadao"))
                    )
                )

            } while (cursor.moveToNext())

        } else {
            //Algo para tratar aqui? Deveria tratar o zero mas o retorno pode ser trtado na origem

        }
        cursor.close()
        dbConsulta.close()
        println("RODANDO E FECHANDO O BANCO DE LEITURA")

        return listaImoveis

    }


    public fun apagarImovel(inscricao: Int) {

        val dbConsulta = dbhelper.writableDatabase
        dbConsulta.delete("tbl_imovel","tbl_imovel.inscricao = $inscricao",null)
        dbConsulta.close()

    }


}

