package com.grupog.atividadefase2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CadastrarImovelActivityViewModel : ViewModel() {

    private val mTamanho = MutableLiveData<Int>()
    var tamanho = mTamanho

    private val mIPTU = MutableLiveData<Double>()
    var iptu = mIPTU

    init {
        mTamanho.value = 0
        mIPTU.value = 0.0
    }

    fun calcularIptu() {

        val tamanhoNovo = tamanho.value!!
        val valorMetroQuadrado = (Math.random() * (9000 - 2000 + 1)).toInt() + 2000

        //cálculo do IPTU = alíquota percentual constante * (valor do imóvel calculado a partir do tamanho em m² e valor do m²)
        if (tamanhoNovo > 200){
            mIPTU.value = 0.055 * (tamanhoNovo * valorMetroQuadrado)
        } else if (tamanhoNovo > 120){
            mIPTU.value = 0.045 * (tamanhoNovo * valorMetroQuadrado)
        } else if (tamanhoNovo > 80){
            mIPTU.value = 0.035 * (tamanhoNovo * valorMetroQuadrado)
        } else if (tamanhoNovo > 60){
            mIPTU.value = 0.025 * (tamanhoNovo * valorMetroQuadrado)
        } else if (tamanhoNovo > 40){
            mIPTU.value = 0.015 * (tamanhoNovo * valorMetroQuadrado)
        } else {
            mIPTU.value = 0.005 * (tamanhoNovo * valorMetroQuadrado)
        }


    }


}