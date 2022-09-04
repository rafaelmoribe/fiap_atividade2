package com.grupog.atividadefase2.model

import java.io.Serializable


data class Cidadao (
    var id_cidadao: Int = 0,
    var nome: String = "",
    var cpf: String = "",
    var telefone: String = "",
    var senha: String = ""
):Serializable