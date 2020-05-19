package hcmus.selab.ntan.demolayout;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView _txtView;
    LinearLayout _lnlo;
    Button _btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _lnlo = findViewById(R.id.lnlo);
    }

    public void btnAdd_onclick(View view) {
//        _txtView = new TextView(getBaseContext());
//        _txtView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
//                ViewGroup.LayoutParams.WRAP_CONTENT));
//        _txtView.setText("This is a sample textview");
//        _txtView.setTextColor(Color.RED);
//        _lnlo.addView(_txtView);

        _btn = new Button(getBaseContext());
        _btn.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        _btn.setText("OK");
        _btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Xin chao", Toast.LENGTH_SHORT).show();
            }
        });

        _lnlo.addView(_btn);

    }
}
