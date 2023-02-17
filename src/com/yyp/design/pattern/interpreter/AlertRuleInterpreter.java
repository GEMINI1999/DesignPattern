package com.yyp.design.pattern.interpreter;

import java.util.Map;

/**
 * 报警规则解释器
 */
public class AlertRuleInterpreter {
    private Expression expression;

    public AlertRuleInterpreter(String ruleExpression) {
        // 首先是||运算符
        this.expression = new OrExpression(ruleExpression);
    }

    public boolean interpret(Map<String, Long> stats) {
        return expression.interpret(stats);
    }
}
