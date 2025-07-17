package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
public class JsonToObject {


    private final Gson gson = new Gson();
    public Person ConvertToObject(String jsonOutput)
    {
        return gson.fromJson(jsonOutput, Person.class);
    }
}
