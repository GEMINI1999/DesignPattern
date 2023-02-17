package com.yyp.design.pattern.interpreter;

import java.util.Map;

/**
 * 表达式最小单元
 */
public interface Expression {
    boolean interpret(Map<String, Long> stats);
}
