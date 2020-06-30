package hcmus.selab.ntan.demodatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;
    EditText edt_id, edt_name;
    Button btn_load;

    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_id = findViewById(R.id.edt_id);
        edt_name = findViewById(R.id.edt_name);
        btn_load = findViewById(R.id.btn_load);
        initDatabase();
    }

    private void initDatabase() {
         db = openOrCreateDatabase(
                "class", MODE_PRIVATE, null);
    }

    public void btn_create_std_onclick(View view) {
        String cmd = "create table student "
                + "(id INTEGER PRIMARY KEY,"
                + "name VARCHAR(20) NOT NULL)";
        db.execSQL(cmd);
    }

    public void btn_insert_onclick(View view) {
        String id = edt_id.getText().toString();
        String name = edt_name.getText().toString();

        ContentValues cvalues = new ContentValues();
        cvalues.put("id", id);
        cvalues.put("name", name);
        db.insert("student", null, cvalues);
        Toast.makeText(this, "inserted",
                Toast.LENGTH_SHORT).show();
    }

    public void btn_load_onclick(View view) {
        if (btn_load.getText().toString().equals("Load")) {
            btn_load.setText("Close");
            cursor = db.rawQuery("SELECT * FROM student", null);
            cursor.moveToFirst();
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            edt_id.setText(String.valueOf(id));
            edt_name.setText(name);
            if (!cursor.moveToNext()) {
                cursor.close();
                cursor = null;
            }
        }
        else {
            if (cursor != null) {
                cursor.close();
            }
            btn_load.setText("Load");
        }
    }

    public void btn_next_onclick(View view) {
        if (cursor != null) {
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            edt_id.setText(String.valueOf(id));
            edt_name.setText(name);
            if (!cursor.moveToNext()) {
                cursor.close();
                cursor = null;
            }
        }
    }
}
