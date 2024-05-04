package com.javarush.task.jdk13.task53.task5307.controller;

import com.javarush.task.jdk13.task53.task5307.view.View;

public class MainController {
    private View view;

    public MainController(View view) {
        this.view = view;
    }

    public View getView() {
        return view;
    }
}
