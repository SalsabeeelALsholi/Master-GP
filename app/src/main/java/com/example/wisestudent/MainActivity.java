package com.example.wisestudent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    EditText student_id ;
    EditText password ;
    Button login ;
    private APIService mAPIService;
    SharedPreferences sharedpreferences ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        student_id = findViewById(R.id.studentid);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);


        mAPIService = ApiUtils.getAPIService();
        sharedpreferences = getSharedPreferences("login_status", Context.MODE_PRIVATE);

        if(sharedpreferences.getBoolean("login" , false)){
            Intent i = new Intent(MainActivity.this , HomePage.class);
            startActivity(i);
        }




        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id = student_id.getText().toString();
                String pwd = password.getText().toString();

                if(id.isEmpty() || pwd.isEmpty()){

                    Toast.makeText(MainActivity.this, "Check Your Number and Password", Toast.LENGTH_SHORT).show();
                }else{
                    login(id , pwd);
                }


            }
        });

    }

    public void login(String student_id , String password){
        SharedPreferences.Editor editor = sharedpreferences.edit();

        mAPIService.login(student_id, password).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()){
                    assert response.body() != null;
                    if(response.body().getResponse()){

                        editor.putBoolean("login", true);
                        editor.apply();

                        Intent i = new Intent(MainActivity.this , HomePage.class);
                        startActivity(i);
                    }else {
                        Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }



}