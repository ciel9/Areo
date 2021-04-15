package umn.ac.id.areo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class RegisterTwoActivity extends AppCompatActivity {
    LinearLayout btn_back;
    Button btn_continue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_two);

        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backone = new Intent(RegisterTwoActivity.this, RegisterOneActivity.class);
                startActivity(backone);
            }
        });
        
        btn_continue = findViewById(R.id.btn_continue);
        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextsucces = new Intent(RegisterTwoActivity.this, SuccessRegisterActivity.class);
                startActivity(nextsucces);
            }
        });
    }
}