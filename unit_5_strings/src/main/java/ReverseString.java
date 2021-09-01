import java.util.Scanner;

import static reverse.ThreeTypesOfReverse.*;

public class ReverseString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter string to reverse and choose type of setting position, " +
                "default - reversing of all string: ");
        String str = in.nextLine();
        switch (in.nextInt()) {
            case 2: {
                in.nextLine();
                System.out.println("Enter substring to reverse: ");
                System.out.println("Result: " + reverseBySubstring(in.nextLine(), str));

                break;
            }
            case 3: {
                System.out.println("Enter start and end position of substring to reverse: ");
                System.out.println("Reversed string: " + reverseByPosition(str, in.nextInt(), in.nextInt()));
                break;
            }
            default: {
                System.out.println("Reversed string: " + reverseString(str));
                break;
            }
        }
    }
}
