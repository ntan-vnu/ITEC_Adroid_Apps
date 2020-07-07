package hcmus.selab.ntan.demodjango;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText edt_a, edt_b, edt_c;

    TextView txtRes;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_a = findViewById(R.id.edt_a);
        edt_b = findViewById(R.id.edt_b);
        edt_c = findViewById(R.id.edt_c);


        txtRes = findViewById(R.id.txtRes);
        imageView = findViewById(R.id.imgIcon);
    }

    public void btn_ok_onclick(View view) {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://172.17.216.81:8000/add?a=1&b=2";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        txtRes.setText(response.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                txtRes.setText("That didn't work!");
            }
        });

        queue.add(stringRequest);
    }

    public void btn_ok_onclick2(View view) {
        imageView.buildDrawingCache();
        Bitmap bmp = imageView.getDrawingCache();
        final String str_bmp = getStringImage(bmp);
        Toast.makeText(this, String.valueOf(str_bmp.length()), Toast.LENGTH_SHORT).show();

        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://172.17.216.81:8000/up_image";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        txtRes.setText(response.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                txtRes.setText("That didn't work!");
            }

        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("image", str_bmp);
                return params;
            }
        };
        queue.add(stringRequest);


    }

    public String getStringImage(Bitmap bmp) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
    }

    public void btn_add_onclick(View view) {
        String str_a = edt_a.getText().toString();
        String str_b = edt_b.getText().toString();

        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://172.17.216.81:8000/add?" +
                "a="+str_a+
                "&b="+str_b;

        StringRequest stringRequest = new StringRequest(
                Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        edt_c.setText(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        edt_c.setText("That didn't work!");
                    }
        });
        queue.add(stringRequest);
    }
}
