package org.example.CryptoAnalizer.services;


import org.example.CryptoAnalizer.Entity.Result;
import org.example.CryptoAnalizer.repository.ResultCode;

public class UnsupportedFunction implements Function{
    @Override
    public Result execute(String[] parameters) {
        //TODO finish Unsup method
        return  new Result(ResultCode.OK,"Такой функции нет");
    }
}
