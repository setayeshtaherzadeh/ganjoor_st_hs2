package com.example.falhafez;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class postadapter extends RecyclerView.Adapter<postadapter.ViewHolder> {


    private List<post> postList;

    public postadapter(List<post> postList) {
        this.postList = postList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.name.setText("نام شاعر : "+postList.get(position).getName());
        holder.place.setText("تاریخ تولد (هجری) : "+postList.get(position).getBirthPlace());
        holder.death.setText("تاریخ وفات (هجری) : "+postList.get(position).getDeathYearInLHijri());
        holder.birth.setText("مکان تولد : "+postList.get(position).getBirthPlace());

    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView birth;
        TextView death;
        TextView place;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name =itemView.findViewById(R.id.name);
            birth =itemView.findViewById(R.id.brith);
            death =itemView.findViewById(R.id.dead);
            place =itemView.findViewById(R.id.dead2);
        }
    }
}
