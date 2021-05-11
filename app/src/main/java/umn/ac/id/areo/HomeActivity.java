package umn.ac.id.areo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class HomeActivity extends AppCompatActivity {

    ImageView pic_photo_home_user_circled;
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

        pic_photo_home_user_circled = findViewById(R.id.pic_photo_home_user_circled);
        pic_photo_home_user_circled.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent profile = new Intent(HomeActivity.this, MyProfileActivity.class);
                startActivity(profile);
            }
        });
    }
}