package hcmus.selab.ntan.demoasyntask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNum = findViewById(R.id.txtNum);

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("count");
        registerReceiver(new MyBroadcastReceiver(), intentFilter);
    }

    public void lnlo_onclick(View view) {
        MyAsynTask asynTask = new MyAsynTask();
        asynTask.execute();
    }

    class MyAsynTask extends AsyncTask<Integer, Integer, Integer> {
        @Override
        protected Integer doInBackground(Integer... integers) {
            for (int i = 0; i < 10; i++)
            {
                Intent intent = new Intent();
                intent.setAction("count");
                intent.putExtra("num", i);
                sendBroadcast(intent);
                Log.d("@@@", String.valueOf(i));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        // can touch views in MainActivity
        @Override
        protected void onPostExecute(Integer integer) {
            txtNum.setText("finish");
        }
    }


    class MyBroadcastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            int num = intent.getIntExtra("num", 0);
            txtNum.setText(String.valueOf(num));
        }
    }
}
