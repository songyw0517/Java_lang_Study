import java.util.StringTokenizer;

// token : Python의 split으로 구분된 것들
public class MethodToken {
    public static void main(String[] args) {
        StringTokenizer st = new StringTokenizer("PM:08:45", ":");
        while(st.hasMoreTokens()){ // hasMoreTokens() : token이 있는지 확인
            System.out.println(st.nextToken()); // nextToken() : token가져오기
        }

        // 구분자는 여러개를 사용할 수 있다.
        StringTokenizer st2 = new StringTokenizer("12 + 36 - 8 / 2 = 44", "+-/= ");
        while(st2.hasMoreTokens()){
            System.out.println(st2.nextToken());
        }
    }
}
