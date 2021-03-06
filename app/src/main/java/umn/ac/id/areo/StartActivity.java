package umn.ac.id.areo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class StartActivity extends AppCompatActivity {
    Animation ttb, btt;
    Button btn_sign_in;
    Button btn_regis;
    TextView intro_app, app_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        //load animation
        ttb = AnimationUtils.loadAnimation(this, R.anim.ttb);
        btt = AnimationUtils.loadAnimation(this, R.anim.btt);

        intro_app = findViewById(R.id.intro_app);
        btn_sign_in = findViewById(R.id.btn_sign_in);
        btn_regis = findViewById(R.id.btn_regis);
        app_text = findViewById(R.id.app_text);

        //run animation
        intro_app.startAnimation(ttb);
        btn_sign_in.startAnimation(btt);
        btn_regis.startAnimation(btt);
        app_text.startAnimation(ttb);


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