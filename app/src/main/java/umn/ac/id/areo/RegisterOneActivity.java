package umn.ac.id.areo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RegisterOneActivity extends AppCompatActivity {
    Button btn_continue;
    LinearLayout btn_back;
    EditText username, password, email_address;
    DatabaseReference reference;

    String USERNAME_KEY = "usernamekey";
    String username_key = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_one);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        email_address = findViewById(R.id.email_address);
        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(RegisterOneActivity.this, SigninActivity.class);
                startActivity(back);
            }
        });

        btn_continue = findViewById(R.id.btn_continue);
        btn_continue.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //ubah button jadi loading ketika sudah di klik
                btn_continue.setEnabled(false);
                btn_continue.setText("Loading ...");
                //menyimpan data ke local storage
                SharedPreferences sharedPreferences = getSharedPreferences(USERNAME_KEY, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(username_key, username.getText().toString());
                editor.apply();

                //simpan ke database
                reference = FirebaseDatabase.getInstance().getReference()
                        .child("Users").child(username.getText().toString());
                reference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        snapshot.getRef().child("username").setValue(username.getText().toString());
                        snapshot.getRef().child("password").setValue(password.getText().toString());
                        snapshot.getRef().child("email_address").setValue(email_address.getText().toString());
                        snapshot.getRef().child("user_balance").setValue(170000);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                //pindah activity
                Intent next = new Intent(RegisterOneActivity.this, RegisterTwoActivity.class);
                startActivity(next);
            }
        });
    }
}