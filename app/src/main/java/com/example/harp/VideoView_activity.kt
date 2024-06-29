package com.example.harp

import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class VideoView_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_view)

        val videoView = findViewById<VideoView>(R.id.xml_video_view)
        val packageName = "android.resource://" + packageName + "/" + R.raw.video_harp1
        val uri = Uri.parse(packageName)
        videoView.setVideoURI(uri)

        val mediaController = MediaController(this)
        videoView.setMediaController(mediaController)
    }
}