import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MethodMap {
    public static void main(String[] args) {
        /***************** Map 생성 방법 ********************
         * Map< [키 자료형], [값 자료형] > [변수 이름] = new HashMap<>();
         ***************************************************/

        Map<String, String> map = new HashMap<>();


        /*************** 간단한 Map 메소드 ********************/
        map.put("key", "value");
        map.put("key2", "value2");
        map.put("rmKey", "rmValue");
        String value = map.get("key2"); // map에서 "key2"의 값을 가져오기
        int size = map.size(); // map 데이터 개수
        String rmData = map.remove("rmKey"); // map에서 rkKey의 값을 가져오고, 삭제
        boolean empty = map.isEmpty();
        Collection<String> keys = map.keySet(); // map에서 keys 가져오기
        Collection<String> values = map.values(); // map에서 values 가져오기
        
        /*** 의미 : Set의 원소가 Map.Entry<String, String> 이라는 뜻 ***/
        Set<Map.Entry<String, String>> entries = map.entrySet(); // entry set가져오기

        // 출력
        System.out.println("key2 값 가져오기 => "+value);
        System.out.println("map 데이터 개수 가져오기 => "+size);
        System.out.println("data => "+rmData);
        System.out.println("isEmpty = " + empty);
        System.out.println("keys = " + keys);
        System.out.println("value = " + values);
        System.out.println("******************* entryset 출력 **************");
        for(Map.Entry<String, String> entry : entries){
            String entryKey = entry.getKey();
            String entryValue = entry.getValue();
            System.out.println("key = " + entryKey + " value = " + entryValue);
        }
    }
}
