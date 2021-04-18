package umn.ac.id.areo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class DetailTicketActivity extends AppCompatActivity {

    LinearLayout btn_back2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_ticket);

        btn_back2 = findViewById(R.id.btn_back2);
        btn_back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backprofil = new Intent(DetailTicketActivity.this, MyProfileActivity.class);
                startActivity(backprofil);
            }
        });
    }
}