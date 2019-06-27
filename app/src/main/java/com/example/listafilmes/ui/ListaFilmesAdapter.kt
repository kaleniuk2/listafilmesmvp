package com.example.listafilmes.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.listafilmes.R
import com.example.listafilmes.data.model.Filme
import com.squareup.picasso.Picasso


class ListaFilmesAdapter : RecyclerView.Adapter<ListaFilmesAdapter.MeuViewHolder>() {

    var filmes: List<Filme> = arrayListOf()
        set(value) {
            notifyDataSetChanged()
            field = value
        }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MeuViewHolder {
        val view: View = LayoutInflater.from(p0.context).inflate(R.layout.item_filme, p0, false)

        return MeuViewHolder(view)
    }

    override fun onBindViewHolder(meuViewHolder: MeuViewHolder, p1: Int) {
        meuViewHolder.bind(filmes[p1])
    }

    override fun getItemCount(): Int {
        return filmes.size
    }

    class MeuViewHolder(item : View) : RecyclerView.ViewHolder(item) {
        var titulo: TextView = item.findViewById(R.id.tituloFilme)
        var posterFilme: ImageView = item.findViewById(R.id.image_poster_filme)



        fun bind(filme: Filme) {
            titulo.text = filme.titulo
            Picasso.get().load("https://image.tmdb.org/t/p/w342" + filme.caminhoPoster).into(posterFilme)
        }

    }

}