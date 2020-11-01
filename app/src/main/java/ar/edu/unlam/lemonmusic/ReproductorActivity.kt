package ar.edu.unlam.lemonmusic

import android.annotation.SuppressLint
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.view.View
import android.widget.SeekBar

import kotlinx.android.synthetic.main.activity_reproductor.*

class ReproductorActivity : AppCompatActivity() {
    private lateinit var mp : MediaPlayer
    private var totalTime:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reproductor)
        mp = MediaPlayer.create(this, R.raw.lemon)
        mp.isLooping = true
        mp.setVolume(0.5f, 0.5f)
        totalTime = mp.duration

        positionBar.max = totalTime

        positionBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if(fromUser){
                    mp.seekTo(progress)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                TODO("Not yet implemented")
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                TODO("Not yet implemented")
            }
        })

        Thread(Runnable {
            while (mp != null){
                try {
                    var msg = Message()
                    msg.what = mp.currentPosition
                    handler.sendMessage(msg)
                    Thread.sleep(1000)
                }catch (e: InterruptedException){

                }
            }
        }).start()

    }
    @SuppressLint("HandlerLeak")
    var handler = object  : Handler(){
        override fun handleMessage(msg: Message) {
            var currentPosition = msg.what

            positionBar.progress = currentPosition

            var elapsedTime = createTimeLabel(currentPosition)
            time1.text = elapsedTime
            var remainingTime = createTimeLabel(totalTime - currentPosition)
            time2.text = "-$remainingTime"
        }
    }
    fun createTimeLabel(time:Int) : String{
        var timeLabel = ""
        var min = time /1000 / 60
        var sec = time / 1000 % 60

        timeLabel = "$min:"
        if(sec <10) timeLabel+=0
        timeLabel +=sec
        return timeLabel
    }
    fun playBtnClick(v : View){
        if(mp.isPlaying){
            mp.pause()
            play_pause.setBackgroundResource(R.drawable.play)

        }else{
            mp.start()
            play_pause.setBackgroundResource(R.drawable.pause)
        }
    }
}
