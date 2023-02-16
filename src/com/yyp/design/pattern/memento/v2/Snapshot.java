package com.yyp.design.pattern.memento.v2;

/**
 * 快照,备忘录模式的关键
 */
public class Snapshot {
    private String text;

    public Snapshot(String text) {
        this.text = text;
    }

    /**
     * 只提供读取方法，不提供写方法
     * @return
     */
    public String getText() {
        return text;
    }

}
