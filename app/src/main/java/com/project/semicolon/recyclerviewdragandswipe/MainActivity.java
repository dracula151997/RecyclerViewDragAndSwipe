package com.project.semicolon.recyclerviewdragandswipe;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements RecyclerViewAdapter.OnStartDragListener {
    private RecyclerView recyclerView;
    RecyclerViewAdapter adapter;
    ItemTouchHelper touchHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);
//        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        adapter = new RecyclerViewAdapter();
        recyclerView.setAdapter(adapter);
        adapter.setOnStartDragListener(this);
        ItemTouchHelper.Callback callback = new RecyclerItemTouchHelper(adapter);
        touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(recyclerView);

        fetchData();
    }

    private void fetchData() {
        List<Contact> items = new ArrayList<>();
        items.add(new Contact("Philippe Vlies", "(282) 1960601", "https://robohash.org/quiaeumeos.bmp?size=500x500&set=set1"));
        items.add(new Contact("Elwood Elsie", "(554) 7289424", "https://robohash.org/quisconsequaturvoluptas.png?size=500x500&set=set1"));
        items.add(new Contact("Aubert Playford", "(715) 8220526", "https://robohash.org/laboreestid.bmp?size=500x500&set=set1"));
        items.add(new Contact("Booth Ferronier", "(766) 8111442", "https://robohash.org/nesciunttotamquam.bmp?size=500x500&set=set1"));
        items.add(new Contact("Gibby Ralston", "(200) 7464680", "https://robohash.org/utsitid.png?size=500x500&set=set1"));
        items.add(new Contact("Irwinn Eckford", "(303) 5626885", "https://robohash.org/quodeasaepe.png?size=500x500&set=set1"));

        adapter.setItem(items);
    }

    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        //call startDrag() to start drag and update the ViewHolder to include the new handle view.
        touchHelper.startDrag(viewHolder);


    }
}
