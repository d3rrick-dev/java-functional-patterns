package com.functional_patterns.examples.validators;


import com.functional_patterns.examples.model.Person;

import java.util.function.Function;

public interface PersonValidator extends Function<Person, ValidationResult> {

    static PersonValidator nameIsNotEmpty() {
        return person -> person.name().isBlank()
                ? ValidationResult.NAME_EMPTY
                : ValidationResult.SUCCESS;
    }

    static PersonValidator ageIsValid() {
        return person -> person.age() < 0
                ? ValidationResult.AGE_INVALID
                : ValidationResult.SUCCESS;
    }

    static PersonValidator cityIsNotEmpty() {
        return person -> person.city().isEmpty()
                ? ValidationResult.CITY_EMPTY
                : ValidationResult.SUCCESS;
    }

    default PersonValidator and(PersonValidator other) {
        return person -> {
            var result = this.apply(person);
            return result == ValidationResult.SUCCESS
                    ? other.apply(person)
                    : result;
        };
    }

    static ValidationResult validate(Person person) {
        return nameIsNotEmpty()
                .and(ageIsValid())
                .and(cityIsNotEmpty())
                .apply(person);
    }
}



