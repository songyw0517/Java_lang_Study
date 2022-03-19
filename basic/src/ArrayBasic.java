import java.util.Arrays;

public class ArrayBasic {
    public static void main(String[] args) {
        String[] days = new String[]{"월", "화", "수", "목", "금", "토", "일"};

        // 배열 출력하기 1 (원소 하나씩만 -> 반복문)
        for(int i=0; i< days.length; i++)
            System.out.println(days[i]);

        // 배열 출력하기 2 (한 줄에 -> Arrays.toString(배열) )
        System.out.println(Arrays.toString(days));
    }
}
