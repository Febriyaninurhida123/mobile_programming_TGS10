# mobile_programming_TGS10
```
Febriyani Nurhida
312210222
TI.22.A2
```
## Intruksi Tugas
Buatlah tampilan menu Versi 02 dari project-project yang sudah dibuat sebelumnya 

dengan tambahan memanggil method Maps

dengan tampilan sebagai berikut :

 ![image](https://github.com/Febriyaninurhida123/mobile_programming_TGS10/assets/90132092/8eb863fb-7882-4310-acd0-c040c6dee8d0)

## Langkah-Langkah
Kita tambahkan metode untuk memanggil maps di project kita dengan cara :
```
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
```
<img width="1080" alt="image" src="https://github.com/Febriyaninurhida123/mobile_programming_TGS10/assets/90132092/8ee43de4-367f-4291-9d6f-84140df5b449">

### berikut adalah kodingan lengkapnya:
```
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
```

### setelah itu kita akan menambahkan button maps di project kita, dengan cara:

```
<ImageButton
            android:id="@+id/button_map"
            android:layout_width="0dp"
            android:layout_height="0dp"
            android:layout_rowWeight="1"
            android:layout_columnWeight="1"
            android:layout_margin="8dp"
            android:background="@drawable/circle_button_background"
            android:onClick="launchMap"
            android:padding="16dp"
            android:scaleType="centerCrop"
            android:src="@drawable/ssw" />
```
<img width="1080" alt="image" src="https://github.com/Febriyaninurhida123/mobile_programming_TGS10/assets/90132092/517fc652-7da8-47b1-930a-16998919543b">

### jika sudah sekarang kita tinggal mengedit tampilan button agar sesuai dengan instruksi tugas dengan cara:
1. pertama kita buat dulu file xml di drawable untuk buttonnya, di sini saya beri nama circle_button_background.xml
```
<shape xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape="oval">
    <solid android:color="@color/pink"/>
</shape>
```
<img width="1080" alt="image" src="https://github.com/Febriyaninurhida123/mobile_programming_TGS10/assets/90132092/c47e1a94-3e3a-47a0-8c75-caed7ac3f0f6">

### Barulah kita edit file xml layout kita,

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#FFDCF1"
    android:orientation="vertical"
    tools:context=".AllProjectActivity">

    <GridLayout
        android:layout_width="match_parent"
        android:layout_height="601dp"
        android:layout_margin="8dp"
        android:alignmentMode="alignMargins"
        android:columnCount="2"
        android:columnOrderPreserved="false"
        android:rowCount="4">

        <!-- Button Hello -->
        <ImageButton
            android:id="@+id/button_project_hallo"
            android:layout_width="0dp"
            android:layout_height="0dp"
            android:layout_rowWeight="1"
            android:layout_columnWeight="1"
            android:layout_margin="8dp"
            android:background="@drawable/circle_button_background"
            android:onClick="launchHalloProject"
            android:padding="16dp"
            android:scaleType="fitCenter"
            android:src="@drawable/hello" />

        <!-- Button Sianida -->
        <ImageButton
            android:id="@+id/button_project_sianida"
            android:layout_width="0dp"
            android:layout_height="0dp"
            android:layout_rowWeight="1"
            android:layout_columnWeight="1"
            android:layout_margin="8dp"
            android:background="@drawable/circle_button_background"
            android:onClick="launchSianidaProject"
            android:padding="16dp"
            android:scaleType="fitCenter"
            android:src="@drawable/alchemy" />

        <!-- Button Count -->
        <ImageButton
            android:id="@+id/button_project_count"
            android:layout_width="0dp"
            android:layout_height="0dp"
            android:layout_rowWeight="1"
            android:layout_columnWeight="1"
            android:layout_margin="8dp"
            android:background="@drawable/circle_button_background"
            android:onClick="launchCountProject"
            android:padding="16dp"
            android:scaleType="fitCenter"
            android:src="@drawable/counting" />

        <!-- Button TwoActivity -->
        <ImageButton
            android:id="@+id/button_TwoActivity"
            android:layout_width="0dp"
            android:layout_height="0dp"
            android:layout_rowWeight="1"
            android:layout_columnWeight="1"
            android:layout_margin="8dp"
            android:background="@drawable/circle_button_background"
            android:onClick="launchTwoActivity"
            android:padding="16dp"
            android:scaleType="fitCenter"
            android:src="@drawable/messege" />

        <!-- Button Map -->
        <ImageButton
            android:id="@+id/button_map"
            android:layout_width="0dp"
            android:layout_height="0dp"
            android:layout_rowWeight="1"
            android:layout_columnWeight="1"
            android:layout_margin="8dp"
            android:background="@drawable/circle_button_background"
            android:onClick="launchMap"
            android:padding="16dp"
            android:scaleType="centerCrop"
            android:src="@drawable/ssw" />

        <!-- Button Alarm -->
        <ImageButton
            android:id="@+id/button_Alarm"
            android:layout_width="0dp"
            android:layout_height="0dp"
            android:layout_rowWeight="1"
            android:layout_columnWeight="1"
            android:layout_margin="8dp"
            android:background="@drawable/circle_button_background"
            android:onClick="createAlarm"
            android:padding="16dp"
            android:scaleType="centerCrop"
            android:src="@drawable/clock" />
    </GridLayout>

    <ImageButton
        android:id="@+id/button_quit"
        android:layout_width="80dp"
        android:layout_height="68dp"
        android:layout_gravity="center|bottom"
        android:layout_margin="8dp"
        android:background="@drawable/circle_button_background"
        android:onClick="quitButtonClick"
        android:padding="16dp"
        android:scaleType="centerCrop"
        android:src="@drawable/log" />

</LinearLayout>
```
<img width="1080" alt="image" src="https://github.com/Febriyaninurhida123/mobile_programming_TGS10/assets/90132092/0b8369bc-04ed-45f4-89b6-a01f52bb4859">

### nanti tampilannya akan seperti ini:
<img width="1080" alt="image" src="https://github.com/Febriyaninurhida123/mobile_programming_TGS10/assets/90132092/bbf8890d-77de-45a7-b82e-8882b21d2ed5">

## berikut adalah demo dari project :
