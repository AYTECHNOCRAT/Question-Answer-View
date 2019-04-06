package com.example.assignment1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class UserInterest extends AppCompatActivity {
    ListView choice_list,selected_list;
    int max=0;
    String[] choic={"Java","Python","HTML","XML","Kotlin","PHP","JavaScript"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_interest);
        ArrayAdapter adapter=new ArrayAdapter(this,R.layout.listview,choic);
        choice_list=findViewById(R.id.l2);
        selected_list=findViewById(R.id.l1);
        final ArrayList<String> select=new ArrayList<String>();
        choice_list.setAdapter(adapter);
        final ArrayAdapter adapter1= new ArrayAdapter(this,R.layout.listview,select);
        choice_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item=choice_list.getItemAtPosition(position).toString();
                select.add(item);
                max++;
                selected_list.setAdapter(adapter1);
            }
        });
        if(max==4){
            Intent i=new Intent(this,Questionlist.class);
            startActivity(i);
        }

    }
}
