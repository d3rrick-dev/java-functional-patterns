package com.functional_patterns.rule_engine_v1;

import java.util.function.Function;
import java.util.function.Predicate;

public record Rule<T>(String name, Predicate<T> condition, Function<T, Object> action, int priority) {

    public boolean matches(T input) {
        return condition.test(input);
    }

    public Object execute(T input) {
        return action.apply(input);
    }
}
