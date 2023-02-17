package com.yyp.design.pattern.interpreter;

import java.util.Map;

/**
 * >
 */
public class GreaterExpression implements Expression {
    /**
     * 监控key
     */
    private String key;

    /**
     * 监控key指定的临界值
     */
    private long value;

    public GreaterExpression(String strExpression) {
        // 用空白分隔符分割
        String[] elements = strExpression.trim().split("\\s+");
        if (elements.length != 3 || !elements[1].trim().equals(">")) {
            throw new RuntimeException("Expression is invalid: " + strExpression);
        }
        this.key = elements[0].trim();
        this.value = Long.parseLong(elements[2].trim());
    }

    public GreaterExpression(String key, long value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public boolean interpret(Map<String, Long> stats) {
        if(!stats.containsKey(key)){
            return false;
        }
        // 取到值用来替换key
        Long statsValue = stats.get(key);

        return statsValue > value;
    }
}
