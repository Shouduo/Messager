package com.shouduo.messager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 刘亨俊 on 16.10.18.
 */

public class PeopleAdapter extends ArrayAdapter<People> {

    private int resourceId;

    public PeopleAdapter(Context context, int textViewResourceId, List<People> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        People people = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
            viewHolder = new ViewHolder();
            viewHolder.peopleImage = (ImageView) view.findViewById(R.id.people_image);
            viewHolder.peopleName = (TextView) view.findViewById(R.id.people_name);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.peopleImage.setImageResource(people.getImage());
        viewHolder.peopleName.setText(people.getName());

        return view;
    }

    class ViewHolder {
        ImageView peopleImage;
        TextView peopleName;
    }
}
