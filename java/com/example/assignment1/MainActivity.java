package com.example.assignment1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button lgin;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lgin=findViewById(R.id.b1);
        sp=getSharedPreferences("login",MODE_PRIVATE);
        if(sp.getBoolean("logged",false)){
            gotoMainActivity();
        }

        lgin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoMainActivity();
                sp.edit().putBoolean("logged",true);
            }
        });


    }

    public void gotoMainActivity() {
        Intent i=new Intent(this,UserInterest.class);
        startActivity(i);
    }
}
