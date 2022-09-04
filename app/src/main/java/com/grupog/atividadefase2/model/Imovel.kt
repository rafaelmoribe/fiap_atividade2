package com.grupog.atividadefase2.model

import java.io.Serializable

data class Imovel(
    var id_imovel: Int = 0,
    var inscricao: String = "",
    var endereco: String = "",
    var cep: String = "",
    var tamanho: Int = 0,
    var iptu: Double = 0.0,
    var fk_cidadao: Int = 0,

    ) : Serializable {
    override fun toString(): String {
        return "Inscrição: ${inscricao}\n" +
                "Endereço: ${endereco}\n" +
                "CEP: ${cep}\n" +
                "Tamanho(m2): ${tamanho.toString()}\n" +
                "IPTU(Reais): ${iptu.toString()}\n\n"
    }
}