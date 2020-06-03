package hcmus.selab.ntan.demostate;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edt_name, edt_gpa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            setContentView(R.layout.activity_main);
        }
        else {
            setContentView(R.layout.activity_main_land);
        }


        edt_name = findViewById(R.id.edt_name);
        edt_gpa = findViewById(R.id.edt_gpa);
        Log.d("@@@@@@", "oncreate");
    }

//    @Override
//    protected void onStart() {
//        Log.d("@@@@@@", "onstart");
//        super.onStart();
//    }
//
//    @Override
//    protected void onPostResume() {
//        Log.d("@@@@@@", "onresume");
//        super.onPostResume();
//    }
//
//    @Override
//    protected void onPause() {
//        Log.d("@@@@@@", "onpause");
//        super.onPause();
//    }
//
//    @Override
//    protected void onStop() {
//        Log.d("@@@@@@", "onstop");
//        super.onStop();
//    }
//
//    @Override
//    protected void onDestroy() {
//        Log.d("@@@@@@", "ondestroy");
//        super.onDestroy();
//    }
//
//    @Override
//    protected void onSaveInstanceState(@NonNull Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putString("name", edt_name.getText().toString());
//        outState.putString("gpa", edt_gpa.getText().toString());
//        Log.d("@@@@@@", "onsave");
//    }
//
//    @Override
//    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        String name = savedInstanceState.getString("name");
//        String gpa = savedInstanceState.getString("gpa");
//        edt_name.setText(name);
//        edt_gpa.setText(gpa);
//        Log.d("@@@@@@", "onrestore");
//    }
}
