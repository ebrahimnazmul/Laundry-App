package com.example.laundryanddryclear;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.airbnb.lottie.LottieAnimationView;

public class StartActivity extends AppCompatActivity {

    TextView signUpButton;
    AppCompatButton goLoginPageButton;

    LottieAnimationView startAmination;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_start);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        startAmination=findViewById(R.id.startAmimation);


        //*********************************************************
        startAmination.setOnClickListener(v -> {
            Intent intent=new Intent(StartActivity.this, SignupActivity.class);
            startActivity(intent);

        });
        //*********************************************************



    }
}