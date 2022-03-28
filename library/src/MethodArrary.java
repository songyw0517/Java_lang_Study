import java.util.Arrays;
class Person implements Comparable {
    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    // 기준을 age로 정한 경우
    @Override
    public int compareTo(Object o) {
        Person p = (Person)o; // 형변환
        return this.age - p.age;
    }
    public String toString(){
        return name+" : "+age;
    }
}
public class MethodArrary {
    // compareTo메소드를 이용한 클래스

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
        int[] fillTest = new int[5];
        Arrays.fill(ref, 3);
        Arrays.fill(ref, 1, 3, 12); // Arrays
        System.out.println("fill 결과" + ref);

        // System.arraycopy()
        System.arraycopy(ref, 0, arraycopy, 3, 2); // arraycopy[3]부터 ref[0]부터 2개를 복사하겠다.


        // Arrays.copyOf()
        String[] copyofArray = Arrays.copyOf(days, days.length);
        for(String elem : copyofArray){
            System.out.println(elem);
        }

        // Arrays.equals
        /** Arrays.equals는 Object.equals와 달리 '값'을 비교한 것을 반환한다. **/
        int[] ar1 = {1,2,3,4,5};
        int[] ar2 = {1,2,3,4,5};
        System.out.println(Arrays.equals(ar1, ar2));
        /*
        오버라이딩시
        @Override
        public boolean equals(Object obj){
            if(this.num == (([클래스이름])obj).num{ // 현재 값(this.num)과 [클래스이름]으로 형변환된 Object의 값을 비교
                return true;
            }
            else{
                return false;
            }
        }
        */

        // Arrays.sort
        System.out.println("*".repeat(10)+"Arrays.sort"+"*".repeat(10));
        int[] arr = {4,3,56,1,2,6,10,44};
        Arrays.sort(arr); // 오름차순 정렬
        for(int elem: arr){
            System.out.print(elem+" ");
        }
        System.out.println();
        /****** 정렬의 기준을 정하는 compareTo메소드 *********/
        interface Comparable{
            /*
            - 인자로 전달된 o가 작다면 -> 양의 정수 반환
            - 인자로 전달된 o가 크다면 -> 음의 정수 반환
            - 인자로 전달된 o와 같다면 -> 0 반환
            ex) A.compareTo(B) // A>B -> 양의 정수, A<B -> 음의 정수, A==B -> 0
             */
            int compareTo(Object o);
        }

        // compareTo 메소드를 이용한 정렬
        Person[] ar = new Person[3];
        ar[0] = new Person("Lee", 29);
        ar[1] = new Person("Goo", 15);
        ar[2] = new Person("Soo", 37);
        Arrays.sort(ar);
        for(Person p:ar)
            System.out.println(p);
        
        // Arrays.binarySearch() : 배열에서 key를 찾는다. 있으면 key의 인덱스를 반환 / 없으면 음수를 반환한다.
        int[] arrBin = {33, 55, 11, 44, 22};
        Arrays.sort(arrBin); // 이진 탐색을 위해 오름차순으로 먼저 정렬한다.
        for(int elem:arrBin)
            System.out.print(elem + "\t");
        System.out.println();
        int idx = Arrays.binarySearch(arrBin, 33);
        System.out.println("binarySearch로 33을 찾은 인덱스 = "+idx);

        /* 클래스에서의 Arrays.binarysearch() */
        Person[] perBin = new Person[3];
        perBin[0] = new Person("Lee", 29);
        perBin[1] = new Person("Goo", 15);
        perBin[2] = new Person("Soo", 37);
        Arrays.sort(perBin);
        for(Person p: perBin)
            System.out.print(p + "\t");
        System.out.println();
        int idx2 = Arrays.binarySearch(perBin, new Person("Who are you?", 37)); // 37을 찾는다!
        System.out.println("나이가 37인 인덱스 = " + idx2);
    }
}
