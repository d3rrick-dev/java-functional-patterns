package com.functional_patterns.rule_engine_v1;

import java.util.List;

public class Rules {
    private Rules() {}

    @SafeVarargs
    public static <T> RuleEngine<T> rules(Rule<T>... rules) {
        return new RuleEngine<>(List.of(rules));
    }
}
