package com.example.exoplayer


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.Player.STATE_ENDED
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.upstream.RawResourceDataSource
import com.google.android.exoplayer2.util.Util
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val exoPlayerInstance = SimpleExoPlayer.Builder(this).build()
        val dataSourceFactory: DataSource.Factory =
            DefaultDataSourceFactory(this, Util.getUserAgent(this, "simpleExoPlayer"))
        val firstSource = ProgressiveMediaSource.Factory(dataSourceFactory)
            .createMediaSource(RawResourceDataSource.buildRawResourceUri(R.raw.test))
        exoPlayerInstance.prepare(firstSource)
        playerView.player = exoPlayerInstance
        exoPlayerInstance.addListener(object : Player.EventListener {


            override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {
                if (playbackState == STATE_ENDED)
                    Toast.makeText(applicationContext, "rrr", Toast.LENGTH_SHORT).show()
                super.onPlayerStateChanged(playWhenReady, playbackState)
            }
        })
        val myDispatcher = MyDispatcher()
        playerView.setControlDispatcher(myDispatcher)
    }


}

