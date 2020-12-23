package com.example.foodorderingapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.foodorderingapp.Models.LoginModel;
import com.example.foodorderingapp.Models.OrderModel;
import com.example.foodorderingapp.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LoginAdapter extends RecyclerView.Adapter<LoginAdapter.viewHolder>{
    ArrayList<LoginModel> list;
    Context context;

    public LoginAdapter(ArrayList<LoginModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_order_food, parent, false);
        return new LoginAdapter.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        final LoginModel model = list.get(position);

        holder.gmail.setText(model.getGmail());
        holder.pass.setText(model.getPassword());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        EditText gmail, pass;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            gmail = itemView.findViewById(R.id.Gmail);
            pass = itemView.findViewById(R.id.etPassword);
        }
    }
}
