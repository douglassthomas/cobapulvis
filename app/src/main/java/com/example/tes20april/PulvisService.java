package com.example.tes20april;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class PulvisService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        showNotif(remoteMessage.getNotification().getTitle(),
                remoteMessage.getNotification().getBody());
    }


    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);
    }

    public void showNotif(String title, String message){
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("myNotif", "Background Service", NotificationManager.IMPORTANCE_DEFAULT);

            manager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "myNotif")
                .setContentTitle(title)
                .setSmallIcon(R.drawable.ic_account_circle_black_24dp)
                .setAutoCancel(true)
                .setContentText(message);

        manager.notify(999, builder.build());
    }
}
