package com.example.jean.ufcapp.noticias

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.jean.ufcapp.R
import com.example.jean.ufcapp.models.Noticia
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_noticia.view.*

/**
 * @author Jean Carlos (Github: @jeancsanchez)
 * @date 13/12/18.
 * Jesus is alive!
 */
class NoticiaAdapter : RecyclerView.Adapter<NoticiaAdapter.NoticiaViewHolder>() {
    private var noticias: List<Noticia> = emptyList()
    private var clickListener: ((Long) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): NoticiaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_noticia, parent, false)
        return NoticiaViewHolder(view)
    }


    override fun onBindViewHolder(holder: NoticiaViewHolder, position: Int) {
        holder.onBind(noticias[position])
    }

    fun adicionarNoticias(noticias: List<Noticia>, clickListener: (Long) -> Unit) {
        this.noticias = noticias
        this.clickListener = clickListener
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int = noticias.size


    inner class NoticiaViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun onBind(noticia: Noticia) {
            itemView.setOnClickListener { clickListener?.invoke(noticia.id) }
            itemView.txtTituloNoticia.text = noticia.titulo
            itemView.txtSubTituloNoticia.text = noticia.autor

            if (noticia.foto?.isBlank() == false) {
                Picasso.get()
                        .load(noticia.foto)
                        .placeholder(itemView.resources.getDrawable(R.drawable.ufcbg))
                        .fit()
                        .into(itemView.imgThumbNoticia)
            }
        }
    }
}