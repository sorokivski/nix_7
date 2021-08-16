package reverse;

public class ThreeTypesOfReverse {

    public static String reverseByPosition(String str, int startPos, int endPos) {
        StringBuffer substr = new StringBuffer(str.length());
        for (int i = startPos; i < endPos; i++) substr.append(str.charAt(i));
        return reverseBySubstring(String.valueOf(substr), str);
    }

    public static String reverseBySubstring(String substring, String string) {
        String reverseSubstring = String.valueOf(reverseString(String.valueOf(substring)));
        return string.replaceAll((String.valueOf(substring)), reverseSubstring);
    }

    public static StringBuffer reverseString(String str) {
        StringBuffer sb = new StringBuffer(str.length());
        for (int i = str.length() - 1; i >= 0; i--) sb.append(str.charAt(i));
        return sb;
    }
}
