package com.yyp.design.pattern.memento.v2;

public class InputText {
    private StringBuilder text = new StringBuilder();

    public String getText(){
        return text.toString();
    }

    public void append(String input){
        text.append(input);
    }

    /**
     * 恢复快照
     * @param snapshot
     */
    public void restoreSnapshot(Snapshot snapshot){
        this.text.replace(0, this.text.length(), snapshot.getText());
    }

    public Snapshot createSnapshot(){
        return new Snapshot(text.toString());
    }

}
