package education.elhazent.com.news.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
class NewsItem(
    var id: String,
    var images: Int,
    var penulis: String,
    var judul: String,
    var content: String,
    var tanggal: String
) : Parcelable {
}