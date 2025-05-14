package com.example.laundryanddryclear;

import static android.content.Context.MODE_PRIVATE;
import android.content.Context;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;

public class FragmentSignup extends Fragment {
    AppCompatButton signUpButton;
    TextInputEditText signupEmail,signupName,signupPassword;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        // XML ফাইলটি inflate করে return করতে হবে
        View view= inflater.inflate(R.layout.fragment_signup, container, false);

        signUpButton=view.findViewById(R.id.signUpButton);
        signupEmail=view.findViewById(R.id.signupEmail);
        signupName=view.findViewById(R.id.signupName);
        signupPassword=view.findViewById(R.id.signupPassword);


        signUpValidation();



        return view;
    }

    private  void signUpValidation(){

        signUpButton.setOnClickListener(v -> {

            String SIGNUPNAME=signupName.getText().toString().trim();
            String SIGNUPEMAIL=signupEmail.getText().toString().trim();
            String SIGNUPPASSWORD=signupPassword.getText().toString().trim();



            if (SIGNUPNAME.isEmpty()){
                signupName.setError("Name Must Required");
            }
            else if (SIGNUPNAME.length()<3){
                signupName.setError("Name must required 3 charecter");
            }
            if (SIGNUPEMAIL.isEmpty()){
                signupEmail.setError("Email Must Required");
            }

            else if (!Patterns.EMAIL_ADDRESS.matcher(SIGNUPEMAIL).matches()){
                signupEmail.setError("Need valid email ");
            }
            if (SIGNUPPASSWORD.isEmpty()){
                signupPassword.setError("Password must need");
            }
            else if (SIGNUPPASSWORD.length()<4){
                signupPassword.setError("password need minimul 4 character");
            }else {



                SharedPreferences sharedPreferences = requireContext().getSharedPreferences("pref",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name",SIGNUPNAME);
                editor.putString("email",SIGNUPEMAIL);
                editor.putString("password",SIGNUPPASSWORD);
                editor.apply();
                editor.apply();
                Toast.makeText(getContext(), "Signup Successful", Toast.LENGTH_SHORT).show();





            }



        });


    }


}
