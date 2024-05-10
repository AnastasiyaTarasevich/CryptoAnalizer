package com.javarush.task.jdk13.task53.task5307.services;

import com.javarush.task.jdk13.task53.task5307.Entity.Result;
import com.javarush.task.jdk13.task53.task5307.repository.ResultCode;

public class UnsupportedFunction implements Function{
    @Override
    public Result execute(String[] parameters) {
        //TODO finish Unsup method
        return  new Result(ResultCode.OK,"Такой функции нет");
    }
}
