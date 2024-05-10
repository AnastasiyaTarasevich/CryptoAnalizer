package org.example.CryptoAnalizer.controller;

import org.example.CryptoAnalizer.view.View;

public class MainController {
    private View view;

    public MainController(View view) {
        this.view = view;
    }

    public View getView() {

        return view;
    }
}
