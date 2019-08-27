package education.elhazent.com.news.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import education.elhazent.com.news.R
import education.elhazent.com.news.detail.DetailActivity
import education.elhazent.com.news.model.NewsItem
import kotlinx.android.synthetic.main.news_item.view.*

class NewsAdapter(val contex:Context,val data:List<NewsItem>): RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(contex).inflate(R.layout.news_item,p0,false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.bindItem(data[p1])

    }

    class ViewHolder(view:View):RecyclerView.ViewHolder(view) {

        fun bindItem(dataNews:NewsItem){
            itemView.tvJudulBerita.text = dataNews.judul
            itemView.tvPenulis.text = dataNews.penulis
            itemView.tvTglTerbit.text = dataNews.tanggal

            Glide.with(itemView)
                .load(dataNews.images)
                .override(600, 200)
                .into(itemView.ivGambar)

            itemView.setOnClickListener {
                val intent = Intent(it.context,DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_DATA,dataNews)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                it.context.startActivity(intent)
            }
        }

    }
}