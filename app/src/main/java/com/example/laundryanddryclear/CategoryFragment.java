package com.example.laundryanddryclear;

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

        Adapter adapter=new Adapter();
        gridView.setAdapter(adapter);

        serviceMap=new HashMap<>();
        serviceMap.put("title","Washing / Cleaning ");
        serviceMap.put("image","https://media.istockphoto.com/id/1134696879/photo/laundry-room-with-a-washing-machine.jpg?s=612x612&w=0&k=20&c=uYPFAjM1JaIm3-PW6F-4hjttjEDVSKAiDte1O1VzL6M=");
        servieList.add(serviceMap);

        serviceMap=new HashMap<>();
        serviceMap.put("title","Drying");
        serviceMap.put("image", "https://media.istockphoto.com/id/1307208156/photo/clean-laundry-hanging-on-drying-rack-indoors.jpg?s=612x612&w=0&k=20&c=nRM5WB3bZxTzNxkLFehavTZzjUPxmPSWf4oOINt9doA=");
        servieList.add(serviceMap);

        serviceMap=new HashMap<>();
        serviceMap.put("title","Ironing / Pressing ");
        serviceMap.put("image","https://media.istockphoto.com/id/641713422/photo/ironing-clothes-on-ironing-board.jpg?s=612x612&w=0&k=20&c=LFM1wIUHqYornAL1q4lfpptqy1QPqoOSE0xtXAwb5DA=");
        servieList.add(serviceMap);

        serviceMap=new HashMap<>();
        serviceMap.put("title","Dry Cleaning");
        serviceMap.put("image","https://cdn.pixabay.com/photo/2014/02/17/13/34/cleaning-268126_640.jpg");
        servieList.add(serviceMap);


        serviceMap=new HashMap<>();
        serviceMap.put("title","    Clothing Alteration / Repair");
        serviceMap.put("image","https://www.realsimple.com/thmb/NtcdnrtZjaNabQdKKc5Ah5VW-ng=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/tailoring-supplies-dc4f24993a6d4c6bbb647caf78f58a11.jpg");
        servieList.add(serviceMap);

        serviceMap=new HashMap<>();
        serviceMap.put("title","    Clothing Alteration / Repair");
        serviceMap.put("image","https://www.realsimple.com/thmb/NtcdnrtZjaNabQdKKc5Ah5VW-ng=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/tailoring-supplies-dc4f24993a6d4c6bbb647caf78f58a11.jpg");
        servieList.add(serviceMap);


        serviceMap=new HashMap<>();
        serviceMap.put("title","    Clothing Alteration / Repair");
        serviceMap.put("image","https://www.realsimple.com/thmb/NtcdnrtZjaNabQdKKc5Ah5VW-ng=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/tailoring-supplies-dc4f24993a6d4c6bbb647caf78f58a11.jpg");
        servieList.add(serviceMap);


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

            textView.setText(""+title);

            Picasso.get()
                    .load(image)
                    .into(imageView);

            return view;
        }
    }



}