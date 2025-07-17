package org.example;


import java.util.*;
public class Main {
    public static void main(String[] args)
    {

        Person person = new Person();
        person.setName("Litesh Kumar");
        person.setAge(23);
        person.setBalance(400.0);
        person.setInterest(Arrays.asList("Cricket, games, coding, bathing"));

        PersonToJson convertor = new PersonToJson();



        String jsonOutput = convertor.convertToJson(person);
        System.out.println(jsonOutput);
    }

}