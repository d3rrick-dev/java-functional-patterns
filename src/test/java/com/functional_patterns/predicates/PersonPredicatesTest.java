package com.functional_patterns.predicates;

import com.functional_patterns.examples.model.Person;
import com.functional_patterns.examples.predicates.PersonPredicates;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonPredicatesTest {

    @Test
    void testPredicates() {
        var p = new Person("Derrick", 27, "Nairobi");

        assertTrue(PersonPredicates.isAdult().test(p));
        assertTrue(PersonPredicates.nameStartsWith("D").test(p));
        assertTrue(PersonPredicates.livesIn("Nairobi").test(p));
    }
}