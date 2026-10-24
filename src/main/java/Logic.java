public class Logic {

    //Метод возвращает true, если число чётное, и false — если нечётное.
    public static boolean isEven(int n){
        return n % 2 == 0;
    }

    //Метод возвращает Allowed, если число строго больше 18, и Denied — если меньше.
    public static String checkAccess(int age){
        return (age > 18) ? "Allowed" : "Denied";
    }

    // Метод должен возвращать true, если переданное число больше или равно нулю, и false, если переданное число меньше нуля.
    // Проверка внутри метода должна происходить с помощью тернарного оператора.
    public static boolean isPositive(int n){
        //return n >= 0;
        return (n >= 0) ? true : false;
    }

    //Метод возвращает строку, соответствующую строгому вхождению в границы:
    //
    //0–20: E;
    //21–40: D;
    //41–60: C;
    //61–80: B;
    //81–100: A.
    public static String getGrade(int score){
        if (score < 0 || score > 100) {
            return "Error";
        }
        if (score <= 20) return "E";
        if (score <= 40) return "D";
        if (score <= 60) return "C";
        if (score <= 80) return "B";
        return "A";
    }

}
