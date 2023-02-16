package com.yyp.design.pattern.memento.v2;

import java.util.Stack;

public class SnapshotHolder {
    // 记录了所有版本的字符串
    private Stack<Snapshot> snapshots = new Stack<>();

    public Snapshot popSnapshot() {
        return snapshots.pop();
    }

    /**
     * 将上一次字符串放入快照中
     * @param snapshot
     */
    public void pushSnapshot(Snapshot snapshot) {
        snapshots.push(snapshot);
    }
}
