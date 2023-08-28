package com.example.contact_database_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton Add;
    RecyclerView recyclerView;
    ArrayList<ContactList_Model>contactList=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Add=findViewById(R.id.Add);
        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        ShowData();

      Add.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent=new Intent(MainActivity.this, Add_Contact_Activity.class);
              startActivity(intent);
          }
      });
      Recyclerview_Adapter adapter=new Recyclerview_Adapter(MainActivity.this,contactList);
      recyclerView.setAdapter(adapter);

    }

    private void ShowData() {
    My_Database myDatabase=new My_Database(MainActivity.this);
        Cursor cursor=myDatabase.ShowData();
        while (cursor.moveToNext())
        {
            int id=cursor.getInt(0);
            String name=cursor.getString(1);
            String number=cursor.getString(2);
           ContactList_Model contact=new ContactList_Model(id,name,number);
           contactList.add(contact);
            Log.d("TTT", "ShowData: "+contact);

        }
    }
}