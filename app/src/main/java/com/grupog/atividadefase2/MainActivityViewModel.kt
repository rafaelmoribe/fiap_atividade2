package com.grupog.atividadefase2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {

    private val mCidadao = MutableLiveData<Int>()
    var cidadao = mCidadao

    private val mSenha = MutableLiveData<String>()
    var senha = mSenha

    private val mAutorization = MutableLiveData<Boolean>()
    var autorization = mAutorization

    init {
        mCidadao.value = 0
        mSenha.value = ""
        mAutorization.value = false
    }

    fun getSecurityData(){
        var cidadao = mCidadao.value!!
        var forcaSenha = mSenha.value!!.length

        //Critérios de Segurança: Código do Usuário ser menor que 10 e a Senha possuir mais de 3 caracteres
        if (cidadao < 10 && forcaSenha > 3){
            mAutorization.value = true
        }

    }

}