package by.tiliguzov.quizer.task_generators;

import by.tiliguzov.quizer.tasks.Task;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class GroupTaskGenerator implements TaskGenerator {
    TaskGenerator[] generators_;

    /**
     * Конструктор с переменным числом аргументов
     *
     * @param generators генераторы, которые в конструктор передаются через запятую
     */
    public GroupTaskGenerator(TaskGenerator... generators) {
        generators_ = generators;
    }

    /**
     * Конструктор, который принимает коллекцию генераторов
     *
     * @param generators генераторы, которые передаются в конструктор в Collection (например, {@link ArrayList})
     */
    GroupTaskGenerator(Collection<TaskGenerator> generators) {
        generators_ = generators.toArray(generators_);
    }

    /**
     * @return результат метода generate() случайного генератора из списка.
     *         Если этот генератор выбросил исключение в методе generate(), выбирается другой.
     *         Если все генераторы выбрасывают исключение, то и тут выбрасывается исключение.
     */
    @Override
    public Task generate() {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (int i = 0; i < generators_.length; ++i) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        for (int i = 0; i < numbers.size(); ++i) {
//            try {
            return generators_[numbers.get(i)].generate();
//            } catch
        }
        return generators_[0].generate();
    }
}