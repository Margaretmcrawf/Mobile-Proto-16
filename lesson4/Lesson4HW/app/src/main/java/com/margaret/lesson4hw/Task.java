package com.margaret.lesson4hw;

/**
 *A task class. It includes a string of the thing you have to do.
 */
public class Task {
    private String text;

    public Task(String text) {
        this.text = text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
