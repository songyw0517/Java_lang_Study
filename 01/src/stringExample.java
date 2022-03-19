public class stringExample {
    public static void main(String[] args) {
        /* string */
        System.out.println("문자열");
        System.out.println('A');
        System.out.println("first"+"_last");

        /* escape string*/
        System.out.println("이건 \"뭔\" 자바여");

        String chicken = "치킨은 살 안 쪄요";
        String me = "살은 내가 쪄요";
        System.out.println((chicken+me));
        System.out.println(chicken.length());

        // 문자열 바꾸기
        System.out.println(me.replaceAll("내가", "치킨이"));
        // 문자열 자르기
        String cut = me.substring(1, 4);
        System.out.println(cut);
        String birthday = "1997/05/17";
        String year = birthday.substring(0,4);
        String month = birthday.substring(5,7);
        String day = birthday.substring(8);
        System.out.println(year);
        System.out.println(month);
        System.out.println(day);
    }
}