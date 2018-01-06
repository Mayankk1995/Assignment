package com.example.android.assignment.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.assignment.R;
import com.example.android.assignment.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class ChristmasFragment extends Fragment {

    private StaggeredGridLayoutManager staggeredGridLayoutManager;

    public ChristmasFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_christmas, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        staggeredGridLayoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);

        List<Integer> listOfImages = new ArrayList<>();
        listOfImages.add(R.drawable.muffin);
        listOfImages.add(R.drawable.menu);
        listOfImages.add(R.drawable.muffins);
        listOfImages.add(R.drawable.random);
        listOfImages.add(R.drawable.muffins);
        listOfImages.add(R.drawable.butterfly);
        listOfImages.add(R.drawable.menu);
        listOfImages.add(R.drawable.scenery);
        listOfImages.add(R.drawable.butterfly);

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(),listOfImages);
        recyclerView.setAdapter(recyclerViewAdapter);

        return view;
    }
}
