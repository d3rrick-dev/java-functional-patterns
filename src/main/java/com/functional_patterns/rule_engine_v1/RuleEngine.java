package com.functional_patterns.rule_engine_v1;

import java.util.List;
import java.util.Objects;

public class RuleEngine<T> {

    private final List<Rule<T>> rules;

    public RuleEngine(List<Rule<T>> rules) {
        this.rules = rules.stream()
                .sorted((a,b) -> b.priority() - a.priority())
                .toList();
    }

    public List<Object> run(T input) {
        return rules.stream()
                .filter(rule -> rule.matches(input))
                .map(rule -> rule.execute(input))
                .filter(Objects::nonNull)
                .toList();
    }

}
