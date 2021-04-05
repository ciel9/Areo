package umn.ac.id.areo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mentargertkan komponen pada XML
        logo = findViewById(R.id.logo);

        //memberi warna pada komponen
        logo.setBackgroundColor(Color.RED);
    }
}