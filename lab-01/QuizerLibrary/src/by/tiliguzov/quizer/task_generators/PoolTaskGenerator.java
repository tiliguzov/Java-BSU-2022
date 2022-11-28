package by.tiliguzov.quizer.task_generators;

import by.tiliguzov.quizer.Main;
import by.tiliguzov.quizer.tasks.Task;

import java.util.Collection;
import java.util.LinkedList;

public class PoolTaskGenerator implements TaskGenerator {
    /**
     * Конструктор с переменным числом аргументов
     *
     * @param allowDuplicate разрешить повторения
     * @param tasks          задания, которые в конструктор передаются через запятую
     */
    boolean allowDuplicate_;
    Task[] tasks_;
    public PoolTaskGenerator(
            boolean allowDuplicate,
            Task... tasks
    ) {
        allowDuplicate_ = allowDuplicate;
        tasks_ = tasks;
    }

    /**
     * Конструктор, который принимает коллекцию заданий
     *
     * @param allowDuplicate разрешить повторения
     * @param tasks          задания, которые передаются в конструктор в Collection (например, {@link LinkedList})
     */
    PoolTaskGenerator(
            boolean allowDuplicate,
            Collection<Task> tasks
    ) {
        allowDuplicate_ = allowDuplicate;
        tasks_ = tasks.toArray(tasks_);
    }

    /**
     * @return случайная задача из списка
     */
    public Task generate() {
        int index = (int)(Math.random() * tasks_.length);
        return tasks_[index];
    }
}