package hcmus.selab.ntan.demoservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class ThreadService extends Service {
    public ThreadService() {
    }

    @Override
    public int onStartCommand(final Intent intent, int flags, int startId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    Intent done = new Intent();
                    done.setAction("math_op");
                    done.putExtra("c", i);
                    sendBroadcast(done);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
