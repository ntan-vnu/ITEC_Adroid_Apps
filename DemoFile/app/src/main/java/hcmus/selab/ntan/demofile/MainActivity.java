package hcmus.selab.ntan.demofile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("@@@", getFilesDir().getAbsolutePath());
        Log.d("@@@", getFilesDir().getName());
        Log.d("@@@", getFilesDir().getParent());

        editText = findViewById(R.id.edt_content);
    }

    public void btn_save_onclick(View view) throws FileNotFoundException {
        PrintStream output = new PrintStream(openFileOutput("out.txt",
                MODE_PRIVATE));
        output.println(editText.getText().toString());
        output.close();
    }

    public void btn_load_click(View view) throws IOException {
        Scanner scan = new Scanner(openFileInput("out.txt"));
        String allText = "";
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            allText += line;
        }
        editText.setText(allText);
        scan.close();
    }
}
