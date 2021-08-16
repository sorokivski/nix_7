package level1;

import java.util.*;

public class t1_uniqNum {

    public static void unique(int[] arr) {
        Set<Integer> UniqCharacters = new TreeSet<Integer>();
        for (int i : arr) {
            UniqCharacters.add(i);
        }
        System.out.println("Number of unique characters: " + UniqCharacters.size());
    }

    public static void inputValues() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of elements in array: ");
        int sizeOf = in.nextInt();
        int arr[] = new int[sizeOf];
        System.out.println("Enter values:");
        for (int i = 0; i < arr.length; i++) {
            if (in.hasNextInt()) arr[i] = in.nextInt();
        }
        unique(arr);
    }
}
