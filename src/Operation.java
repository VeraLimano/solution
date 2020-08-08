import java.util.*;

public class Operation {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

     System.out.println("Введите выражение ");

     try {
         if (sc.hasNextInt()) {
             int num1 = sc.nextInt();
             String operation = sc.next();
             int num2 = sc.nextInt();
             int result = calc(num1, operation, num2);
             System.out.println("Ответ: " + result);
         } else {
             RomanNum romanNum1 = RomanNum.valueOf(sc.next());
             String operation = sc.next();
             RomanNum romanNum2 = RomanNum.valueOf(sc.next());
             int num1 = romanNum1.getValue();
             int num2 = romanNum2.getValue();
             int result = calc(num1, operation, num2);
             System.out.println("Ответ: " + ConverterNumber.RomanNumerals(result));
         }
     }
     catch (Exception a){
         System.out.println("Ошибка: " + a);
     }
    }

    public static int calc(int num1, String operation, int num2) {
        int result = 0;
        switch (operation) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            default:
                System.out.println("Ошибка ");
        }
        return result;
    }
}

    class ConverterNumber{

    public static String RomanNumerals ( int Int) {
        LinkedHashMap<String, Integer> roman_numerals = new LinkedHashMap<String, Integer>();
//            roman_numerals.put("M", 1000);
//            roman_numerals.put("CM", 900);
//            roman_numerals.put("D", 500);
//            roman_numerals.put("CD", 400);
        roman_numerals.put("C", 100);
        roman_numerals.put("XC", 90);
        roman_numerals.put("L", 50);
        roman_numerals.put("XL", 40);
        roman_numerals.put("X", 10);
        roman_numerals.put("IX", 9);
        roman_numerals.put("V", 5);
        roman_numerals.put("IV", 4);
        roman_numerals.put("I", 1);
        String res = "";
        for (Map.Entry<String, Integer> entry : roman_numerals.entrySet()) {
            int matches = Int / entry.getValue();
            res += repeat(entry.getKey(), matches);
            Int = Int % entry.getValue();
        }
        return res;
    }

    public static String repeat (String s,int n){
        if (s == null) {
            return null;
        }
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(s);
        }
        return sb.toString();
    }

}

