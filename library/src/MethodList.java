import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MethodList {
    public static void main(String[] args) {
        /************ 리스트 생성 방법 ************/
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<Integer>();
        ArrayList<Integer> list3 = new ArrayList<>();
        // 배열을 리스트로 만들기
        List<String> list4 = Arrays.asList("송용욱", "송용인", "송동근", "유정실");
        List<Integer> list5 = Arrays.asList(new Integer[] {1,2,3,4,45});

        System.out.println(list4);
        System.out.println(list5);

        /********* 간단한 리스트 메소드 ************/
        list1.add(12);
        list1.set(0, 13);
        list1.get(0);
        list1.remove(0);
        list1.contains(13);
        list1.size();
        list1.isEmpty();
        list1.clear();

        /*********** 접근 방법 ***************/
        for(Integer num : list5){
            System.out.println(num);
        }


    }
}
