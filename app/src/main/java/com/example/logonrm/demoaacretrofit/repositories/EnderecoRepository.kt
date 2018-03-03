package com.example.logonrm.demoaacretrofit.repositories

import android.arch.lifecycle.LiveData
import com.example.logonrm.demoaacretrofit.entities.EnderecoResponse

/**
 * Created by logonrm on 03/03/2018.
 */
interface  EnderecoRepository {

    fun BuscarEndereco(cep: String): LiveData<EnderecoResponse>

}