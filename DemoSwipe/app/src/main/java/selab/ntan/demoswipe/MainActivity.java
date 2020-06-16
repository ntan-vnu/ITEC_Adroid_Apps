package selab.ntan.demoswipe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.textview1);
        textView.setOnTouchListener(
                new OnSwipeListener(this) {
                    {
                        setDragHorizontal(true);
                        setExitScreenOnSwipe(true);
                        setAnimationDelay(1000);
                    }

                    @Override
                    public void onSwipeLeft(float distance) {
                        Toast.makeText(MainActivity.this, "swiped left!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSwipeRight(float distance) {
                        Toast.makeText(MainActivity.this, "swiped right!", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    public void onClickButton1(View view) {
        Toast.makeText(this, "button 1 clicked", Toast.LENGTH_SHORT).show();
    }
}
