package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class arraylist {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>(); // 컬렉션 인스턴스 생성

        // 컬렉션 인스턴스에 문자열 인스턴스 저장
        list.add("Toy");
        list.add("Box");
        list.add("Robot");

        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i)+'\t');
        }
        System.out.println();

        list.remove(0);
        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i)+'\t');
        }
        System.out.println();
    }
}
