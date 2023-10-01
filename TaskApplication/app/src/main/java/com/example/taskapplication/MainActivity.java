package com.example.taskapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.taskapplication.adapter.PersonAdapter;
import com.example.taskapplication.model.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private enum SortOrder {
        NAME,
        CITY,
        AGE
    }
    private SortOrder currentSortOrder = SortOrder.NAME; // Default sorting by name
    private RecyclerView recyclerView;
    private PersonAdapter adapter;
    private List<Person> people;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        people = generateDummyData();
        adapter = new PersonAdapter(people);
        recyclerView.setAdapter(adapter);

        // Initialize sorting buttons
        Button sortByNameButton = findViewById(R.id.sortByNameButton);
        Button sortByCityButton = findViewById(R.id.sortByCityButton);
        Button sortByAgeButton = findViewById(R.id.sortByAgeButton);

        sortByNameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentSortOrder = SortOrder.NAME;
                sortData();
                adapter.notifyDataSetChanged();
            }
        });

        sortByCityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentSortOrder = SortOrder.CITY;
                sortData();
                adapter.notifyDataSetChanged();
            }
        });

        sortByAgeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentSortOrder = SortOrder.AGE;
                sortData();
                adapter.notifyDataSetChanged();
            }
        });


    }

    private List<Person> generateDummyData() {
        List<Person> people = new ArrayList<>();
        // Add your dummy data here
        people.add(new Person("John Doe", "New York", 30));
        people.add(new Person("Jane Smith", "Los Angeles", 25));
        people.add(new Person("Alice Johnson", "Chicago", 35));
        people.add(new Person("Bob Johnson", "San Francisco", 40));
        people.add(new Person("Emily Davis", "Miami", 28));
        people.add(new Person("Michael Wilson", "Houston", 45));
        people.add(new Person("Linda Lee", "Boston", 29));
        people.add(new Person("David Brown", "Philadelphia", 37));
        people.add(new Person("Sarah Turner", "Seattle", 33));
        people.add(new Person("Kevin Adams", "Denver", 32));
        people.add(new Person("Jennifer White", "Austin", 31));
        // Add more data as needed
        return people;
    }
    private void sortData() {
        switch (currentSortOrder) {
            case NAME:
                Collections.sort(people, new Comparator<Person>() {
                    @Override
                    public int compare(Person person1, Person person2) {
                        return person1.getName().compareTo(person2.getName());
                    }
                });
                break;
            case CITY:
                Collections.sort(people, new Comparator<Person>() {
                    @Override
                    public int compare(Person person1, Person person2) {
                        return person1.getCity().compareTo(person2.getCity());
                    }
                });
                break;
            case AGE:
                Collections.sort(people, new Comparator<Person>() {
                    @Override
                    public int compare(Person person1, Person person2) {
                        return Integer.compare(person1.getAge(), person2.getAge());
                    }
                });
                break;
        }
    }
}