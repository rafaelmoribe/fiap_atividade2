package com.grupog.atividadefase2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {

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

    fun getSecurityData(cpf: String) {
        val usuarioNoBanco: Boolean = false








        return

    }

}