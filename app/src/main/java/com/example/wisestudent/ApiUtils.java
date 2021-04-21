package com.example.wisestudent;

public class ApiUtils {

    public static final String BASE_URL = "http://192.168.8.101:3000/";

    public static APIService getAPIService() {

        return RetrofitClint.getClient(BASE_URL).create(APIService.class);
    }

}
