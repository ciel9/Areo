package umn.ac.id.areo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StartActivity extends AppCompatActivity {

    Button btn_sign_in;
    Button btn_regis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        btn_sign_in = findViewById(R.id.btn_sign_in);
        btn_regis = findViewById(R.id.btn_regis);

        btn_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotosign = new Intent(StartActivity.this, SigninActivity.class);
                startActivity(gotosign);
            }
        });
        btn_regis.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent regis = new Intent(StartActivity.this, RegisterOneActivity.class);
                startActivity(regis);
            }
        });

    }
}