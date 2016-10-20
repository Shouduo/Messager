package com.shouduo.messager;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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
                        Fragment fragment = new ChatFragment();
                        FragmentManager fragmentManager = getFragmentManager();
                        FragmentTransaction transaction = fragmentManager.beginTransaction();
                        transaction.replace(R.id.content_framelayout, fragment);
                        transaction.addToBackStack(null);
                        transaction.commit();
                }
            }
        });
        return view;
    }

    private void mockPeopleData() {
        People kevin = new People("Kevin", 4836, R.drawable.kevin);
        peopleList.add(kevin);
        People elder = new People("Elder", 1989, R.drawable.elder);
        peopleList.add(elder);
    }

}
