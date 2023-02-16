package com.yyp.design.pattern.memento.v1;

public class InputText {
    private StringBuilder text = new StringBuilder();

    public String getText() {
        return text.toString();
    }

    public void append(String input) {
        text.append(input);
    }

    /**
     * 违背封装原则
     * @param text
     */
    public void setText(String text) {
        this.text.replace(0, this.text.length(), text);
    }
}