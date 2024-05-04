package com.javarush.task.jdk13.task53.task5307.view;

import com.javarush.task.jdk13.task53.task5307.Entity.Result;

public interface View {
    String [] getParameters();
    void printResults(Result result);
}
