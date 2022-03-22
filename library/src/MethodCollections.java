import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MethodCollections {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("C");
        list1.add("A");
        list1.add("B");
        list1.add("K");

        sortLibrary(list1);


    }
    // 정렬 라이브러리
    public static void sortLibrary(List<String> list){
        System.out.println("들어온 list = " + list);

        /*********오름차순 정렬*************/
        Collections.sort(list);
        System.out.println("오름차순 정렬한 list = " + list);

        /************ 내림차순 정렬 (오름차순으로 한 뒤에 바꾸는 방식)********/
        Collections.reverse(list);
        System.out.println("내림차순 정렬한 list = " + list);

        /*********** 랜덤 정렬 *****************/
        Collections.shuffle(list);
        System.out.println("랜덤 정렬한 list = " + list);


    }
}
