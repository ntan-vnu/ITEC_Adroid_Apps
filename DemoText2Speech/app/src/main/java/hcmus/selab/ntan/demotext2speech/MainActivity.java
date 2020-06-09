package hcmus.selab.ntan.demotext2speech;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextToSpeech tts;
    TextView txt_text;
    boolean flagReady = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.edt_content);
        txt_text = findViewById(R.id.txt_text);

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

    public void btn_rec_onclick(View view) {
        Intent intent = new Intent(
                RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                "speak something");
        try {
            startActivityForResult(intent, 123);
        } catch (Exception e)
        {

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 123)
        {
            ArrayList<String> list = data.getStringArrayListExtra(
                    RecognizerIntent.EXTRA_RESULTS);
            String spokenText = list.get(0);
            txt_text.setText(spokenText);
        }
    }
}
