package umn.ac.id.areo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class HomeActivity extends AppCompatActivity {

    ImageView pic_photo_home_user_circled;
    TextView nama_lengkap,bio, user_balance;
    LinearLayout btn_ticket_pisa;

    DatabaseReference reference;
     String USERNAME_KEY = "usernamekey";
     String username_key = "";
     String username_key_new = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getUsernameLocal();

        btn_ticket_pisa = findViewById(R.id.btn_ticket_pisa);
        pic_photo_home_user_circled = findViewById(R.id.pic_photo_home_user_circled);
        nama_lengkap = findViewById(R.id.nama_lengkap);
        bio = findViewById(R.id.bio);
        user_balance = findViewById(R.id.user_balance);

        reference = FirebaseDatabase.getInstance().getReference().child("Users")
                .child(username_key_new);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                nama_lengkap.setText(snapshot.child("nama_lengkap").getValue().toString());
                bio.setText(snapshot.child("bio").getValue().toString());
                user_balance.setText("Rp. " + snapshot.child("user_balance").getValue().toString());
                Picasso.with(HomeActivity.this).load(snapshot.child("url_photo_profile").getValue()
                        .toString()).centerCrop().fit().into(pic_photo_home_user_circled);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        btn_ticket_pisa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detail = new Intent(HomeActivity.this, TicketDetailActivity.class);
                startActivity(detail);
            }
        });


        pic_photo_home_user_circled.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent profile = new Intent(HomeActivity.this, MyProfileActivity.class);
                startActivity(profile);
            }
        });
    }
    public void getUsernameLocal(){
        SharedPreferences sharedPreferences = getSharedPreferences(USERNAME_KEY, MODE_PRIVATE);
        username_key_new = sharedPreferences.getString(username_key, "");

    }
}