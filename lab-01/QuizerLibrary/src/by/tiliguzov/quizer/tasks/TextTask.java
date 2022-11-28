package by.tiliguzov.quizer.tasks;

import by.tiliguzov.quizer.Result;
import by.tiliguzov.quizer.task_generators.PoolTaskGenerator;

import static by.tiliguzov.quizer.Result.OK;
import static by.tiliguzov.quizer.Result.WRONG;

///**
// * Задание с заранее заготовленным текстом.
// * Можно использовать {@link PoolTaskGenerator}, чтобы задавать задания такого типа.
// */
public class TextTask implements Task {
    private String task_, result_;
    /**
     * @param text   текст задания
     * @param answer ответ на задание
     */
    public TextTask(
            String text,
            String answer
    ) {
        task_ = text;
        result_ = answer;
    }

    @Override
    public String getText() {
        return task_;
    }

    @Override
    public Result validate(String answer) {
        if (answer.equals(result_)) {
            return OK;
        } else {
            return WRONG;
        }
    }
}