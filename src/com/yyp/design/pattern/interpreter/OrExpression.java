package com.yyp.design.pattern.interpreter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 或运算
 */
public class OrExpression implements Expression {
    /**
     * 此处是由&&构成的表达式（没有&&的表达式也算）
     */
    private List<Expression> expressions = new ArrayList<>();

    public OrExpression(String strOrExpression) {
        String[] andExpressions = strOrExpression.split("\\|\\|");
        for (String andExpr : andExpressions) {
            expressions.add(new AndExpression(andExpr));
        }
    }

    public OrExpression(List<Expression> expressions) {
        this.expressions.addAll(expressions);
    }

    @Override
    public boolean interpret(Map<String, Long> stats) {
        for (Expression expr : expressions) {
            if (expr.interpret(stats)) {
                return true;
            }
        }
        return false;
    }
}
