package com.javarush.task.jdk13.task53.task5307.repository;

import com.javarush.task.jdk13.task53.task5307.services.Decode;
import com.javarush.task.jdk13.task53.task5307.services.Encode;
import com.javarush.task.jdk13.task53.task5307.services.Function;
import com.javarush.task.jdk13.task53.task5307.services.UnsupportedFunction;

public enum FunctionCode {
    ENCODE(new Encode()) ,DECODE(new Decode()), UNSUPPORTED_FUNCTION(new UnsupportedFunction());
    private Function function;

    FunctionCode(Function function) {
        this.function = function;
    }

    public Function getFunction() {
        return function;
    }
}
