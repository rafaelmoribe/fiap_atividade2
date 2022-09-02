package com.grupog.atividadefase2.model

data class Imovel(
    var id_imovel: Int = 0,
    var inscricao: String = "",
    var endereco: String = "",
    var cep: String = "",
    var tamanho: Int = 0,
    var iptu: Double = 0.0,
    var fk_cidadao: Int = 0,

    )