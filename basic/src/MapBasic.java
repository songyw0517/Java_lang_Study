import java.util.HashMap;
import java.util.Map;

public class MapBasic {
    public static void main(String[] args) {
        Map<String, String> dict = new HashMap<>();
        dict.put("chicken", "닭");
        dict.put("hippo", "하마");
        System.out.println(dict);
        String chicken = dict.get("chicken");
        System.out.println(chicken);
    }
}
