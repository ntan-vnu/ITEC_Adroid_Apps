package hcmus.selab.ntan.demointent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    final int SEC_ACT_REQ_CODE = 1;
    EditText edt_a, edt_b, edt_c, edt_phoneNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_a = findViewById(R.id.edt_a);
        edt_b = findViewById(R.id.edt_b);
        edt_c = findViewById(R.id.edt_c);
        edt_phoneNo = findViewById(R.id.edt_phoneNo);
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
        switch (requestCode) {
            case SEC_ACT_REQ_CODE:
                if (resultCode == RESULT_OK) {
                    float c = data.getFloatExtra("c", 0);
                    edt_c.setText(String.valueOf(c));
                }
                break;
            default:
                break;
        }
    }

    public void btn_call_onclick(View view) {
        String phoneNo = edt_phoneNo.getText().toString();
        Uri number = Uri.parse("tel:" + phoneNo);
        Intent callIntent = new Intent(Intent.ACTION_CALL,
                number);
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(callIntent);
    }

    public void btn_geo_onclick(View view) {
        Uri location =
                Uri.parse("geo:10.763134, 106.682161");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW,
                location);
        startActivity(mapIntent);
    }
}
