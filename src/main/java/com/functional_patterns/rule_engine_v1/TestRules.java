package com.functional_patterns.rule_engine_v1;

import static com.functional_patterns.rule_engine_v1.Rules.rules;

public class TestRules {
    void main() {
        var p = new Person("Derrick", 30, "Nairobi");

        var rule = new RuleBuilder<Person>("Is Adult")
                .when(_ -> p.age() >= 18)
                .then(_ -> "Person is an adult")
                .priority(3)
                .build();

        var rule2 = new RuleBuilder<Person>("Is from Nairobi")
                .when(person -> person.city().equalsIgnoreCase("Nairobi"))
                .then(_ -> "Person lives in Nairobi")
                .priority(1)
                .build();

        var rule3 = new RuleBuilder<Person>("Name does not start with A")
                .not(person -> person.name().startsWith("A"))
                .then(_ -> "Person's does not start with A")
                .priority(4)
                .build();

        var rule4 = new RuleBuilder<Person>("Name starts with D")
                .when(person -> person.name().startsWith("D"))
                .or(person -> person.name().endsWith("k"))
                .and(person -> person.name().length() == 7)
                .then(_ -> "Person's name starts with D")
                .priority(2)
                .build();

        var rulesList  = rules(rule, rule2, rule3, rule4);
        var results = rulesList.run(p);
        System.out.println(results); // Output: [Person's does not start with A, Person is an adult, Person's name starts with D, Person lives in Nairobi]
    }
}
