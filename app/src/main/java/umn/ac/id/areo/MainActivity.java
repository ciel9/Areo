package umn.ac.id.areo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
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

        //memberikan event kpd logo
        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //menuju halaman lain
                Intent a = new Intent(MainActivity.this, StartActivity.class);
                startActivity(a);
                finish();
            }
        });

    }
}