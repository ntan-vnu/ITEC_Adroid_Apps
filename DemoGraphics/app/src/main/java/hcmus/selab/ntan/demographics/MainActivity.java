package hcmus.selab.ntan.demographics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Sprite sprite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sprite = findViewById(R.id.sprite);
    }

    public void lnlo_onclick(View view) {
        sprite.startAnimation();
    }
}
