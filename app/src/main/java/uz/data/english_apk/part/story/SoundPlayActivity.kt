package uz.data.english_apk.part.story

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_sound_play.*
import uz.data.english_apk.R

class SoundPlayActivity : AppCompatActivity() {

    private lateinit var runnable: Runnable
    private var handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sound_play)
        val soundtext = intent.getStringExtra("soundtext")
        val soundName = intent.getStringExtra("soundName")
        text_story.text = soundtext

        val mediaPlayer = MediaPlayer.create(this,resources.getIdentifier(soundName,"raw",packageName))
        seekbar.max = mediaPlayer.duration
        play.setOnClickListener {
            mediaPlayer.start()
        }
        pause.setOnClickListener {
            mediaPlayer.pause()
        }

        seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                if(p2){
                    mediaPlayer.seekTo(p1)
                }
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

        })

        runnable = Runnable {
            seekbar.progress = mediaPlayer.currentPosition
            handler.postDelayed(runnable,1000)
        }
        handler.postDelayed(runnable,1000)

    }
}