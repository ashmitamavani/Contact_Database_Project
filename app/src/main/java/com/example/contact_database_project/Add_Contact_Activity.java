package com.example.contact_database_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

public class Add_Contact_Activity extends AppCompatActivity {
    ImageView morebutton;
    AppCompatEditText name,number;
    AppCompatButton save;
    int id;
    String name1,number1;
    My_Database myDatabase=new My_Database(Add_Contact_Activity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        name=findViewById(R.id.name);
        number=findViewById(R.id.number);
        save=findViewById(R.id.save);
        morebutton=findViewById(R.id.morebutton);

        id=getIntent().getIntExtra("id",0);
        name1=getIntent().getStringExtra("name");
        number1=getIntent().getStringExtra("number");

        if (getIntent().getExtras()!=null)
        {
            name.setText(""+name1);
            number.setText(""+number1);
        }

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           if (getIntent().getExtras()==null)
           {
               String n1=name.getText().toString();
               String n2=number.getText().toString();
               myDatabase.AddContact(""+n1,""+n2);
           }
           else
           {
              String n1=name.getText().toString();
              String n2=number.getText().toString();
              myDatabase.UpdateContact(id,""+n1,""+n2);
               Log.d("YYY", "onClick: get ID==="+id);
           }

                Intent intent=new Intent(Add_Contact_Activity.this, MainActivity.class);
               startActivity(intent);

            }
        });
        morebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu=new PopupMenu(Add_Contact_Activity.this,morebutton);
                popupMenu.getMenuInflater().inflate(R.menu.delete_menu_file,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        if (item.getItemId()==R.id.delete)
                        {
                            myDatabase=new My_Database(Add_Contact_Activity.this);
                            myDatabase.DeleteContact(id);
                            Log.d("TTT", "onMenuItemClick: Delete ID==="+id);
                            Toast.makeText(Add_Contact_Activity.this, "Delete", Toast.LENGTH_SHORT).show();
                        }
                        Intent intent=new Intent(Add_Contact_Activity.this,MainActivity.class);
                        startActivity(intent);
                        return true;
                    }
                });
                popupMenu.show();
            }
        });
    }
}