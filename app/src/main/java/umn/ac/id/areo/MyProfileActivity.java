package umn.ac.id.areo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MyProfileActivity extends AppCompatActivity {

    ImageView back2;
    ImageView ticket_detail1;
    ImageView image2;
    Button btn_edit_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        back2 = findViewById(R.id.back2);
        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backtohome = new Intent(MyProfileActivity.this, HomeActivity.class);
                startActivity(backtohome);
            }
        });

        ticket_detail1 = findViewById(R.id.ticket_detail1);
        ticket_detail1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gototicket = new Intent(MyProfileActivity.this, DetailTicketActivity.class);
                startActivity(gototicket);
            }
        });
        image2 = findViewById(R.id.image2);
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gototicket2 = new Intent(MyProfileActivity.this, DetailTicketActivity.class);
                startActivity(gototicket2);
            }
        });

        btn_edit_profile = findViewById(R.id.btn_edit_profile);
        btn_edit_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent editprofil = new Intent(MyProfileActivity.this, EditProfilActivity.class);
                startActivity(editprofil);
            }
        });
    }
}