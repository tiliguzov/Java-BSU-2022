package by.tiliguzov.quizer;

import by.tiliguzov.quizer.task_generators.TaskGenerator;
import by.tiliguzov.quizer.tasks.Task;

/**
 * Class, который описывает один тест
 */
public class Quiz {
    TaskGenerator generator_;
    Task currentTask_;
    int taskCount_, correctAnswerCount, wrongAnswerCount, incorrectInputNumber, currentTaskCount;
    boolean repeatTask;
    /**
     * @param generator генератор заданий
     * @param taskCount количество заданий в тесте
     */
    public Quiz(TaskGenerator generator, int taskCount) {
        generator_ = generator;
        taskCount_ = taskCount;
    }

    /**
     * @return задание, повторный вызов вернет слелующее
     * @see Task
     */
    public Task nextTask() {
        if (!repeatTask) {
            currentTask_ = generator_.generate();
            ++currentTaskCount;
        } else {
            repeatTask = false;
        }
        return currentTask_;
    }

    /**
     * Предоставить ответ ученика. Если результат {@link Result#INCORRECT_INPUT}, то счетчик неправильных
     * ответов не увеличивается, а {@link #nextTask()} в следующий раз вернет тот же самый объект {@link Task}.
     */
    public Result provideAnswer(String answer) {
        Result result = currentTask_.validate(answer);
        if (result == Result.OK) {
            ++correctAnswerCount;
        } else if (result == Result.WRONG) {
            ++wrongAnswerCount;
        } else {
            repeatTask = true;
            ++incorrectInputNumber;
        }
        return result;
    }

    /**
     * @return завершен ли тест
     */
    public boolean isFinished() {
        return currentTaskCount == taskCount_;
    }

    /**
     * @return количество правильных ответов
     */
    int getCorrectAnswerNumber() {
        return correctAnswerCount;
    }

    /**
     * @return количество неправильных ответов
     */
    int getWrongAnswerNumber() {
        return wrongAnswerCount;
    }

    /**
     * @return количество раз, когда был предоставлен неправильный ввод
     */
    int getIncorrectInputNumber() {
        return incorrectInputNumber;
    }

    /**
     * @return оценка, которая является отношением количества правильных ответов к количеству всех вопросов.
     *         Оценка выставляется только в конце!
     */
    public double getMark() {
        if (isFinished()) {
            return (double)correctAnswerCount / taskCount_;
        } else {
            return 0;
        }
    }
}