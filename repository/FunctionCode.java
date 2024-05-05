package com.javarush.task.jdk13.task53.task5307.repository;

import com.javarush.task.jdk13.task53.task5307.services.*;

public enum FunctionCode {
    ENCODE(new Encode()) ,DECODE(new Decode()), BRUTE_FORCE(new BruteForce()),UNSUPPORTED_FUNCTION(new UnsupportedFunction()),EXIT(new Exit());
    private Function function;

    FunctionCode(Function function) {
        this.function = function;
    }

    public Function getFunction() {
        return function;
    }
}
