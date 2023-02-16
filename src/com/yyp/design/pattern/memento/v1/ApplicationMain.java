package com.yyp.design.pattern.memento.v1;

import java.util.Scanner;

public class ApplicationMain {
    public static void main(String[] args) {
        InputText inputText = new InputText();
        SnapshotHolder snapshotsHolder = new SnapshotHolder();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.next();
            if (input.equals(":list")) {
                System.out.println(inputText.getText());
            } else if (input.equals(":undo")) {
                // 获取上一次版本的快照
                InputText snapshot = snapshotsHolder.popSnapshot();
                inputText.setText(snapshot.getText());
            } else {
                // 将上一次字符串放入快照中
                snapshotsHolder.pushSnapshot(inputText);
                // 组建最新的字符串
                inputText.append(input);
            }
        }
    }
}
