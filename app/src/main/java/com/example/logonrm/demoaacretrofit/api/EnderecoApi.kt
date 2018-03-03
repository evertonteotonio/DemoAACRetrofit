package com.example.logonrm.demoaacretrofit.api

import com.example.logonrm.demoaacretrofit.entities.Endereco
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by logonrm on 03/03/2018.
 */
interface EnderecoApi {

    @GET("/ws/{cep}/json")
    fun pesquisar(cep: String): Call<Endereco>
}