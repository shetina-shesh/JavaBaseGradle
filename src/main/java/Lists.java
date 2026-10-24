import java.util.ArrayList;
import java.util.List;

public class Lists {

    // Метод находит и возвращает самое большое число в переданном массиве.
    public static int findMax(int[] arr){
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int res = arr[0];
        for (int i: arr){
            if (i > res) res = i;
        }
        return res;
    }

    // Метод возвращает новый массив, в котором элементы исходного массива расположены в обратном порядке. Например, {“One”, “Two”, “Zero”} -> {“Zero”, “Two”, “One}.
    public static String[] reverse(String[] arr){
        String[] newArr = new String[arr.length];
        for (int i = arr.length - 1, j = 0; i >= 0; i--, j++) {
            newArr[j] = arr[i];
        }
        return newArr;
    }

    // Метод вычисляет и возвращает среднее арифметическое всех чисел в списке.
    public static int calcAverage(List<Integer> list){
        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        return  sum / list.size();
    }

    // Метод принимает список и имя, которое нужно исключить.
    // Возвращает новый список, не содержащий указанного имени.
    public static List<String> removeSpecificName(List<String> list, String nameToRemove){
        List<String> newList = new ArrayList<>();
        for (String lang : list){
            if (!nameToRemove.equals(lang)) newList.add(lang);
        }
        return newList;
    }

}
