public class Cycles {

    // Метод принимает стартовое число (например, 5) и возвращает строку со всеми числами до 1 и словом «Поехали!» в конце (например, «5 4 3 2 1 Поехали!»).
    public static String blastOff(int start) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i >= 1; i--) {
            sb.append(i).append(" ");
        }
        sb.append("Поехали!");
        return sb.toString();
    }

    // Метод возвращает сумму всех целых чисел от 1 до n.
    public static int sumToN(int n){
        if (n < 1) return 0;
        int c = 0;
        int i = 1;
        while (i <= n){
            c += i;
            i++;
        }
        return c;
    }

    // Метод принимает массив строк и возвращает true, если хотя бы одна строка в массиве равна Bug. Сравнение можно выполнять без учёта регистра.
    public static boolean hasBug(String[] messages) {
        for (String message : messages) {
            if ("bug".equalsIgnoreCase(message)) {
                return true;
            }
        }
        return false;
    }

    // Метод принимает границы диапазона и возвращает строку, состоящую только из чётных чисел внутри этого промежутка (включая границы), разделённых пробелом.
    // Перед первым и после последнего числа пробел не ставится. Например: (2, 5) -> “2 4”
    public static String  getEvenInRange(int start, int end) {
        if (start > end) return "";
        StringBuilder sb = new StringBuilder();
        for (int s = start; s <= end; s++){
            if (s % 2 == 0) {
                sb.append(s).append(" ");
            }
        }
        return sb.toString().trim();
    }

}
