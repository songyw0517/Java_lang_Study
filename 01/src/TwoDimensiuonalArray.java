import java.util.Arrays;

public class TwoDimensiuonalArray {
    public static void main(String[] args) {
        String[][] days = {
                {"월", "화", "수", "목", "금", "토", "일"},
                {"월", "화", "수", "목", "금", "토", "d"},
                {"월", "화", "수", "목", "금", "토", "e"},
                {"월", "화", "수", "목", "금", "토", "c"}
        };
        for(int i=0; i<days.length; i++){
            System.out.println(Arrays.toString(days[i]));
        }
    }
}
