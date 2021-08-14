package level2;
import java.util.Scanner;
import java.util.Stack;

public class CorrectString {
    public static void checkString() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter string to check:");
        String string = in.nextLine();

        boolean isCorrect = true;
        if (!string.contains("(") && !string.contains("[") && !string.contains("{")) isCorrect = true;
        else isCorrect = calculateBraces(string);

        if (!isCorrect) System.out.println( "Incorrect string");
        else System.out.println("Correct string (has no mismatch braces):");
    }

    private static boolean calculateBraces(String string) {

        boolean isCorrect = true;
        Stack<Character> brackets = new Stack<>();
        brackets.push(' ');

        for (int i = 0; i < string.length(); i++) {
            switch (string.charAt(i)) {
                case '(':
                case '[':
                case '{':
                    brackets.push(string.charAt(i));
                    break;
                case ')':
                    if ((brackets.peek() != '(') || brackets.empty()) {
                        isCorrect = false;
                        break;
                    } else brackets.pop();
                    break;
                case ']':
                    if ((brackets.peek() != '[') || brackets.empty()) {
                        isCorrect = false;
                        break;
                    } else brackets.pop();
                    break;
                case '}':
                    if ((brackets.peek() != '{') || brackets.empty()) {
                        isCorrect = false;
                        break;
                    } else brackets.pop();
                    break;
            }

        }
        brackets.pop();
     return isCorrect;
}
}
