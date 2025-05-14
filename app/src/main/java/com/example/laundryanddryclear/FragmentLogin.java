package com.example.laundryanddryclear;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;


public class FragmentLogin extends Fragment {

    TextInputEditText loginEmail,loginPassword;
    AppCompatButton loginButton;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);


        loginEmail=view.findViewById(R.id.loginEmail);
        loginPassword=view.findViewById(R.id.loginPassword);
        loginButton=view.findViewById(R.id.loginButton);

        loginValidation();

        return view;
    }



    private void loginValidation(){

        loginButton.setOnClickListener(v -> {

            String LOGINEMAIL=loginEmail.getText().toString().trim();
            String LOGINPASSWORD=loginPassword.getText().toString().trim();


            if (LOGINEMAIL.isEmpty()){
                loginEmail.setError("Enter password");
            } else if (!Patterns.EMAIL_ADDRESS.matcher(LOGINEMAIL).matches()) {
                loginEmail.setError("enter valid email");

            }if (LOGINPASSWORD.isEmpty()){
                loginPassword.setError("Password required");

            } else if (LOGINPASSWORD.length()<3) {
                loginPassword.setError("length must 3 character");

            } else {

                SharedPreferences sharedPreferences = requireContext().getSharedPreferences("pref", Context.MODE_PRIVATE);

                String sEmail=sharedPreferences.getString("email",null);
                String sPassword=sharedPreferences.getString("password",null);


                if (LOGINEMAIL.equals(sEmail) && LOGINPASSWORD.equals(sPassword) ){
                    Intent intent=new Intent(getContext(), MainActivity.class);
                    startActivity(intent);

                }else {
                    Toast.makeText(getContext(), "Login Filed", Toast.LENGTH_SHORT).show();
                }

            }


        });



    }





}