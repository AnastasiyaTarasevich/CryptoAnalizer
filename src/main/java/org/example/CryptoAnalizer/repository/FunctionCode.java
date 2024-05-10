package org.example.CryptoAnalizer.repository;

import org.example.CryptoAnalizer.services.*;
import org.example.CryptoAnalizer.services.*;

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
