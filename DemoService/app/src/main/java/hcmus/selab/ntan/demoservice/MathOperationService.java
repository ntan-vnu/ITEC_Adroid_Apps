package hcmus.selab.ntan.demoservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MathOperationService extends Service {
    public MathOperationService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags,
                              int startId) {
        if (intent.getAction() == "math_op") {
            int a = intent.getIntExtra("a", 0);
            int b = intent.getIntExtra("b", 0);
            String op = intent.getStringExtra("op");
            //Log.d("@@@", String.valueOf(a) + ',' + String.valueOf(b));
            int c = -1;
            switch (op) {
                case "+":
                    c = a+b;
                    break;
                case "-":
                    c = a-b;
                    break;
                case "*":
                    c = a*b;
                    break;
                case "/":
                    c = a/b;
                    break;
            }
            // creating a new intent is required.
            Intent done = new Intent();
            done.setAction("math_op");
            done.putExtra("c", c);
            //Log.d("@@@", intent.getAction());
            sendBroadcast(done);
        }
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
