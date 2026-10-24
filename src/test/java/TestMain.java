import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

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

    @ParameterizedTest
    @MethodSource("randomIntArray")
    void isEvenTest(int n) {
        boolean actualResult = Logic.isEven(n);
        boolean expectedResult = (n % 2 == 0);

        if (expectedResult == actualResult) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
    }

    @ParameterizedTest
    @MethodSource("randomIntArray")
    void checkAccessTest(int age) {
        String actualResult = Logic.checkAccess(age);
        String expectedResult = (age > 18) ? "Allowed" : "Denied";

        if (expectedResult.equals(actualResult)) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
    }

    @ParameterizedTest
    @MethodSource("randomIntArray")
    void isPositiveTest(int n) {
        boolean actualResult = Logic.isPositive(n);
        boolean expectedResult = (n >= 0) ? true : false;

        if (expectedResult == actualResult) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
    }

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

        if (expectedResult.equals(actualResult)) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
    }

    @Test
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

        if (expectedResult.equals(actualResult)) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
    }

    @Test
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

        if (expectedResult == actualResult){
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
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

        if (expectedResult == actualResult) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
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

        if (expectedResult.equals(actualResult)) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
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

        if (expectedResult == actualResult){
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
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

        if (Arrays.equals(expectedResult, actualResult)) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
    }

    @Test
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
        if (expectedResult == actualResult){
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
    }

    @Test
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

        if (expectedResult.equals(actualResult)){
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
    }

}
