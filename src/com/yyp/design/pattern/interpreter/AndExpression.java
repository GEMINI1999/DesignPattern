package com.yyp.design.pattern.interpreter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 与运算
 */
public class AndExpression implements Expression {
    /**
     * 此处是表达式的最小单元，即使用>，<，==构成的表达式
     */
    private List<Expression> expressions = new ArrayList<>();

    public AndExpression(String strAndExpression) {
        // 使用&&分割，没有&&字符串即原表达式字符串
        String[] strExpressions = strAndExpression.split("&&");
        for (String strExpr : strExpressions) {
            if (strExpr.contains(">")) {
                expressions.add(new GreaterExpression(strExpr));
            } else if (strExpr.contains("<")) {
                expressions.add(new LessExpression(strExpr));
            } else if (strExpr.contains("==")) {
                expressions.add(new EqualExpression(strExpr));
            } else {
                throw new RuntimeException("Expression is invalid: " + strAndExpression);
            }
        }
    }

    public AndExpression(List<Expression> expressions) {
        this.expressions.addAll(expressions);
    }

    @Override
    public boolean interpret(Map<String, Long> stats) {
        for (Expression expr : expressions) {
            if (!expr.interpret(stats)) {
                return false;
            }
        }
        return true;
    }
}
