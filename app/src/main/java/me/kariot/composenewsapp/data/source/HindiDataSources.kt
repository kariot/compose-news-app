package me.kariot.quicknews.api

import me.kariot.composenewsapp.data.NewsSource

object HindiDataSources {
    val hindiDataSource = listOf<NewsSource>(
        NewsSource(
            "NavBharat Times",
            "https://static.langimg.com/thumb/msid-76544596,width-256,resizemode-4/navbharat-times.jpg",
            "https://navbharattimes.indiatimes.com/rssfeedsdefault.cms"
        ),
        NewsSource(
            "Hindustan",
            "https://india.mom-rsf.org/typo3temp/_processed_/7/a/csm_16510-1592_import_76e62e4c21.png",
            "https://feed.livehindustan.com/rss/3127"
        ),
        NewsSource(
            "AAJ Tak News",
            "https://akm-img-a-in.tosshub.com/aajtak/resource/img/bemisaal-20-saal/aajtak-logo-153X116.png?imbypass=true",
            "https://www.aajtak.in/rssfeeds/?id=home"
        ),
        NewsSource(
            "One India Hindi",
            "https://www.mahesh.com/wp-content/uploads/oneindia-logo.jpg",
            "https://hindi.oneindia.com/rss/hindi-news-fb.xml"
        ),
        NewsSource(
            "News 18",
            "https://images.hindi.news18.com/ibnkhabar/uploads/2020/03/Hindi1.png",
            "https://hindi.news18.com/rss/khabar/ajab-gajab/ajab-gajab.xml"
        ),
        NewsSource(
            "Nai Dunia",
            "https://www.naidunia.com/Resources/naidunia/images/naidunia-logo-1.png",
            "http://rss.jagran.com/naidunia/latest-news.xml"
        ),
        NewsSource(
            "Amar Ujala",
            "https://s3.amazonaws.com/bookadsnow-live/newspapers/552/detail/Amar_Ujala.png?1514550993",
            "https://www.amarujala.com/rss/breaking-news.xml"
        ),
        NewsSource(
            "ABP News",
            "https://upload.wikimedia.org/wikipedia/en/9/90/ABP_News_Logo.png",
            "https://www.abplive.com/home/feed"
        ),
        NewsSource(
            "Jansatta",
            "https://www.jansatta.com/wp-content/themes/vip/jansatta2015/images/logo.png",
            "https://www.jansatta.com/feed/"
        ),
    )
}