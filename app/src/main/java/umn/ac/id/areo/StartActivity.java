package umn.ac.id.areo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class StartActivity extends AppCompatActivity {

    // variabel
    String Myemail = "oracle@gmail.com";
    Boolean kondisi = true;
    EditText email;
    Integer angka1 = 100, angka2 = 250, angka3 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        //menargetkan elemen
        email = findViewById(R.id.email);

        //operator aritmatik
        angka3 = angka1 + angka2;

        if(angka3 == 550){
            //jawaban bener
            //membuat alert
            Toast.makeText(getApplicationContext(), "True Number", Toast.LENGTH_SHORT).show();
        }
        else {

            //jawaban salah
            //membuat alert
            Toast.makeText(getApplicationContext(), "Wrong Number", Toast.LENGTH_SHORT).show();
        }
    }
}