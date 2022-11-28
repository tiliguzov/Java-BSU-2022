package by.tiliguzov.quizer.tasks.math_tasks;

import by.tiliguzov.quizer.Result;

import static by.tiliguzov.quizer.Result.OK;
import static by.tiliguzov.quizer.Result.WRONG;

public abstract class AbstractMathTask implements MathTask{
    public String task_, result_;

    @Override
    public String getText() {
        return task_;
    }

    @Override
    public Result validate(String answer) {
        if (result_.equals(answer)) {
            return OK;
        } else {
            return WRONG;
        }
    }
}
