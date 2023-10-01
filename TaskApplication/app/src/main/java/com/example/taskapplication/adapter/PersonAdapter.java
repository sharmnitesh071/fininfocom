package com.example.taskapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taskapplication.R;
import com.example.taskapplication.model.Person;

import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {

    private List<Person> people;

    public PersonAdapter(List<Person> people) {
        this.people = people;
    }


    @NonNull
    @Override
    public PersonAdapter.PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);
        return new PersonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.PersonViewHolder holder, int position) {
        Person person = people.get(position);

        holder.textName.setText(person.getName());
        holder.textCity.setText(person.getCity());
        holder.textAge.setText(String.valueOf(person.getAge()));
    }

    @Override
    public int getItemCount() {
        return people.size();
    }

    public class PersonViewHolder extends RecyclerView.ViewHolder {
        TextView textName, textCity, textAge;

        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.textName);
            textCity = itemView.findViewById(R.id.textCity);
            textAge = itemView.findViewById(R.id.textAge);
        }
    }
}
