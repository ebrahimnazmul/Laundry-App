package com.example.laundryanddryclear;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class WashingOrderActivity extends AppCompatActivity {

    TextView tShirt,dress,outerWear;
    int tCount=0;
    int dCount=0;
    int wCount=0;

    public static String itemType="";
    TextView titleText;
    ImageView tShirtPlus,tShirtMinus,outerWearPlus,outerWearMinus,dressPlus,dressMinus;
    TextView tShirtQuantity,outerWearQuantity,dressQuantity;

    AppCompatButton confirmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_washing_order);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        titleText=findViewById(R.id.titleText);


        titleText.setText(itemType);


        tShirtPlus=findViewById(R.id.tShirtPlus);
        tShirtMinus=findViewById(R.id.tShirtMinus);
        outerWearPlus=findViewById(R.id.outerWearPlus);
        outerWearMinus=findViewById(R.id.outerWearMinus);
        dressPlus=findViewById(R.id.dressPlus);
        dressMinus=findViewById(R.id.dressMinus);

        tShirtQuantity=findViewById(R.id.tShirtQuantity);
        outerWearQuantity=findViewById(R.id.outerWearQuantity);
        dressQuantity=findViewById(R.id.dressQuantity);

        confirmButton=findViewById(R.id.confirmButton);

        tShirt=findViewById(R.id.tShirt);
        dress=findViewById(R.id.dress);
        outerWear=findViewById(R.id.outerWear);



        //********************************
        tShirtPlus.setOnClickListener(v -> {
            tCount++;

            tShirtQuantity.setText(String.valueOf(tCount));

        });
        tShirtMinus.setOnClickListener(v -> {

            tCount--;
            tShirtQuantity.setText(String.valueOf(tCount));

            if (tCount<1){

                tCount=0;
                tShirtQuantity.setText(String.valueOf(tCount));
            }

        });

        //********************************************

        dressPlus.setOnClickListener(v -> {
            dCount++;

            dressQuantity.setText(String.valueOf(dCount));

        });
        dressMinus.setOnClickListener(v -> {

            dCount--;
            dressQuantity.setText(String.valueOf(dCount));

            if (dCount<1){

                tCount=0;
               dressQuantity.setText(String.valueOf(dCount));
            }

        });

        //********************************************
        outerWearPlus.setOnClickListener(v -> {
            wCount++;

            outerWearQuantity.setText(String.valueOf(wCount));

        });
        outerWearMinus.setOnClickListener(v -> {

            wCount--;
            dressQuantity.setText(String.valueOf(wCount));

            if (wCount<1){

                wCount=0;
                outerWearQuantity.setText(String.valueOf(wCount));
            }

        });

        orderConfirm();

    }


    private void orderConfirm(){

        confirmButton.setOnClickListener(v -> {

                  int t_shirtQuantity=Integer.parseInt(tShirtQuantity.getText().toString());
                  int outerwearQuantity=Integer.parseInt(outerWearQuantity.getText().toString());
                  int dress_quantity=Integer.parseInt(dressQuantity.getText().toString());


              String t_shirt=tShirt.getText().toString();
              String d_ress=dress.getText().toString();
              String outer_wear=outerWear.getText().toString();

              String category = titleText.getText().toString();



              String URL="http://192.168.0.101/apps/laundryAppOrderConfirmData.php?category="+category+
                      "&ts="+t_shirt+"&dress="+d_ress+
                      "&outerW="+outer_wear+"&tq="+t_shirtQuantity+
                      "&outerwearQ="+outerwearQuantity+"&dq="+
                      dress_quantity;

            StringRequest request = new StringRequest(Request.Method.GET, URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Toast.makeText(getApplicationContext(), "Server Response: " + response, Toast.LENGTH_LONG).show();
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(getApplicationContext(), "Error: " + error.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });

            RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
            queue.add(request);


        });



    }


}