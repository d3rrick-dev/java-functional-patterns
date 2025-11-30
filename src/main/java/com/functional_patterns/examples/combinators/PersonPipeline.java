package com.functional_patterns.examples.combinators;


import com.functional_patterns.examples.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class PersonPipeline {

    private final List<Function<Person, Person>> steps = new ArrayList<>();

    public static PersonPipeline start() {
        return new PersonPipeline();
    }

    public PersonPipeline addStep(Function<Person, Person> step) {
        steps.add(step);
        return this;
    }

    public Person execute(Person person) {
        Person result = person;
        for (var step : steps) {
            result = step.apply(result);
        }
        return result;
    }
}
