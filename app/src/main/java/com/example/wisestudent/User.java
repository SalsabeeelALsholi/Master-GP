package com.example.wisestudent;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("response")
    private Boolean response;

    public Boolean getResponse() {
        return response;
    }

    public void setResponse(Boolean response) {
        this.response = response;
    }
}
