package by.tiliguzov.quizer;

import by.tiliguzov.quizer.Quiz;
import by.tiliguzov.quizer.task_generators.GroupTaskGenerator;
import by.tiliguzov.quizer.task_generators.PoolTaskGenerator;
import by.tiliguzov.quizer.task_generators.math_task_generators.EquationTaskGenerator;
import by.tiliguzov.quizer.task_generators.math_task_generators.ExpressionTaskGenerator;
import by.tiliguzov.quizer.tasks.Task;
import by.tiliguzov.quizer.tasks.TextTask;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    /**
     * @return тесты в {@link Map}, где
     * ключ     - название теста {@link String}
     * значение - сам тест       {@link Quiz}
     */
    static Map<String, Quiz> getQuizMap() {
        EquationTaskGenerator eq_gen = new EquationTaskGenerator(0, 100 ,
                true, true, true, true);
        ExpressionTaskGenerator ex_gen = new ExpressionTaskGenerator(0, 100,
                true, true, true, true);
        HashMap<String, Quiz> result = new HashMap<>();
        result.put("Math1", new Quiz(eq_gen, 5));
        result.put("Math2", new Quiz(ex_gen, 5));
        result.put("Quiz1", new Quiz(new GroupTaskGenerator(eq_gen, ex_gen), 5));

        TextTask task1 = new TextTask("A+B=", "AB");
        TextTask task2 = new TextTask("А и Б сидели на трубе, А упало, Б пропало," +
                " кто остался на трубе?", "и");
        TextTask task3 = new TextTask("Сколько килограмм в 1кг пуха", "1");
        TextTask task4 = new TextTask("Кто самый крутой?", "Егор");
        TextTask task5 = new TextTask("Вопрос", "Ответ");

        result.put("Quiz2", new Quiz(new PoolTaskGenerator(false, task1, task2, task3, task4, task5),
                5));
        return result;
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        Map<String, Quiz> quizMap = getQuizMap();
        System.out.print("Введите название теста.. ");
        String testName = in.nextLine();
        while (!quizMap.containsKey(testName)) {
            System.out.print("Повторите попытку ");
            testName = in.nextLine();
        }
        Quiz test = quizMap.get(testName);
        while (!test.isFinished()) {
            Task task = test.nextTask();
            System.out.print(task.getText() + " ");
            String answer = in.nextLine();
            System.out.println(answer);
            test.provideAnswer(answer);
        }
        System.out.println("Your mark: " + test.getMark());
    }
}
