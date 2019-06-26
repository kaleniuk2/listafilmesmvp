package com.example.listafilmes.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.listafilmes.R
import com.example.listafilmes.data.Filme
import com.example.listafilmes.network.Response.FilmesReponse
import com.example.listafilmes.network.Response.FilmesResult

class ListaFilmesAdapter(val listaFilmes: List<FilmesReponse>) : RecyclerView.Adapter<ListaFilmesAdapter.MeuViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MeuViewHolder {
        val view: View = LayoutInflater.from(p0.context).inflate(R.layout.item_filme, p0, false)

        return MeuViewHolder(view)
    }

    override fun onBindViewHolder(p0: MeuViewHolder, p1: Int) {
        p0.titulo.text = listaFilmes[p1].tituloOriginal
    }

    override fun getItemCount(): Int {
        return listaFilmes.size
    }

    class MeuViewHolder(item : View) : RecyclerView.ViewHolder(item) {
        var titulo: TextView = item.findViewById(R.id.tituloFilme)
    }

}