package hcmus.selab.ntan.demoservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edt_a, edt_b, edt_c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_a = findViewById(R.id.edt_a);
        edt_b = findViewById(R.id.edt_b);
        edt_c = findViewById(R.id.edt_c);

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("math_op");
        registerReceiver(new MathBroadcastReceiver(),
                intentFilter);
    }

    public void btn_op_onclick(View view) {
        int a = Integer.parseInt(edt_a.getText().toString());
        int b = Integer.parseInt(edt_b.getText().toString());
        String op = "";
        switch (view.getId()){
            case R.id.btn_plus:
                op = "+";
                break;
            case R.id.btn_sub:
                op = "-";
                break;
            case R.id.btn_mul:
                op = "*";
                break;
            case R.id.btn_div:
                op = "/";
                break;
        }
        Intent intent = new Intent(this,
                MathOperationService.class);
        intent.putExtra("a", a);
        intent.putExtra("b", b);
        intent.putExtra("op", op);
        intent.setAction("math_op");
        startService(intent);
    }

    public void lnlo_onclick(View view) {
        Intent intent = new Intent(this,
                ThreadService.class);
        intent.setAction("math_op");
        startService(intent);
    }

    public void btn_ok_onclick(View view) {
        Intent intent = new Intent(this,
                ThreadService.class);
        intent.setAction("math_op");
        startService(intent);
    }

    public class MathBroadcastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            int c = intent.getIntExtra("c", -1);
            Log.d("@@@", String.valueOf(c));
            edt_c.setText(String.valueOf(c));
        }
    }
}
