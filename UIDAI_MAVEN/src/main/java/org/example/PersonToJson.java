package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
public class PersonToJson {

    Gson gson = new Gson();


    public PersonToJson() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }
    public String convertToJson(Person person){
        return gson.toJson(person);
    }
}
