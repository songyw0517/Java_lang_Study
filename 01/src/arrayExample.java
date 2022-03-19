public class arrayExample {
    public static void main(String[] args) {
        String[] days = {"월", "화", "수", "목", "금", "토", "일"};
        for(int i=0; i<days.length; i++){
            System.out.println(days[i]);
        }
        for(String day:days){
            System.out.println(day);
        }
    }
}
