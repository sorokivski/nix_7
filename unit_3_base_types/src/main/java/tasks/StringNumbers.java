package tasks;
import java.util.*;

public class StringNumbers {

    public static void incomeString(){
       Scanner in = new Scanner(System.in);
        System.out.println("Enter string: ");
        String incomeString = in.nextLine();
        char[] numbers = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        int sum=0;
        for(int i =0; i<incomeString.length();i++){
            for(int j =0; j< numbers.length;j++){
                if(incomeString.charAt(i) == numbers[j]) sum+=Integer.parseInt(String.valueOf(numbers[j]));
            }
        }
        System.out.println("Sum of digits in string = "+sum);
    }

    public static void countChar() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter string: ");
        String incomeString = in.nextLine();
        TreeMap<Character, Integer> fromString = new TreeMap<>();
        incomeString = incomeString.toLowerCase();
        String str = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < str.length(); i++) {
            fromString.put(str.charAt(i), 0);
        }
        for (int i = 0; i < incomeString.length(); i++) {
            if (fromString.containsKey(incomeString.charAt(i)))
                fromString.put(incomeString.charAt(i), fromString.get(incomeString.charAt(i)) + 1);
        }
        fromString.values().removeIf(value -> value==0);
       fromString.entrySet().forEach(System.out::println);
    }
}
