import java.util.HashSet;
import java.util.Set;

public class MethodSet {
    public static void main(String[] args) {
        /************** set 생성 방법 *************/
        Set<String> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        /************** 간단한 set 메소드 ***********/
        set1.add("치킨");
        set1.remove("치킨");
        set1.contains("치킨");
        set1.size();
        set1.isEmpty();
        set1.clear();

        /************** 접근 방법 **************/
        for(String food : set1){
            System.out.println(food);
        }

    }
}
