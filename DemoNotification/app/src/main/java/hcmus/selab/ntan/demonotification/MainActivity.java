package hcmus.selab.ntan.demonotification;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Notification.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pending = PendingIntent.getActivity(
                this, 0, intent, 0);

        builder = new Notification.Builder(this)
                .setContentTitle("sample nofiticaiton")
                .setContentText("This is a sample of notification")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentIntent(pending);
    }

    public void lnlo_onclick(View view) {
        Notification ntf = builder.build();
        NotificationManager manager = (NotificationManager)
                getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(123, ntf);
    }
}
