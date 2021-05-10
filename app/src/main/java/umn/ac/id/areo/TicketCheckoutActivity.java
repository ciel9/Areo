package umn.ac.id.areo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TicketCheckoutActivity extends AppCompatActivity {

    Button btn_buy_ticket, btnminus, btnplus;
    LinearLayout btn_back;
    TextView textjumlahtiket, textbalance, texttotal;
    Integer valuejumlahtiket = 1;
    Integer mybalance = 150000;
    Integer total = 90000;
    Integer hargatiket = 45000;
    ImageView notice_uang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_checkout);

        btn_back = findViewById(R.id.btn_back);
        btn_buy_ticket = findViewById(R.id.btn_buy_ticket);
        btnminus = findViewById(R.id.btnminus);
        btnplus = findViewById(R.id.btnplus);
        textjumlahtiket = findViewById(R.id.textjumlahtiket);
        textbalance = findViewById(R.id.textbalance);
        texttotal = findViewById(R.id.texttotal);
        notice_uang = findViewById(R.id.notice_uang);

        // mengatur nilai dr bbrp komponen
        textbalance.setText("Rp. "+ mybalance+ "");
        textjumlahtiket.setText(valuejumlahtiket.toString());
        total = hargatiket * valuejumlahtiket;
        texttotal.setText("Rp. "+total+ "");
        textbalance.setTextColor(Color.parseColor("#203DD1"));

        //menyembunyikan button minus di awal
        btnminus.animate().alpha(0).setDuration(300).start();
        btnminus.setEnabled(false);
        notice_uang.setVisibility(View.GONE);

        btnplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valuejumlahtiket+=1;
                textjumlahtiket.setText(valuejumlahtiket.toString());
                if (valuejumlahtiket > 1){
                    btnminus.animate().alpha(1).setDuration(300).start();
                    btnminus.setEnabled(true);
                }
                total = hargatiket * valuejumlahtiket;
                texttotal.setText("Rp. "+total+ "");
                if (total > mybalance){
                    btn_buy_ticket.animate().translationY(250).alpha(0).setDuration(350).start();
                    btn_buy_ticket.setEnabled(false);
                    textbalance.setTextColor(Color.parseColor("#D1206B"));
                    notice_uang.setVisibility(View.VISIBLE);
                }
            }
        });

        btnminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valuejumlahtiket-=1;
                textjumlahtiket.setText(valuejumlahtiket.toString());
                if (valuejumlahtiket < 2){
                    btnminus.animate().alpha(0).setDuration(300).start();
                    btnminus.setEnabled(false);
                }
                total = hargatiket * valuejumlahtiket;
                texttotal.setText("Rp. "+total+ "");
                if (total < mybalance){
                    btn_buy_ticket.animate().translationY(0).alpha(1).setDuration(350).start();
                    btn_buy_ticket.setEnabled(true);
                    textbalance.setTextColor(Color.parseColor("#203DD1"));
                    notice_uang.setVisibility(View.GONE);
                }
            }
        });

        btn_buy_ticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pay = new Intent(TicketCheckoutActivity.this, SuccessBuyTicketActivity.class);
                startActivity(pay);
            }
        });


        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backtodetail = new Intent(TicketCheckoutActivity.this, TicketDetailActivity.class);
                startActivity(backtodetail);
            }
        });
    }
}