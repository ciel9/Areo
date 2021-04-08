package umn.ac.id.areo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mendapati id pada xml
        logo = findViewById(R.id.logo);

        //membuat timer untuk pindah activity secara otomatis
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //melakukan sesuatu setelah delay selama 2000
                Intent start = new Intent(MainActivity.this, StartActivity.class);
                startActivity(start);
                finish();
            }
        }, 2000);
    }
}