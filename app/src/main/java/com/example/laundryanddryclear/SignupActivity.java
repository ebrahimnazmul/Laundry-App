package com.example.laundryanddryclear;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class SignupActivity extends AppCompatActivity {

    ImageView backStartPageButton;
    AppCompatSpinner dropDownMenu;
    FrameLayout frameLay;
    TextView wellcomeText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        backStartPageButton=findViewById(R.id.backStartPageButton);
        dropDownMenu=findViewById(R.id.dropDownMenu);
        frameLay=findViewById(R.id.frameLay);
        wellcomeText=findViewById(R.id.wellcomeText);




        //adapter for spinner .eta kaj korbe login or signup page select korar jonno

        String [] sItem={"Login","Signup"};
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,sItem);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropDownMenu.setAdapter(adapter);




        backStartPageButton.setOnClickListener(v -> {
            Intent intent=new Intent(SignupActivity.this, StartActivity.class);
            startActivity(intent);

        });



        dropDownMenu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();

                if (selectedItem.equals("Signup")){
                    loadFragment(new FragmentSignup());
                    wellcomeText.setText("Let's go to Signup");
                }else if (selectedItem.equals("Login")){
                    loadFragment(new FragmentLogin());
                    wellcomeText.setText("Let's go to Login");

                }



            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                loadFragment(new FragmentLogin());
                wellcomeText.setText("Let's go to Login");

            }
        });




    }

    //==================oncreate methood end here

    //fragment load methood
    private void loadFragment(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLay,fragment);
        fragmentTransaction.commit();
    }


}