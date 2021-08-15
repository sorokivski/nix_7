package package_3;
import org.apache.commons.lang3.*;
import org.json.simple.JSONObject;

public class HelloMaven {
    public static void helloText(){
        System.out.println("hello");
        JSONObject obj = new JSONObject();
        obj.put("maven", "Compile");
        System.out.println(obj.toJSONString());

        System.out.println(StringUtils.right("abcdefg", 2));
        System.out.println(StringUtils.right("abcdefg", 4));
        System.out.println(StringUtils.right("abcdefg", 6));
    }
}
