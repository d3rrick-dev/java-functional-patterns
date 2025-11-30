package com.functional_patterns.consumers;

import com.functional_patterns.examples.consumers.PersonActions;
import com.functional_patterns.examples.model.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonActionsTest {

    @Test
    void actionChainingWorksAsExpected() {
        var person = new Person("Derrick", 27, "Nairobi");

        var outPutStream = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outPutStream));

        var action = PersonActions.log()
                .andThen(PersonActions.saveToDb())
                .andThen(PersonActions.sendEmail("admin@test.com"));
        action.accept(person);

        var output = outPutStream.toString();

        assertTrue(output.contains("LOG"));
        assertTrue(output.contains("SAVING TO DB"));
        assertTrue(output.contains("SENDING EMAIL"));
    }
}