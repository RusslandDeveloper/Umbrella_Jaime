package com.example.umbrella_jaime.View;

public interface ViewContract {





    // Get BaseURL
    String getBaseURL();


    void fillData(  String name, Double temperature);

    void showError(String errorMessage);

}
