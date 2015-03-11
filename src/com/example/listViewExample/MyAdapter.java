package com.example.listViewExample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends ArrayAdapter<String> {

    private final LayoutInflater inflater;

    public MyAdapter(Context context, List<String> objects) {
        super(context, 0, objects);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item, parent, false);
            TextView text = (TextView) convertView.findViewById(R.id.text);
            convertView.setTag(text);
        }

        String item = getItem(position);

        TextView text = (TextView) convertView.getTag();
        text.setText(item);

        return convertView;
    }
}
