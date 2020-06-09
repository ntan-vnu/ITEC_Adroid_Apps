package hcmus.selab.ntan.demofragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        intent.putExtra(String.valueOf(R.id.frag01), "This is fragment 01");
        intent.putExtra(String.valueOf(R.id.frag02), "This is fragment 02");
        setIntent(intent);
    }
}
