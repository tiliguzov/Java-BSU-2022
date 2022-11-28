package by.tiliguzov.quizer.task_generators.math_task_generators;

import by.tiliguzov.quizer.tasks.math_tasks.EquationMathTask;
import by.tiliguzov.quizer.tasks.math_tasks.ExpressionMathTask;
import by.tiliguzov.quizer.tasks.math_tasks.MathTask;

public class ExpressionTaskGenerator extends AbstractMathTaskGenerator {
    /**
     * @param minNumber              минимальное число
     * @param maxNumber              максимальное число
     * @param generateSum            разрешить генерацию с оператором +
     * @param generateDifference     разрешить генерацию с оператором -
     * @param generateMultiplication разрешить генерацию с оператором *
     * @param generateDivision       разрешить генерацию с оператором /
     */
    public ExpressionTaskGenerator(
            int minNumber,
            int maxNumber,
            boolean generateSum,
            boolean generateDifference,
            boolean generateMultiplication,
            boolean generateDivision
    ) {
        minNumber_ = minNumber;
        maxNumber_ = maxNumber;
        if (generateSum) {
            operators.append('+');
        }
        if (generateDifference) {
            operators.append('-');
        }
        if (generateMultiplication) {
            operators.append('*');
        }
        if(generateDivision) {
            operators.append('/');
        }
    }
    /**
     * return задание типа {@link ExpressionMathTask}
     *
     */
    @Override
    public ExpressionMathTask generate() {
        String[] info = generateExpression(TypeOfExpression.VALUE_OPERATOR_VALUE);
        return new ExpressionMathTask(info[0], info[1]);
    }
}