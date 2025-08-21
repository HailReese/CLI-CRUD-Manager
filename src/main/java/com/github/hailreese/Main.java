package com.github.hailreese;

import com.github.hailreese.controller.WriterController;
import com.github.hailreese.repository.classes.GsonWriterRepositoryImpl;
import com.github.hailreese.view.MainView;
import com.github.hailreese.view.WriterView;

public class Main {
    public static void main(String[] args) {
        MainView mainView = new MainView();
        mainView.showMainMenu();
    }
}