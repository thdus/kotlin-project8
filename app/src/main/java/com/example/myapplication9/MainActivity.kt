package com.example.myapplication9

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication9.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var mediaPlayer : MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.playButton.setOnClickListener { mediaPlayerPlay() }
        binding.pauseButton.setOnClickListener { mediaPlayerPause() }
        binding.stopButton.setOnClickListener { mediaPlayerStop() }
    }

    private fun mediaPlayerPlay(){
        val intent = Intent(this, MediaPlayerService::class.java)
            .apply {
                action = MEDIA_PLAYER_PLAY
    }
        startService(intent)}
    private fun mediaPlayerPause(){
        val intent = Intent(this, MediaPlayerService::class.java)
            .apply {
                action = MEDIA_PLAYER_PAUSE
            }
        startService(intent)}

    private fun mediaPlayerStop(){
        val intent = Intent(this, MediaPlayerService::class.java)
            .apply {
                action = MEDIA_PLAYER_STOP
            }
        startService(intent)
    }

}