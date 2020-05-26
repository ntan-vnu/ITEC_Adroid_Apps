package hcmus.selab.ntan.demomedia;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mp;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       mp = MediaPlayer.create(this,
               R.raw.em_ko_sai_cta_sai);
       btn = findViewById(R.id.btn_play);
    }

    public void btn_play_onclick(View view) {

        if (mp.isPlaying()) {
            mp.pause();
            Drawable ic_play = getDrawable(
                    android.R.drawable.ic_media_play);
            btn.setBackground(ic_play);
        }
        else {
            mp.start();
            Drawable ic_play = getDrawable(
                    android.R.drawable.ic_media_pause);
            btn.setBackground(ic_play);
        }
    }
}
