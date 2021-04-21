package com.example.wisestudent;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIService {

    @POST("/login")
    Call<User> login(@Query("student_id")String student_id,
                    @Query("password")String password);

}
