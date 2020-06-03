package hcmus.selab.ntan.demotext2speech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextToSpeech tts;
    boolean flagReady = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.edt_content);

        tts = new TextToSpeech(this,
                new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        flagReady = true;
                    }
                });
    }

    public void btn_speak_onclick(View view) {
        if (flagReady)
        {
            tts.speak(editText.getText().toString(),
                    TextToSpeech.QUEUE_FLUSH, null);
        }
    }
}
