package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycler_view);
        int image[]={R.drawable.alpha,R.drawable.beta,R.drawable.cupcake,R.drawable.donut
                     ,R.drawable.eclair,R.drawable.froyo,R.drawable.gingerbread,R.drawable.honeycomb,
                      R.drawable.icecreamsandwich,R.drawable.jellybean,R.drawable.kitkat,R.drawable.lollipop,
                      R.drawable.marshmallow,R.drawable.nougat
                      ,R.drawable.oreo,R.drawable.pie,R.drawable.q,R.drawable.r};
        String data[]={"Alpha","Beta","Cupcake","Donut","Eclair","Froyo","Gingerbread","Honeycomb",
                       "icecreamsandwich","jellybean","kitkat","Lollipop","Marshmallow","nouget",
                       "oreo","pie","androidx-Q", "androidx-R"};
        Myadapter myadapter=new Myadapter(this,image,data);
        recyclerView.setAdapter(myadapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}