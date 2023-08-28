package com.example.contact_database_project;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Recyclerview_Adapter extends RecyclerView.Adapter<Recyclerview_Adapter.Holder> {
    MainActivity mainActivity;
    ArrayList<ContactList_Model> contactList;
    public Recyclerview_Adapter(MainActivity mainActivity, ArrayList<ContactList_Model> contactList) {
        this.mainActivity=mainActivity;
        this.contactList=contactList;
    }

    @NonNull
    @Override
    public Recyclerview_Adapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mainActivity).inflate(R.layout.recyclreview_item_file,parent,false);
        Holder holder=new Holder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Recyclerview_Adapter.Holder holder, @SuppressLint("RecyclerView") int position) {
        holder.item_name.setText(contactList.get(position).getName());
        holder.item_number.setText(contactList.get(position).getNumber());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mainActivity, Add_Contact_Activity.class);
                 intent.putExtra("id",contactList.get(position).getId());
                 intent.putExtra("name",contactList.get(position).getName());
                 intent.putExtra("number",contactList.get(position).getNumber());
                mainActivity.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView item_name,item_number;
        public Holder(@NonNull View itemView) {
            super(itemView);
            item_name=itemView.findViewById(R.id.item_name);
            item_number=itemView.findViewById(R.id.item_number);
        }
    }
}
