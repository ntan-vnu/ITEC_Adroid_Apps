package hcmus.selab.ntan.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn_ok;
    EditText edt_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_ok = this.findViewById(R.id.btn_ok);
        edt_name = this.findViewById(R.id.edt_name);

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String greet = "Hello World " + edt_name.getText();
                Toast.makeText(getBaseContext(),
                            greet, Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void btn_ok_click(View view) {
//        String greet = "Hello World " + edt_name.getText();
//
//        Toast.makeText(getBaseContext(),
//                    greet, Toast.LENGTH_SHORT).show();
//        edt_name.setVisibility(View.INVISIBLE);
    }
}
