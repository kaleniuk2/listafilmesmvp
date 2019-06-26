package com.example.listafilmes.ui

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.listafilmes.R
import com.example.listafilmes.data.Filme
import com.example.listafilmes.network.ApiService
import com.example.listafilmes.network.Response.FilmesResult
import kotlinx.android.synthetic.main.activity_lista_filme.*
import kotlinx.android.synthetic.main.toolbar.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ListaFilmesActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_lista_filme)

        setSupportActionBar(toolbar)

        ApiService.instance.obterFilmesPopulares("243278a36988122b863cfcfa1efaf7b8")
            .enqueue(object : Callback<FilmesResult> {
                override fun onResponse(call: Call<FilmesResult>, response: Response<FilmesResult>) {
                    if (!response.isSuccessful) return

                    val listaFilmesAdapter = ListaFilmesAdapter(response.body()!!.resultado)
                    val layoutManager = LinearLayoutManager(applicationContext)
                    recycler_filmes.layoutManager = layoutManager
                    recycler_filmes.adapter = listaFilmesAdapter
                }


                override fun onFailure(call: Call<FilmesResult>, t: Throwable) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })

        val listaFilmes: ArrayList<Filme> = arrayListOf()

    }
}