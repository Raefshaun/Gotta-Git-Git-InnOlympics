package com.example.hackathon;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RateFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RateFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RateFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RateFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RateFragment newInstance(String param1, String param2) {
        RateFragment fragment = new RateFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_rate, container, false);

        LinearLayout rate1 = view.findViewById(R.id.rate1);
        LinearLayout rate2 = view.findViewById(R.id.rate2);
        LinearLayout rate3 = view.findViewById(R.id.rate3);
        LinearLayout rate4 = view.findViewById(R.id.rate4);
        LinearLayout rate5 = view.findViewById(R.id.rate5);

        rate1.setOnClickListener(v -> {
            Intent intent = new Intent(requireActivity(), Rating.class);
            startActivity(intent);
        });

        rate2.setOnClickListener(v -> {
            Intent intent = new Intent(requireActivity(), Rating.class);
            startActivity(intent);
        });

        rate3.setOnClickListener(v -> {
            Intent intent = new Intent(requireActivity(), Rating.class);
            startActivity(intent);
        });

        rate4.setOnClickListener(v -> {
            Intent intent = new Intent(requireActivity(), Rating.class);
            startActivity(intent);
        });

        rate5.setOnClickListener(v -> {
            Intent intent = new Intent(requireActivity(), Rating.class);
            startActivity(intent);
        });

        return view;
    }
}