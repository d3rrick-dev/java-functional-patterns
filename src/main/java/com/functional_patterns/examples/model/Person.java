package com.functional_patterns.examples.model;

public record Person (String name, int age, String city) {

    public Person withName(String name) {
        return new Person(name, this.age, this.city);
    }
    public Person withAge(int newAge) {
        return new Person(this.name, newAge, this.city);
    }

    public Person withCity(String newCity) {
        return new Person(this.name, this.age, newCity);
    }
}
