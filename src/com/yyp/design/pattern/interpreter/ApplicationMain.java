package com.yyp.design.pattern.interpreter;

import java.util.HashMap;
import java.util.Map;

public class ApplicationMain {
    public static void main(String[] args) {
        String rule = "key1 > 100 && key2 < 30 || key3 < 100 || key4 == 88";
        // 解析规则，构建署树
        AlertRuleInterpreter interpreter = new AlertRuleInterpreter(rule);
        Map<String, Long> stats = new HashMap<>();
        stats.put("key1", 101l);
        stats.put("key3", 121l);
        stats.put("key4", 89l);

        // 实际上的计算过程类似与树的遍历
        boolean alert = interpreter.interpret(stats);
        System.out.println(alert);
    }
}
