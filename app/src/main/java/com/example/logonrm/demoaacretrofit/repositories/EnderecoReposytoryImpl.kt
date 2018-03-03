package com.example.logonrm.demoaacretrofit.repositories

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.example.logonrm.demoaacretrofit.api.EnderecoApi
import com.example.logonrm.demoaacretrofit.entities.Endereco
import com.example.logonrm.demoaacretrofit.entities.EnderecoResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by logonrm on 03/03/2018.
 */

class EnderecoReposytoryImpl : EnderecoRepository {

    private val enderecoApi: EnderecoApi

    init {
        val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://viacep.com.br")
                .build()

        enderecoApi = retrofit.create(EnderecoApi::class.java)
    }


    override fun buscarEndereco(cep: String):
            LiveData<EnderecoResponse> {

        val liveData = MutableLiveData<EnderecoResponse>()


        enderecoApi.pesquisar(cep)
                .enqueue(object: Callback<Endereco>{
                    override fun onResponse(call: Call<Endereco>?, response: Response<Endereco>?) {
                        liveData.value = EnderecoResponse(response?.body())
                    }

                    override fun onFailure(call: Call<Endereco>?, t: Throwable?) {
                        liveData.value = EnderecoResponse(t!!)
                    }

                })

        return liveData

    }


}