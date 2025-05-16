package com.example.laundryanddryclear;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class CategoryFragment extends Fragment {

    GridView gridView;

    ArrayList<HashMap<String,String>> servieList=new ArrayList<>();

    HashMap<String,String> serviceMap;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

     View view= inflater.inflate(R.layout.fragment_category, container, false);
       gridView =view.findViewById(R.id.grigView);



        serviceMap=new HashMap<>();
        serviceMap.put("itemType","washing");
        serviceMap.put("title","Washing / Cleaning ");
        serviceMap.put("image","http://192.168.0.101/imageForLaundryApp/washing.jpg");
        servieList.add(serviceMap);

        serviceMap=new HashMap<>();
        serviceMap.put("itemType","drying");
        serviceMap.put("title","Drying");
        serviceMap.put("image", "http://192.168.0.101/imageForLaundryApp/drying.jpg");
        servieList.add(serviceMap);

        serviceMap=new HashMap<>();
        serviceMap.put("itemType","ironing");
        serviceMap.put("title","Ironing / Pressing ");
        serviceMap.put("image","http://192.168.0.101/imageForLaundryApp/ironing.jpg");
        servieList.add(serviceMap);

        serviceMap=new HashMap<>();
        serviceMap.put("itemType","cleaning");
        serviceMap.put("title","Dry Cleaning");
        serviceMap.put("image","http://192.168.0.101/imageForLaundryApp/cleaning.jpg");
        servieList.add(serviceMap);


        Adapter adapter=new Adapter();
        gridView.setAdapter(adapter);

        return view;


    }
    public class Adapter extends BaseAdapter{

        @Override
        public int getCount() {
            return servieList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view= LayoutInflater.from(getContext()).inflate(R.layout.grid_view_item, parent, false);

            ImageView imageView=view.findViewById(R.id.image);
            TextView textView=view.findViewById(R.id.titile);

            HashMap<String,String>hashMap=servieList.get(position);

            String image=hashMap.get("image");
            String title=hashMap.get("title");
            String itemType=hashMap.get("itemType");

            textView.setText(""+title);

            Picasso.get()
                    .load(image)
                    .into(imageView);




            imageView.setOnClickListener(v -> {
                if (itemType.contains("washing")){

                   WashingOrderActivity.itemType=itemType;
                    Intent intent = new Intent(getContext(),WashingOrderActivity.class);
                    startActivity(intent);

                } else if (itemType.contains("drying")) {
                    DryingOrderActivity.itemType = itemType;
                    Intent intent = new Intent(getContext(), DryingOrderActivity.class);
                    startActivity(intent);
                }else if (itemType.contains("ironing")) {


                    IroningOrderActivity.itemType=itemType;
                    Intent intent = new Intent(getContext(),IroningOrderActivity.class);
                    startActivity(intent);
                }


            });


            return view;
        }
    }



}