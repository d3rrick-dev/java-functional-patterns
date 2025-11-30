package com.functional_patterns.examples.consumers;

import com.functional_patterns.examples.model.Person;

import java.util.function.Consumer;

public class PersonActions {

    public static Consumer<Person> log() {
        return p -> System.out.println("LOG: " + p);
    }

    public static Consumer<Person> saveToDb() {
        return p -> System.out.println("SAVING TO DB: " + p.name());
    }

    public  static Consumer<Person> sendEmail(String email) {
        return _ -> System.out.println("SENDING EMAIL: " + email);
    }
}
