package Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ListExample {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        /************* list 생성 ***********************/
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<Integer>();
        ArrayList<Integer> list3 = new ArrayList<>();

        /**********************************************/
        list_ex1();
        System.out.println("list_ex2 시작");
        list_ex2();

    }
    public static void list_ex1(){
        List<String> list = new ArrayList<>();
        // list.add
        System.out.println("**************** add *************");
        list.add("치킨");
        list.add("피자");
        System.out.println(list);

        // list.remove
        System.out.println("**************** remove *************");
        list.remove("치킨"); // "치킨" 삭제
        System.out.println(list);
        list.remove(0); // 0번째 인덱스 삭제
        System.out.println(list);

        // list.set
        System.out.println("**************** set *************");
        list.add("치킨");
        list.add("피자");
        System.out.println("set 하기 전 list = " + list);
        list.set(0, "test");
        System.out.println("set 한 후 list = " + list);
        
        // list.get
        /* list[0] 으로 접근 불가 */
        System.out.println(list.get(0));

        // list.contains
        // python의 in
        if(list.contains("치킨")) {
            System.out.println("치킨이 리스트에 들어있습니다.");
        }else{
            System.out.println("치킨이 리스트에 없습니다.");
        }

        // list 정렬 -> Collections.sort
        List<String> sortedList = new ArrayList<>();
        sortedList.add("B");
        sortedList.add("T");
        sortedList.add("A");
        sortedList.add("K");
        System.out.println("정렬하기 전 list = " + sortedList);

        Collections.sort(sortedList);
        System.out.println("정렬한 후 list = " + sortedList);

        // list 내림차순 정렬 -> Collections.reverse
        Collections.reverse(sortedList);
        System.out.println("내림차순 정렬 후 list = " + sortedList);

        // list 랜덤 정렬 -> Collections.shuffle
        Collections.shuffle(sortedList);
        System.out.println("셔플 정렬 후 list = " + sortedList);
    }
    public static void list_ex2(){
        System.out.println("저장할 음식 이름 입력. (종료 : 0)");
        List<String> foods = new ArrayList<>();

        while(true){
            String food = scanner.nextLine();
            if(food.equals("0")){
                break;
            }
            if(foods.contains(food)){
                System.out.println("이미 목록에 있습니다.");
            }else{
                foods.add(food);
            }
        }
        System.out.println(foods);

    }
}
