package by.tiliguzov.quizer.task_generators.math_task_generators;

import by.tiliguzov.quizer.tasks.math_tasks.MathTask;

public abstract class AbstractMathTaskGenerator implements MathTaskGenerator {
    public int minNumber_, maxNumber_;
    public StringBuilder operators = new StringBuilder("");

    public int getMinNumber() {
        return minNumber_;
    }

    public int getMaxNumber() {
        return maxNumber_;
    }

    private char getRandomOperator() {
        int num = (int)(Math.random() * (operators.length()));
        return operators.charAt(num);
    }

    static int solutionOfExpression(int num1, char operator, int num2) {
        int result = 0;
        switch (operator) {
            case '+': {
                result = num1 + num2;
                break;
            }
            case '-': {
                result = num1 - num2;
                break;
            }
            case '*': {
                result = num1 * num2;
                break;
            }
            case '/': {
                result = num1 / num2;
                break;
            }
        }
        return result;
    }

    public String[] generateExpression(TypeOfExpression type) {
        int num1 = getMinNumber() + (int)(Math.random() * getDiffNumber());
        int num2 = getMinNumber() + (int)(Math.random() * getDiffNumber());
        char operator = getRandomOperator();
        int num3 = solutionOfExpression(num1, operator, num2);
        switch (type) {
            case X_OPERATOR_VALUE: {
                return new String[]{'x' + String.valueOf(operator) + num2 + '=' + num3, String.valueOf(num1)};
            }
            case VALUE_OPERATOR_X: {
                return new String[]{num1 + String.valueOf(operator) + "x=" + num3, String.valueOf(num2)};
            } 
            case VALUE_OPERATOR_VALUE: {
                return new String[]{num1 + String.valueOf(operator) + num2 + "=?", String.valueOf(num3)};
            }
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
    }
}
