package com.example.viewpageapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TabFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TabFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "mode";

    // TODO: Rename and change types of parameters
    private int mode;

    public TabFragment() {
        // Required empty public constructor
    }

    public TabFragment(int mode){
        this.mode = mode;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param mode filter mode for registers:
     *             - 0 = Today
     *             - 1 = Week
     *             - 2 = Month
     *             - 3 = Year
     * @return A new instance of fragment TabFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TabFragment newInstance(int mode) {
        TabFragment fragment = new TabFragment();
        Bundle args = new Bundle();
        args.putInt("mode", mode);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.mode = getArguments().getInt(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        System.out.println("Fragment Mode: " + this.mode);
        System.out.println("Fragment Mode (Bundle): " + getArguments().getInt("mode"));
        TextView label = (TextView) view.findViewById(R.id.label);

        load_charts(view);
    }

    private void load_charts(View view) {
        Random rnd = new Random();
        LineChart lineChart = view.findViewById(R.id.linechart);
        PieChart pieChart = view.findViewById(R.id.piechart);

        List<Entry> entries_line = new ArrayList<>();
        List<PieEntry> entries_pie = new ArrayList<>();

        for(int i = 0; i < 50; i++){
            entries_line.add(new Entry(i, rnd.nextFloat() + rnd.nextInt(50)));
        }
        float pie1 = rnd.nextFloat();
        float pie2 = 1 - pie1;

        entries_pie.add(new PieEntry(pie1, "Label 1"));
        entries_pie.add(new PieEntry(pie2, "Label 2"));

        LineDataSet dataSet_line = new LineDataSet(entries_line, "LineChart");
        PieDataSet dataSet_pie = new PieDataSet(entries_pie, "PieChart");
        dataSet_pie.setColors(ColorTemplate.PASTEL_COLORS);
        dataSet_pie.setSliceSpace(1);

        LineData data_line = new LineData(dataSet_line);
        PieData data_pie = new PieData(dataSet_pie);

        lineChart.setData(data_line);
        pieChart.setData(data_pie);
        pieChart.setUsePercentValues(true);

        lineChart.invalidate();
        pieChart.invalidate();
    }
}