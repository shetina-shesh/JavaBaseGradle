import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Tag("SMOKE")
public class TestMain {

    static int[] randomIntArray() {
        int[] array = new int[10];
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            array[i] = random.nextInt(0, 101);
        }
        return array;
    }

    @BeforeEach
    void setup() {
        System.out.println("========================");
        System.out.println("Test method start");
    }

    @AfterEach
    void cleanup() {
        System.out.println("Test method end");
        System.out.println("========================");
    }

    @Tag("DEV")
    @ParameterizedTest
    @MethodSource("randomIntArray")
    void isEvenTest(int n) {
        boolean actualResult = Logic.isEven(n);
        boolean expectedResult = (n % 2 == 0); //false

        Assertions.assertThat(actualResult)
                .as("Проверка четности для числа: %d", n)
                .isEqualTo(expectedResult);
    }

    @Tag("DEV")
    @ParameterizedTest
    @MethodSource("randomIntArray")
    void checkAccessTest(int age) {
        String actualResult = Logic.checkAccess(age);
        String expectedResult = (age > 18) ? "Allowed" : "Denied";

        Assertions.assertThat(actualResult)
                .as("Проверка доступа для возраста: %d", age)
                .isEqualTo(expectedResult);
    }

    @Tag("DEV")
    @ParameterizedTest
    @MethodSource("randomIntArray")
    void isPositiveTest(int n) {
        boolean actualResult = Logic.isPositive(n);
        boolean expectedResult = (n >= 0) ? true : false;

        Assertions.assertThat(actualResult)
                .as("Проверка знака (+ или -) для числа: %d", n)
                .isEqualTo(expectedResult);
    }

    @Tag("DEV")
    @ParameterizedTest
    @MethodSource("randomIntArray")
    void getGradeTest(int score) {
        String actualResult = Logic.getGrade(score);
        String expectedResult;
        if (score < 0 || score > 100) {
            expectedResult = "Error";
        } else if (score <= 20) {
            expectedResult = "E";
        } else if (score <= 40) {
            expectedResult = "D";
        } else if (score <= 60) {
            expectedResult = "C";
        } else if (score <= 80) {
            expectedResult = "B";
        } else {
            expectedResult = "A";
        }

        Assertions.assertThat(actualResult)
                .as("Определение оценки для балла: %d", score)
                .isEqualTo(expectedResult);
    }

    @RepeatedTest(10)
    void blastOffTest() {
        Random random = new Random();
        int start = random.nextInt(1, 101);
        StringBuilder sb = new StringBuilder();
        for (int i = start; i >= 1; i--) {
            sb.append(i).append(" ");
        }
        sb.append("Поехали!");

        String actualResult = Cycles.blastOff(start);
        String expectedResult = sb.toString();

        Assertions.assertThat(actualResult)
                .as("Формирование строки отсчета со старта: %d", start)
                .isEqualTo(expectedResult);
    }

    @RepeatedTest(10)
    void sumToNTest() {
        Random random = new Random();
        int number = random.nextInt(1, 101);
        int actualResult = Cycles.sumToN(number);
        int expectedResult;
        if (number < 0) {
            expectedResult = 0;
        } else {
            expectedResult = number * (number + 1) / 2;
        }

        Assertions.assertThat(actualResult)
                .as("Подсчет суммы чисел от 1 до N для значения N = %d", number)
                .isEqualTo(expectedResult);
    }

    @RepeatedTest(10)
    void hasBugTest() {
        Random random = new Random();
        String[] stringPool = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Bug"};
        int length = random.nextInt(3, 6);
        String[] messages = new String[length];
        for (int i = 0; i < length; i++) {
            messages[i] = stringPool[random.nextInt(stringPool.length)];
        }

        boolean actualResult = Cycles.hasBug(messages);
        boolean expectedResult = false;
        for (String message : messages) {
            if ("bug".equalsIgnoreCase(message)) {
                expectedResult = true;
                break;
            }
        }

        Assertions.assertThat(actualResult)
                .as("Поиск слова 'Bug' (без учета регистра) в массиве: %s", Arrays.toString(messages))
                .isEqualTo(expectedResult);
    }

    @RepeatedTest(10)
    void getEvenInRangeTest() {
        Random random = new Random();
        int start = random.nextInt(-100, 101);
        int end = random.nextInt(-100, 101);
        String actualResult = Cycles.getEvenInRange(start, end);
        String expectedResult = "";

        if (start <= end) {
            StringBuilder sb = new StringBuilder();
            for (int s = start; s <= end; s++) {
                if (s % 2 == 0) {
                    sb.append(s).append(" ");
                }
            }
            expectedResult = sb.toString().trim();
        }

        Assertions.assertThat(actualResult)
                .as("Получение четных чисел в диапазоне от start = %d до end = %d", start, end)
                .isEqualTo(expectedResult);
    }

    @RepeatedTest(10)
    void findMaxTest() {
        int[] array = new int[10];
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            array[i] = random.nextInt(0, 101);
        }

        int actualResult = Lists.findMax(array);
        int expectedResult = array[0];
        for (int i : array){
            if (i > expectedResult) expectedResult = i;
        }

        Assertions.assertThat(actualResult)
                .as("Поиск максимального значения в массиве: %s", Arrays.toString(array))
                .isEqualTo(expectedResult);
    }

    @RepeatedTest(10)
    void reverseTest() {
        Random random = new Random();
        String[] stringPool = {"One", "Two", "Three", "Five", "Six", "Seven", "BUG", "BuG"};
        int length = random.nextInt(3, 6);
        String[] messages = new String[length];

        for (int i = 0; i < length; i++) {
            messages[i] = stringPool[random.nextInt(stringPool.length)];
        }

        String[] actualResult = Lists.reverse(messages);
        String[] expectedResult = new String[messages.length];

        for (int i = messages.length - 1, j = 0; i >= 0; i--, j++) {
            expectedResult[j] = messages[i];
        }

        Assertions.assertThat(actualResult)
                .as("Разворот массива строк в обратном порядке. Исходный массив: %s", java.util.Arrays.toString(messages))
                .isEqualTo(expectedResult);
    }

    @RepeatedTest(10)
    void calcAverageTest() {
        Random random = new Random();
        int length = random.nextInt(3, 6);
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            numbers.add(random.nextInt(-100, 101));
        }

        int sum = 0;
        for (int i : numbers) {
            sum += i;
        }

        int actualResult = Lists.calcAverage(numbers);
        int expectedResult = sum / numbers.size();

        Assertions.assertThat(actualResult)
                .as("Вычисление среднего арифметического для списка чисел: %s", numbers)
                .isEqualTo(expectedResult);
    }

    @RepeatedTest(10)
    void removeSpecificNameTest() {
        Random random = new Random();
        String[] stringPool = {"One", "Two", "Three", "Four", "Five", "Six", "Seven"};
        int length = random.nextInt(3, 8);
        List<String> textList = new ArrayList<>(length);
        for (int i = 0; i < length; i++){
            textList.add(stringPool[random.nextInt(stringPool.length)]);
        }

        String nameToRemove = stringPool[random.nextInt(stringPool.length)];
        List<String> expectedResult = new ArrayList<>();
        for (String lang : textList){
            if (!nameToRemove.equals(lang)) expectedResult.add(lang);
        }

        List<String> actualResult = Lists.removeSpecificName(textList, nameToRemove);

        Assertions.assertThat(actualResult)
                .as("Исключение элемента '%s' из списка: %s", nameToRemove, textList)
                .isEqualTo(expectedResult);
    }

}
