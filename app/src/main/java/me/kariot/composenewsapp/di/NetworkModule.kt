package me.kariot.composenewsapp.di

import android.content.Context
import com.prof18.rssparser.RssParser
import com.prof18.rssparser.RssParserBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.CipherSuite.Companion.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256
import okhttp3.CipherSuite.Companion.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256
import okhttp3.CipherSuite.Companion.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256
import okhttp3.ConnectionSpec
import okhttp3.OkHttpClient
import okhttp3.TlsVersion
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    @Singleton
    fun provideParser(@ApplicationContext context: Context): RssParser {
        val okHttpClientBuilder = OkHttpClient.Builder()
        okHttpClientBuilder.connectionSpecs(
            listOf(
                ConnectionSpec.CLEARTEXT,
                ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)
                    .tlsVersions(TlsVersion.TLS_1_2)
                    .cipherSuites(
                        TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256,
                        TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256,
                        TLS_DHE_RSA_WITH_AES_128_GCM_SHA256
                    )
                    .build()
            )
        )
        val okHttpClient = okHttpClientBuilder.build()
        val builder = RssParserBuilder(
            callFactory = okHttpClient,
            charset = Charsets.UTF_8,
        )
        return builder.build()
    }
}