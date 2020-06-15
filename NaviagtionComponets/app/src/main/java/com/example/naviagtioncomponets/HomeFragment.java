package com.example.naviagtioncomponets;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }

    Button b1,b2,b3,b4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        b1 = v.findViewById(R.id.red);
        b2 = v.findViewById(R.id.green);
        b3 = v.findViewById(R.id.blue);
        b4 = v.findViewById(R.id.activity_one);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller = Navigation.findNavController(v);
                controller.navigate(R.id.action_homeFragment_to_redFragment2);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller=Navigation.findNavController(v);
                controller.navigate(R.id.action_homeFragment_to_greenFragment2);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller=Navigation.findNavController(v);
                controller.navigate(R.id.action_homeFragment_to_blueFragment2);

            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller=Navigation.findNavController(v);
                controller.navigate(R.id.action_homeFragment_to_secondActivity2);
            }
        });

        return v;
    }
}
