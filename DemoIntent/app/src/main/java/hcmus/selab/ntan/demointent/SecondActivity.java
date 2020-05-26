package hcmus.selab.ntan.demointent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        float a = intent.getFloatExtra("a", 0);
        float b = intent.getFloatExtra("b", 0);
        float c = a + b;
        intent.putExtra("c", c);
        setResult(RESULT_OK, intent);
        finish();
    }
}
