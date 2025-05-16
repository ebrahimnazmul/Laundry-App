package com.example.laundryanddryclear;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class WashingOrderActivity extends AppCompatActivity {

    TextView tShirt,dress,outerWear;

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

    }
    private void orderConfirm(){


        confirmButton.setOnClickListener(v -> {
              try {
                  int t_shirtQuantity=Integer.parseInt(tShirtQuantity.getText().toString());
                  int outerwearQuantity=Integer.parseInt(outerWearQuantity.getText().toString());
                  int dress_quantity=Integer.parseInt(dressQuantity.getText().toString());

              } catch (NumberFormatException e) {
                  e.printStackTrace();
              }

              String t_shirt=tShirt.getText().toString();
              String d_ress=dress.getText().toString();
              String outer_wear=outerWear.getText().toString();

              String title = titleText.getText().toString();

              


        });



    }


}