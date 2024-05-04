package com.javarush.task.jdk13.task53.task5307.services;

import com.javarush.task.jdk13.task53.task5307.Entity.Result;
import com.javarush.task.jdk13.task53.task5307.Exception.ApplicationException;
import com.javarush.task.jdk13.task53.task5307.repository.ResultCode;

public class Decode implements Function{
    @Override
    public Result execute(String[] parameters) {
        try
        {
            //TODO finish DECODE
        }catch (Exception e)
        {
            return new Result(ResultCode.ERROR,new ApplicationException("Decode operation finished with exception: ",e));
        }
        return new Result(ResultCode.OK);
    }
}
