package hcmus.selab.ntan.demolifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("@@@@@@@@@", "oncreate1");
    }

    @Override
    protected void onStart() {
        Log.d("@@@@@@@@@", "onstart1");
        super.onStart();
    }

    @Override
    protected void onPostResume() {
        Log.d("@@@@@@@@@", "onresume1");
        super.onPostResume();
    }

    @Override
    protected void onPause() {
        Log.d("@@@@@@@@@", "onpause1");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d("@@@@@@@@@", "onstop1");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("@@@@@@@@@", "ondestroy1");
        super.onDestroy();
    }

    public void lnlo_onclick(View view) {
        Intent intent = new Intent(this,
                SecondActivity.class);
        startActivity(intent);
    }
}
