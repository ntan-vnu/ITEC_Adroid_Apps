package hcmus.selab.ntan.demointent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    final int SEC_ACT_REQ_CODE = 1;
    EditText edt_a, edt_b, edt_c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_a = findViewById(R.id.edt_a);
        edt_b = findViewById(R.id.edt_b);
        edt_c = findViewById(R.id.edt_c);
    }

    public void btn_add_onclick(View view) {
        float a = Float.parseFloat(edt_a.getText().toString());
        float b = Float.parseFloat(edt_b.getText().toString());

        Intent intent = new Intent(this,
                SecondActivity.class);
        intent.putExtra("a", a);
        intent.putExtra("b", b);
        startActivityForResult(intent, SEC_ACT_REQ_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    @Nullable Intent data) {
        switch (requestCode)
        {
            case SEC_ACT_REQ_CODE:
                if (resultCode == RESULT_OK)
                {
                    float c = data.getFloatExtra("c", 0);
                    edt_c.setText(String.valueOf(c));
                }
                break;
            default:
                break;
        }
    }
}
