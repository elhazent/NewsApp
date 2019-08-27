package education.elhazent.com.news.detail

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import education.elhazent.com.news.R
import education.elhazent.com.news.model.NewsItem
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.news_item.view.*

class DetailActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_DATA = "data"
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val dataNews:NewsItem = intent.getParcelableExtra(EXTRA_DATA)

        newsTitleDetail.text = dataNews.judul
        newsDateDetail.text = dataNews.tanggal
        newsContentDetail.text = dataNews.content
        newsWriterDetail.text = "Oleh : ${dataNews.penulis}"

        Glide.with(applicationContext)
            .load(dataNews.images)
            .override(600, 200)
            .into(newsImageDetail)
    }
}
