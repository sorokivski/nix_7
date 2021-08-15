package ua;
import org.apache.commons.lang3.*;
import org.json.simple.JSONObject;

public class Some {
    public void someText (){
        System.out.println("someText");
    }
    public Some(){
        System.out.println(StringUtils.lowerCase("SOMETEXT"));
        JSONObject obj = new JSONObject();
       obj.put("ant", "Compile");
        System.out.println(obj.toJSONString());
    }
}