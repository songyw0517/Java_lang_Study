# 컬렉션 프레임워크와 제네릭
## 1. 컬렉션 기반 알고리즘
- 정렬
- 탐색
    ## 정렬
    - List<E>를 구현한 컬렉션 클래스들은 정렬한 상태를 유지하지 않는다.
    - 대신 정렬을 해야한다면 다음 메소드를 사용할 수 있다.
      ```java
      /** 방법 1. Comparable **/
      
       public static <T extends Comparable<? super T>> void sort(List<T> list)
      ```
      ### [코드 해석]
      - <T extends Comparable<? super T>> : sort() 메소드가 제네릭임을 명시
        - 왼쪽의 T는 Comparable<? super T>를 구현해야한다.
        - 즉, 매개변수로 전달되는 List\<T>의 T가 Comparable\<T>를 구현해야한다는 의미이다.
        - 그런데, Comparable<? super T>로 인하여, T를 상속받는 자식 클래스는 들어갈 수 없다.
          #### [예제]
          ```java
          import java.util.ArrayList;
          import java.util.Collections;           
          class Car implements Comparable<Car>{
                private int disp; // 배기량
                public Car(int d){ disp = d; }
                
                ...      
          
                @Override
                public int compareTo(Car o){
                    return disp - o.disp;
                }
          }
          /**********************************************
          - ECar는 Car를 상속하기에 Comparable<Car>를 구현한다.
          - 그러나 Comparable<ECar>는 구현하지 않기에 sort에서 컴파일 에러가 난다.
          - 그런데, Comparable<? super T>로 인하여, sort를 할 수 있게 된다.
                <? super Ecar>가 되어 Comparable<Car>를 받을 수 있기 때문
          **********************************************/
          
          class ECar extends Car{...}
          
          public static void main(String[] args){
                List<Car> list = new ArrayList<>();
                list.add(new Car(1200));
                list.add(new Car(3000));
                list.add(new Car(1800));
                
                // Car 클래스는 Comparable를 구현하기 때문에 sort가 가능하다.
                Collections.sort(list);
          }
          ```
      ```java
      /** 방법2. Comparator<T> 사용 **/
      public static <T> void sort(List<T> list, Comparator<? super T> c)
      ```
        #### [간단 예제]
        ```java
        import java.util.ArrayList;
        import java.util.Collections;
        import java.util.Comparator;
        class Car{ .. }
        
        class ECar extends Car{ .. }
        
        /** Car, ECar의 정렬을 위한 클래스 **/
        class CarComp implements Comparator<Car>{ .. }
      
        public static void main(String[] args){
            List<Car> clist = new ArrayList<>();
            clist.add(new Car(1800));
            clist.add(new Car(1200));
      
            List<ECar> elist = new ArrayList<>();
            elist.add(new ECar(3000, 55));
            elist.add(new ECar(1800, 87));
      
            CarComp comp = new CarComp();
      
            // 각각 정렬
            Collections.sort(clist, comp);
            Collections.sort(elist, comp);
        }
        ```
        ### [코드 설명]
        - 위의 CarComp comp는 Comparator\<Car> 타입이다.
        - 만약 Comparator\<T>를 사용하는 sort에 Comparator<? super T> 가 없을경우<br>
        Collections.sort(elist, comp); 부분에서 컴파일 에러가 난다. <br>
        (comp가 Comparator\<ECar>가 아니기 때문)
        - 하지만 Comparator<? super T>를 사용함으로써 <br>
        Comparator\<ECar>를 참조하는 부모클래스가 들어갈 수 있게 되어 <br>
        Comparator\<ECar>도 들어갈 수 있게 된다.
    ## 탐색
    ```java
    /** 이진 탐색 방법 1.Comparable **/
    public static <T> int binarySearch(List<? extends Comparable<? super T>> list, T key)
    ```
    ```java
    public static <T> int binarySearch(List<? extends T> list, T key, Comparator<? super T> c)
    ```
    - 제네릭이 들어가는 부분은 위의 Car, ECar의 예제로 이해할 수 있다.
    
    ## 복사
    ```java
    public static <T> void copy(List<? super T> dest, List<? extends T> src)
    ```
    - src는 꺼내는 용도(Get), dest는 저장하는 용도(Set)로 사용됨을 명시
    
    