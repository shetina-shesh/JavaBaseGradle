import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main( String[] args )
    {
        String [] messages = {"One", "Two", "Three", "Four", "Bug"};
        int [] num = {-1, -3, -5, -10, -2, -199, -4};
        List<String> textList =  List.of("One", "Two", "Three", "Four", "Five");
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        System.out.println("isEven: " + Logic.isEven(2));
        System.out.println("checkAccess: " + Logic.checkAccess(18));
        System.out.println("isPositive: " + Logic.isPositive(5));
        System.out.println("getGrade: " + Logic.getGrade(27));

        System.out.println("blastOff: " + Cycles.blastOff(5));
        System.out.println("sumToN: " + Cycles.sumToN(4));
        System.out.println("hasBug " + Cycles.hasBug(messages));
        System.out.println("getEvenInRange: " + Cycles.getEvenInRange(2,5));

        System.out.println("findMax: " + Lists.findMax(num));
        System.out.println("reverse: " + Arrays.toString(Lists.reverse(messages)));
        System.out.println("calcAverage: " + Lists.calcAverage(numbers));
        System.out.println("removeSpecificName " + Lists.removeSpecificName(textList, "Three"));

    }

}
