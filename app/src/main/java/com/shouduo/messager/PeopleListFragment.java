package com.shouduo.messager;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class PeopleListFragment extends Fragment {

    private List<People> peopleList = new ArrayList<>();

    public PeopleListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_people_list, container, false);

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mockPeopleData();
        PeopleAdapter peopleAdapter = new PeopleAdapter(getContext(), R.layout.people_item, peopleList);
        ListView listView = (ListView) view.findViewById(R.id.people_listview);
        listView.setAdapter(peopleAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                People people = peopleList.get(position);
                switch (people.getName()) {
                    case "Kevin":
                        break;
                    default:
                        break;
                }
                Intent intent = new Intent(getContext(), ChatActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        peopleList.clear();
    }

    private void mockPeopleData() {
        People kevin = new People("Kevin", 4836, R.drawable.kevin);
        People elder = new People("Elder", 1989, R.drawable.elder);
        peopleList.add(kevin);
        peopleList.add(elder);
    }

}
