package com.functional_patterns.examples.predicates;


import com.functional_patterns.examples.model.Person;

import java.util.function.Predicate;

public class PersonPredicates {
    public static Predicate<Person> isAdult() {
        return person -> person.age() >= 18;
    }

    public static Predicate<Person> nameStartsWith(String prefix) {
        return person -> person.name().startsWith(prefix);
    }

    public static Predicate<Person> livesIn(String city) {
        return person -> person.city().equalsIgnoreCase(city);
    }
}
