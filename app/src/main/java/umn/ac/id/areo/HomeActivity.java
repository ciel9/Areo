package umn.ac.id.areo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class HomeActivity extends AppCompatActivity {

    ImageView btn_to_profile;
    LinearLayout btn_ticket_pisa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btn_ticket_pisa = findViewById(R.id.btn_ticket_pisa);
        btn_ticket_pisa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detail = new Intent(HomeActivity.this, TicketDetailActivity.class);
                startActivity(detail);
            }
        });

        btn_to_profile = findViewById(R.id.btn_to_profile);
        btn_to_profile.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent profile = new Intent(HomeActivity.this, MyProfileActivity.class);
                startActivity(profile);
            }
        });
    }
}