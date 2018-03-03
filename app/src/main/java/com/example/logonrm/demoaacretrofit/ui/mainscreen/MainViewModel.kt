package com.example.logonrm.demoaacretrofit.ui.mainscreen

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.ViewModel
import com.example.logonrm.demoaacretrofit.entities.EnderecoResponse
import com.example.logonrm.demoaacretrofit.repositories.EnderecoRepository
import com.example.logonrm.demoaacretrofit.repositories.EnderecoReposytoryImpl

/**
 * Created by logonrm on 03/03/2018.
 */
class MainViewModel : ViewModel() {

    private val enderecoRepository: EnderecoRepository
    private val mApiResponse: MediatorLiveData<EnderecoResponse> = MediatorLiveData()

    val apiResponse: LiveData<EnderecoResponse>
    get() = mApiResponse

    init {
        enderecoRepository = EnderecoReposytoryImpl()
    }

    fun pesquisarEndereco(cep: String) : LiveData<EnderecoResponse>{
//        /apiResponse.addSource(enderecoRepository.buscarEndereco(cep))

        mApiResponse.addSource(enderecoRepository.buscarEndereco(cep)){
            apiResponse -> mApiResponse.value = apiResponse
        }
        return mApiResponse
    }
}