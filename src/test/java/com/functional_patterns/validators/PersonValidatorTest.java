package com.functional_patterns.validators;

import com.functional_patterns.examples.model.Person;
import com.functional_patterns.examples.validators.PersonValidator;
import com.functional_patterns.examples.validators.ValidationResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonValidatorTest {

    @Test
    void invalidPerson() {
        var p = new Person("Derrick", 27, "Nairobi");
        assertEquals(ValidationResult.SUCCESS, PersonValidator.validate(p));
    }

    @Test
    void invalidAge() {
        var p = new Person("Derrick", -1, "Nairobi");
        assertEquals(ValidationResult.AGE_INVALID, PersonValidator.validate(p));
    }

    @Test
    void invalidCity() {
        var p = new Person("Derrick", 27, "");
        assertEquals(ValidationResult.CITY_EMPTY, PersonValidator.validate(p));
    }

    @Test
    void invalidName() {
        var p = new Person("", 27, "Nairobi");
        assertEquals(ValidationResult.NAME_EMPTY, PersonValidator.validate(p));
    }
}