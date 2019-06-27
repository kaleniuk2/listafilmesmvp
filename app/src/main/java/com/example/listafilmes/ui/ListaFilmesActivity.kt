package com.example.listafilmes.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuInflater
import android.widget.Toast
import com.example.listafilmes.R
import com.example.listafilmes.data.mapper.FilmeMapper
import com.example.listafilmes.network.ApiService
import com.example.listafilmes.network.Response.FilmesResult
import kotlinx.android.synthetic.main.activity_lista_filme.*
import kotlinx.android.synthetic.main.toolbar.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ListaFilmesActivity : AppCompatActivity() {

    val listaFilmesAdapter: ListaFilmesAdapter = ListaFilmesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_lista_filme)
        setSupportActionBar(toolbar)

        configuraAdapter()
        obtemFilmes()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)

        return super.onCreateOptionsMenu(menu)
    }

    private fun configuraAdapter() {
        val layoutManager = GridLayoutManager(applicationContext, 2)
        recycler_filmes.layoutManager = layoutManager
        recycler_filmes.adapter = listaFilmesAdapter
    }

    private fun obtemFilmes() {
        ApiService.instance.obterFilmesPopulares("243278a36988122b863cfcfa1efaf7b8")
            .enqueue(object : Callback<FilmesResult> {
                override fun onResponse(call: Call<FilmesResult>, response: Response<FilmesResult>) {
                    if (response.isSuccessful) {
                        listaFilmesAdapter.filmes = FilmeMapper.doResponseParaDominio(response.body()!!.resultado)
                    } else {
                        mostraErro()
                    }
                }

                override fun onFailure(call: Call<FilmesResult>, t: Throwable) {
                    mostraErro()
                }
            })
    }

    private fun mostraErro() {
        Toast.makeText(this, "Erro ao consultar filmes", Toast.LENGTH_SHORT).show()
    }
}