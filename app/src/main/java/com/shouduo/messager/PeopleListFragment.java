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
//    private Bitmap photo;

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

//        photo = ((MainActivity)getActivity()).getPhoto();


        PeopleAdapter peopleAdapter = new PeopleAdapter(getContext(), R.layout.people_item, peopleList);
        ListView listView = (ListView) view.findViewById(R.id.people_listview);
        listView.setAdapter(peopleAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                People people = peopleList.get(position);
                Intent intent = new Intent(getContext(), ChatActivity.class);
                intent.putExtra("people", people);
//                intent.putExtra("photo", photo);  //something wrong here
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

        List<Msg> kevinMsgList = new ArrayList<>();
        Msg msg1 = new Msg("Hello?", Msg.TYPE_RECEIVED, R.drawable.kevin);
        kevinMsgList.add(msg1);
        Msg msg2 = new Msg("Excited. Who is that", Msg.TYPE_SENT, R.drawable.nickyoung);
        kevinMsgList.add(msg2);
        Msg msg3 = new Msg("在下骚文，有何贵干", Msg.TYPE_RECEIVED, R.drawable.kevin);
        kevinMsgList.add(msg3);
        Msg msg4 = new Msg("他强任他强，劳资尼克杨", Msg.TYPE_SENT, R.drawable.nickyoung);
        kevinMsgList.add(msg4);

        List<Msg> elderMsgList = new ArrayList<>();
        Msg msg5 = new Msg("西方记者?", Msg.TYPE_RECEIVED, R.drawable.elder);
        elderMsgList.add(msg5);
        Msg msg6 = new Msg("蛤？", Msg.TYPE_SENT, R.drawable.nickyoung);
        elderMsgList.add(msg6);
        Msg msg7 = new Msg("当时我就说了两句诗", Msg.TYPE_RECEIVED, R.drawable.elder);
        elderMsgList.add(msg7);
        Msg msg8 = new Msg("???", Msg.TYPE_SENT, R.drawable.nickyoung);
        elderMsgList.add(msg8);
        Msg msg9 = new Msg("苟利国家生死以……", Msg.TYPE_RECEIVED, R.drawable.elder);
        elderMsgList.add(msg9);

        kevin.setMsgList(kevinMsgList);
        elder.setMsgList(elderMsgList);

        peopleList.add(kevin);
        peopleList.add(elder);

    }

}
