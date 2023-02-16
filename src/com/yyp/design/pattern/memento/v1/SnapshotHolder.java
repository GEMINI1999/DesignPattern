package com.yyp.design.pattern.memento.v1;

import java.util.Stack;

public class SnapshotHolder {
    // 记录了所有版本的字符串
    private Stack<InputText> snapshots = new Stack<>();

    public InputText popSnapshot() {
        return snapshots.pop();
    }

    /**
     * 将上一次字符串放入快照中
     * @param inputText
     */
    public void pushSnapshot(InputText inputText) {
        InputText deepClonedInputText = new InputText();
        deepClonedInputText.setText(inputText.getText());
        snapshots.push(deepClonedInputText);
    }
}
