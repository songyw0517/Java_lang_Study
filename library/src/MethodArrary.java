import java.util.Arrays;

public class MethodArrary {
    public static void main(String[] args) {
        /*********** 배열 생성 ************/
        String[] days = new String[]{"월", "화", "수", "목", "금", "토", "일"};
        int[] num = new int[]{1,2,3,4,5,6};
        Integer[] num2 = new Integer[]{1,2,3,4,5,6};
        int[] ref = new int[5]; // 5의 사이즈를 가진 int형 배열
        int[] arraycopy = new int[5];

        // 2차원 배열 생성
        int[][] twoDimensionArray = new int[3][4];


        /************ 간단한 배열 메소드 **************/
        // toString : 배열을 문자열로 반환
        System.out.println( Arrays.toString(num) );

        // length : 배열의 길이 반환
        System.out.println( ref.length );

        // Arrays.fill : ref의 원소값을 3으로 처리
        Arrays.fill(ref, 3);
        Arrays.fill(ref, 1, 3, 12); // Arrays
        System.out.println("fill 결과" + ref);

        // System.arraycopy()
        System.arraycopy(ref, 0, arraycopy, 3, 4); // arraycopy[3]부터 ref[0]부터 4개를 복사하겠다.


    }
}
