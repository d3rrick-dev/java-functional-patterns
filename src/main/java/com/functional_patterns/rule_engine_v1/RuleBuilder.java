package com.functional_patterns.rule_engine_v1;

import java.util.function.Function;
import java.util.function.Predicate;

public class RuleBuilder<T> {
    private final String name;
    private Predicate<T> predicate = _ -> true;
    private Function<T, Object> action = _ -> null;
    private int priority = 1;

    public RuleBuilder(String name) {
        this.name = name;
    }

    public RuleBuilder<T> when(Predicate<T> p) {
        this.predicate = this.predicate.and(p);
        return this;
    }

    public RuleBuilder<T> and(Predicate<T> p) {
        this.predicate = this.predicate.and(p);
        return this;
    }

    public RuleBuilder<T> or(Predicate<T> p) {
        this.predicate = this.predicate.or(p);
        return this;
    }

    public RuleBuilder<T> not(Predicate<T> p) {
        this.predicate = this.predicate.and(p.negate());
        return this;
    }

    public RuleBuilder<T> priority(int level) {
        this.priority = level;
        return this;
    }

    public RuleBuilder<T> then(Function<T, Object> action) {
        this.action = action;
        return this;
    }

    public Rule<T> build() {
        return new Rule<>(name, predicate, action, priority);
    }

}
