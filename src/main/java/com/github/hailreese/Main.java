package com.github.hailreese;

import com.github.hailreese.repository.classes.GsonWriterRepositoryImpl;

public class Main {
    public static void main(String[] args) {
        var test = new GsonWriterRepositoryImpl();
        test.getById(1L);
    }
}