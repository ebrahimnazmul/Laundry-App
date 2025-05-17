package com.example.laundryanddryclear;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class OrderActivity extends AppCompatActivity {

    AppCompatButton datePickerButton,confirmButton;
    TextView orderDateText,itemText,titleText1;
    public static String itemType="";
    AppCompatSpinner dropDownMenu;
    ImageView productImage,quantityPlus,quantityMinus;
    TextView quantityText,moneyText;
    int count;
    int t_shirt_prize,bottom_prize, dress_prize,outer_wear_prize,jeans_prize;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_oreder);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        //variable finder function
        variableFinder();
        //dropDownMenuSelector eta kaj kore user item select korbe tokhon

        itemText.setText(itemType);

        String [] sItem={"TShirt","OuterWear","Jeans","Bottom","Dress"};
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,sItem);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropDownMenu.setAdapter(adapter);

        dropDownMenuSelector();
        quantityIncrementDecrement();



        datePickerButton.setOnClickListener(view -> {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                OrderActivity.this,
                (DatePicker view1, int selectedYear, int selectedMonth, int selectedDay) -> {
                    String date = selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear;
                    orderDateText.setText(date);
                },
                year, month, day
        );

        // Optional: restrict past dates
        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());

        datePickerDialog.show();
    });





    }

    private void variableFinder(){
        datePickerButton=findViewById(R.id.datePickerButton);
        orderDateText=findViewById(R.id.orderDateText);
        itemText=findViewById(R.id.itemText);
        dropDownMenu=findViewById(R.id.dropDownMenu);
        titleText1=findViewById(R.id.titleText1);
        productImage=findViewById(R.id.productImage);
        quantityPlus=findViewById(R.id.quantityPlus);
        quantityMinus=findViewById(R.id.quantityMinus);
        quantityText=findViewById(R.id.quantityText);
        moneyText=findViewById(R.id.moneyText);
        confirmButton=findViewById(R.id.confirmButton);


    }



    private void dropDownMenuSelector(){
        dropDownMenu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();


                if ( selectedItem.equalsIgnoreCase("TShirt")){
                    titleText1.setText(selectedItem);
                    productImage.setImageResource(R.drawable.t_shirt);

                } else if (selectedItem.equalsIgnoreCase("OuterWear")) {
                    titleText1.setText(selectedItem);
                    productImage.setImageResource(R.drawable.outerwear);
                } else if (selectedItem.equalsIgnoreCase("Jeans")) {

                    titleText1.setText(selectedItem);
                    productImage.setImageResource(R.drawable.outerwear);
                } else if (selectedItem.equalsIgnoreCase("Bottom")) {
                    titleText1.setText(selectedItem);
                    productImage.setImageResource(R.drawable.outerwear);

                } else if (selectedItem.equalsIgnoreCase("Dress")) {
                    titleText1.setText(selectedItem);
                    productImage.setImageResource(R.drawable.outerwear);
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }





    private void quantityIncrementDecrement() {

        quantityPlus.setOnClickListener(v -> {

            count = count + 1;
            quantityText.setText(String.valueOf(count));

            // Service type check (washing, drying, ironing)
            if (itemText.getText().toString().toLowerCase().contains("washing")) {
                t_shirt_prize = 50;
                jeans_prize = 40;
                bottom_prize = 30;
                outer_wear_prize = 100;
                dress_prize = 60;
            } else if (itemText.getText().toString().toLowerCase().contains("drying")) {
                t_shirt_prize = 30;
                jeans_prize = 40;
                bottom_prize = 20;
                outer_wear_prize = 80;
                dress_prize = 50;
            } else if (itemText.getText().toString().toLowerCase().contains("ironing")) {
                t_shirt_prize = 15;
                jeans_prize = 30;
                bottom_prize = 10;
                outer_wear_prize = 50;
                dress_prize = 30;
            }

            // Total calculation
            int total = 0;

            if (titleText1.getText().toString().contains("TShirt")) {
                total = t_shirt_prize * count;
            } else if (titleText1.getText().toString().contains("OuterWear")) {
                total = outer_wear_prize * count;
            } else if (titleText1.getText().toString().contains("Jeans")) {
                total = jeans_prize * count;
            } else if (titleText1.getText().toString().contains("Bottom")) {
                total = bottom_prize * count;
            } else if (titleText1.getText().toString().contains("Dress")) {
                total = dress_prize * count;
            }

            // Show total price
            moneyText.setText(String.valueOf(total)+" taka");
        });

        //*******************************************
        quantityMinus.setOnClickListener(v -> {

            count = count - 1;
            quantityText.setText(String.valueOf(count));

            // Service type check (washing, drying, ironing)
            if (itemText.getText().toString().toLowerCase().contains("washing")) {
                t_shirt_prize = 50;
                jeans_prize = 40;
                bottom_prize = 30;
                outer_wear_prize = 100;
                dress_prize = 60;
            } else if (itemText.getText().toString().toLowerCase().contains("drying")) {
                t_shirt_prize = 30;
                jeans_prize = 40;
                bottom_prize = 20;
                outer_wear_prize = 80;
                dress_prize = 50;
            } else if (itemText.getText().toString().toLowerCase().contains("ironing")) {
                t_shirt_prize = 15;
                jeans_prize = 30;
                bottom_prize = 10;
                outer_wear_prize = 50;
                dress_prize = 30;
            }

            // Total calculation
            int total = 0;
            if (titleText1.getText().toString().contains("TShirt")) {
                total = t_shirt_prize * count;
            } else if (titleText1.getText().toString().contains("OuterWear")) {
                total = outer_wear_prize * count;
            } else if (titleText1.getText().toString().contains("Jeans")) {
                total = jeans_prize * count;
            } else if (titleText1.getText().toString().contains("Bottom")) {
                total = bottom_prize * count;
            } else if (titleText1.getText().toString().contains("Dress")) {
                total = dress_prize * count;
            }

            // Show total price
            moneyText.setText(String.valueOf(total)+" taka");
        });
    }




}