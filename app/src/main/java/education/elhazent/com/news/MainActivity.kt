package education.elhazent.com.news

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import education.elhazent.com.news.DataDummy.DataDummy
import education.elhazent.com.news.adapter.NewsAdapter
import education.elhazent.com.news.model.NewsItem
import kotlinx.android.synthetic.main.activity_main.*
import android.provider.Settings.ACTION_LOCALE_SETTINGS
import android.content.Intent
import android.R.id
import education.elhazent.com.news.profile.ProfileActivity


@Suppress("DEPRECATED_IDENTITY_EQUALS")
class MainActivity : AppCompatActivity() {


    private var dataNews: MutableList<NewsItem> = mutableListOf()
    lateinit var dataDummy: DataDummy


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dataDummy = DataDummy()

        dataNews = dataDummy.generateDummyNews()
        recycler_news.layoutManager = LinearLayoutManager(applicationContext)
        recycler_news.adapter = NewsAdapter(applicationContext, dataNews)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId === R.id.action_settings) {
            val mIntent = Intent(applicationContext, ProfileActivity::class.java)
            startActivity(mIntent)
        }

        return super.onOptionsItemSelected(item);
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }
}
