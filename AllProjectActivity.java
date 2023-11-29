package com.example.fibonacci;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AllProjectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_project);
    }
    public void SplashScreenActivity(View view) {
        Intent intent = new Intent(this, SplashScreenActivity.class);
        startActivity(intent);
    }
    // Metode untuk membuka aplikasi peta
    public void launchMap(View view) {
        // Koordinat lokasi yang akan ditampilkan di peta
        double latitude = -6.2088;
        double longitude = 106.8456;

        // Nama lokasi (opsional)
        String locationName = "Monas";

        // Buat Uri dengan menggunakan skema geo untuk menentukan lokasi
        Uri gmmIntentUri = Uri.parse("geo:" + latitude + "," + longitude + "?q=" + latitude + "," + longitude + "(" + locationName + ")");

        // Buat Intent dengan tindakan untuk menampilkan peta
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);

        // Set package untuk memastikan menggunakan aplikasi peta yang diinginkan
        mapIntent.setPackage("com.google.android.apps.maps");

        // Periksa apakah ada aplikasi peta yang dapat menangani Intent
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        } else {
            // Tampilkan pesan jika tidak ada aplikasi peta yang dapat menangani Intent
            Toast.makeText(this, "No map application found", Toast.LENGTH_SHORT).show();
        }
    }

    public void launchHalloProject(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void launchCountProject(View view) {
        Intent intent = new Intent(this, CountActivity.class);
        startActivity(intent);
    }

    public void launchSianidaProject(View view) {
        Intent intent = new Intent(this, ScrollSianida.class);
        startActivity(intent);
    }

    public void createAlarm(View view) {
        ArrayList<Integer> alarmDays = new ArrayList<>();
        alarmDays.add(2);
        alarmDays.add(3);
        alarmDays.add(4);

        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_DAYS, alarmDays)
                .putExtra(AlarmClock.EXTRA_MESSAGE, "Wake up!")
                .putExtra(AlarmClock.EXTRA_HOUR, 7)
                .putExtra(AlarmClock.EXTRA_MINUTES, 30)
                .putExtra(AlarmClock.EXTRA_VIBRATE, false);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void launchThirdActivity(View view) {
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);
    }

    public void launchTwoActivity(View view) {
        Intent intent = new Intent(this, FirstActivity.class);
        startActivity(intent);
    }

    public void quitButtonClick(View view) {
        finish(); // Mengakhiri aktivitas dan keluar dari aplikasi
    }
}