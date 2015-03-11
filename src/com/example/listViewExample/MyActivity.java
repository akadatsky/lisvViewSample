package com.example.listViewExample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MyActivity extends Activity {

    private ListView listView;

    private int count;

    private MyAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        final List<String> myList = new ArrayList<String>();

        findViewById(R.id.ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 10; i++) {
                    myList.add("TEST" + count);
                    count++;
                }
                adapter.notifyDataSetChanged();
            }
        });


        for (int i = 0; i < 10; i++) {
            myList.add("TEST" + i);
            count++;
        }

        listView = (ListView) findViewById(R.id.listView);

        adapter = new MyAdapter(this, myList);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = adapter.getItem(position);
                Toast.makeText(MyActivity.this, "Text: " + item, Toast.LENGTH_SHORT).show();
            }
        });

    }

}
