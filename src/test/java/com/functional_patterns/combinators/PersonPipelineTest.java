package com.functional_patterns.combinators;

import com.functional_patterns.examples.combinators.PersonPipeline;
import com.functional_patterns.examples.model.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonPipelineTest {

    @Test
    void pipeline() {
        var p = new Person("Derrick", 27, "Nairobi");

        var result = PersonPipeline.start()
                .addStep(person -> person.withName(person.name().toUpperCase()))
                .addStep(person -> person.withCity("Embu"))
                .addStep(person -> person.withAge(person.age() + 1))
                .execute(p);

        assertEquals("DERRICK", result.name());
        assertEquals("Embu", result.city());
        assertEquals(28, result.age());
    }
}