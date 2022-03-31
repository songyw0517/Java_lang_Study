# 컬렉션 프레임워크의 이해
- 인스턴스에 어떻게 저장, 삭제, 참조할 것인가?

## 컬렉션 프레임워크의 인터페이스
![img_1.png](img_1.png)

<hr>

# List\<E> 인터페이스를 구현하는 컬렉션 클래스들
## 대표적인 List<E> 인터페이스를 구현하는 클래스
- ArrayList\<E> : 배열 기반 자료구조, 배열을 이용하여 인스턴스 저장 
- LinkedList\<E> : 리스트 기반 자료구조, 리스트를 구성하여 인스턴스 저장
## List\<E> 인터페이스를 구현하는 클래스의 특성
- 인스턴스의 저장 순서 유지
- 동일 인스턴스의 중복 저장을 허용한다.

## 1. ArrayList\<E>
```java
public static void main(String[] args) {
        List<String> list = new ArrayList<>(); // 컬렉션 인스턴스 생성

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
```

## 2. LinkedList\<E>
```java
public static void main(String[] args) {
        List<String> list = new LinkedList<>(); // 유일한 변화!

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
```
<hr>

## Collection의 순차적 접근 방법
### 1. enhanced for문 사용
```java
public static void main(String[]args){
        List<String> list = new LinkedList<>();
        
        // 인스턴스 저장
        list.add("Toy");
        list.add("Box");
        list.add("Robot");
        
        // 순차적 접근 방법 1
        for(String s : list)
            System.out.print(s + '\t');
}
```
### 2. 반복자를 사용하는 방법
- 반복자 : 대상이 되는 객체에 대해 '하나씩' 꺼내주는 역할을 한다.
```java
public static void main(String[]args){
        List<String> list = new LinkedList<>();

        // 인스턴스 저장
        list.add("Toy");
        list.add("Box");
        list.add("Robot");
        
        // 반복자 생성
        Iterator<String> itr = list.iterator();
        
        // 반복자를 이용한 순차적 참조 1.
        while(iter.hasNext()){
            str = iter.next();
            System.out.print(str + '\t');
        }
        
        // 반복자를 이용한 순차적 참조 2.
        for(Iterator<String> itr = list.iterator(); itr.hasNext();){
            str = itr.next();
            System.out.print(n + '\t');
        }
}
```
- list.iterator() : 반복자 생성하여 반환
- iter.hasNext() : 반환할 것이 있는가? : 있으면 true, 없으면 false
- iter.next() : 현재 위치의 값 반환
    ### 반복자의 세 가지 메소드
  1. Iterator.next(); // 다음 인스턴스의 참조 값을 반환
  2. Iterator.hasNext(); // next 메소드 호출 시 참조 값 반환 여부 확인
  3. Iterator.remove(); // next 메소드 호출을 통해 반환했던 인스턴스 삭제 (현재 위치의 인스턴스 삭제)
    ### 양방향 반복자의 추가 메소드 (ListIterator로, 리스트만 갖는다.)
  1. ListIterator.previous(); // next() 메소드의 반대 방향으로 이동 및 참조 값 반환
  2. ListIterator.hasPrevious(); // hasNext() 메소드의 반대 방향 역할
  3. add(E e); // 인스턴스 추가
  4. set(E e); // 인스턴스 변경

<hr>

## 배열을 ArrayList로 바꾸기
```java
// asList로 생성된 list는 Immutable 인스턴스로, 변경 불가능하다.
List<String> list = Arrays.asList("Toy", "Robot", "Box");

// 생성자 public ArrayList(Collection<? extends E> c)를 통한 인스턴스 생성을 하면
// 변경이 가능해진다.
list = new ArrayList<>(list); // ArrayList로 변경
list = new LinkedList<>(list); // LinkedList로 변경
```

<hr>
<hr>

# Set<E> 인터페이스를 구현하는 컬렉션 클래스들
## 대표적인 Set<E> 인터페이스를 구현하는 클래스
- HashSet\<E>
- TreeSet\<E>

## Set<E> 인터페이스를 구현하는 클래스의 특성
- 중복 불가
- 순서 유지 불가
## HashSet\<E>
```java
public static void main(String[]args){
    Set<String> set = new HashSet<>();
    set.add("Toy"); set.add("Box");
    set.add("Robot"); set.add("Box"); // Box는 중복되므로 넣지않는다.
    System.out.println("인스턴스 수 = " + set.size());
    
    // 반복자를 이요한 전체 출력
    for(Iterator<String> itr = set.iterator(); itr.hasNext();){
        System.out.print(itr.next() + '\t');    
    }
    
    // for-each문
    for(String s : set){
        System.out.print(s + '\t');
    }    
}
```
## hashCode()와 equals()
### equals
```java
public boolean equals(Object obj)
```
- Object 클래스의 equals 메소드 호출 결과를 근거로 동일 인스턴스를 판단
### hashCode
```java
public int hashCode()
```
- set의 해쉬 코드를 반환
### Set에서의 동일 인스턴스
1. hashCode를 통해 동일한 해쉬 코드를 가진 집합에 대해 접근한다.
2. 동일한 해쉬 코드를 가진 집합에 대해 equals 메소드를 통해 동일 인스턴스를 찾는다.<br>
-> 더 빠른 탐색이 가능하다.

## HashSet\<E> 인스턴스에 저장할 클래스 정의의 예
```java
class Num{
    private int num;
    public Num(int n){ num = n;}
    
    @Override
    public String toString(){return String.valueOf(num);}
  
    // hashCode 오버라이딩
    @Override
    public int hashCode(){
        return num % 3;
    }
    
    // equals 오버라이딩
    @Override
    public boolean equals(Object obj){
        if(num == (Num)obj.num)
            return true;
        else
            return false;
    }
}
```
[코드 해석]
- Num 클래스는 hashCode() 메소드를 갖고 있기 때문에, 
<br>Num 클래스에 대해 Set을 생성할 때, 같은 해쉬 코드를 갖는 것들로 분류한다.

## 클래스에서의 적당한 hashCode() 메소드의 오버라이딩
### 1. 직접 만든다.
```java
class Car{
    private String model;
    private String color;
    
    ...
  
    @Override
    public int hashCode(){
        return (model.hashCode() + color.hashCode()) / 2;
    }
}
```
- Car 클래스의 모든 데이터들에 대한 해쉬코드를 참고하여 hashCode() 메소드를 오버라이딩 했다.
### 2. java.util.Objects에 정의된 hash 메소드를 이용한다.
```java
class Car{
    private String model;
    private String color;
    
    ...
    
    @Override
    public int hashCode(){
        return Objects.hash(model, color);
    }
}
```

## TreeSet\<E>
```java
public static void main(String[]args){
    TreeSet<Integer> tree = new TreeSet<Integer>();
    tree.add(3); tree.add(1);
    tree.add(2); tree.add(4);
    System.out.println("인스턴스 수 = "+tree.size());
    
    // for-each 문에 대한 반복
    for(Integer n : tree){
        System.out.print(n.toString() + '\t');
    }
    System.out.println();
    
    // Iterator 반복자에 의한 반복
    for(Iterator<Integer> itr = tree.iterator(); itr.hasNext();){
        System.out.print(itr.next().toString() + '\t');
    }
    System.out.println();
        
}
```
- 반복자의 인스턴스 참조 순서는 '오름차순'을 기준으로 참조한다.

### 기준을 다르게 하려면 어떻게 해야할까? (Comparable 인터페이스)
- 제네릭 등장 이후로 Comparable 인터페이스가 바뀌었다.
```java
interface comparable<T>
    -> int compareTo(T o)
```
- TreeSet 인스턴스에 저장될 것을 고려한 클래스의 예
  ```java
  class Person implements Comparable<Person>{
        private String name;
        private int age;
        
        // age를 기준으로 바꾸었다.
        @Override
        public int compareTo(Person p){
            return this.age - p.age;
        }
  }
  ```
### Comparator\<T> ?
```java
public TreeSet(Comparator<? super E> comparator)
```
- 이를 사용하여 기존에 정의되어있는 comparable의 기준을 바꿀 수 있다.
  ### 코드 1. Person 클래스의 정렬 기준을 바꾸다.
  ```java
  import java.util.Comparator;import java.util.TreeSet;   
  
  // 1. 이미 compareTo가 정의되어 있는 상황이다.
  class Person implements Comparable<Person>{
        private String name;
        private int age;
        
        // age를 기준으로 바꾸었다.
        @Override
        public int compareTo(Person p){
            return this.age - p.age;
        }
  }
  
  // 2. Comparator을 구현하여 compare메소드를 정의하고 있다. 
  // 기존의 Person의 기준을 바꾸었다.
  class PersonComparator implements Comparator<Person>{
      public int compare(Person p1, Person p2){
          return p2.age - p1.age   
      }
  }
  public static void main(String[] args){
        TreeSet<Person> tree = new TreeSet<>(new PersonComparator());
        tree.add(new Person("Yoon", 37));
        tree.add(new Person("HONG", 53));
        tree.add(new Person("Park", 22));
    
        for(Person p : tree)
            System.out.println(p);
  }
  ```
  ### 코드 2. Stirng 클래스의 정렬 기준을 바꾸다.
  ```java
    import java.util.Comparator;
    import java.util.TreeSet;
    
    // 문자열의 길이를 기준으로 정렬
    class StringComparator implements Comparator{
        public int compare(String s1, String s2){
            return s1.length() - s2.length();
        } 
    }
    public static void main(String[] args){
        TreeSet<String> tree = new TreeSet<>(new StringComparator());
        tree.add("Box");
        tree.add("Rabbit");
        tree.add("Robot");
        
        for(String s : tree)
            System.out.print(s.toString() + '\t');
        System.out.println();
    }
  ```
## 중복된 인스턴스를 삭제하는 방법 (ArrayList를 Set으로)
```java
public static void main(String[]args){
    List<String> lst = Arrays.asList("Box", "Toy", "Box", "Toy");
    ArrayList<String> list = new ArrayList<>(lst);
    
    // 중복이 있음을 확인
    for(String s : list)
        System.out.print(s.toString() + '\t'); 
    System.out.println();
    
    // 중복된 인스턴스를 거르기 (리스트를 셋으로)
    HashSet<String> set = new HashSet<>(list);
    
    // 셋을 다시 리스트로 변경
    list = new ArrayList<>(set);
    
    // 중복이 없어졌음을 확인
    for(String s : list)
        System.out.print(s.toString() + '\t');
    System.out.println();
}
```

<hr>
<hr>

# Queue<E> 인터페이스를 구현하는 컬렉션 클래스들
- Queue<E>
- Deque<E>

# 1. Queue<E>, 큐
## Queeue<E> 인터페이스의 메소드들
- boolean add(E e) : 넣기
- E remove() : 꺼내기, 삭제
- E element() : 확인하기

## 위의 메소드의 예외를 처리하기 위한 메소드 (권장)
- boolean offer(E e) : 넣기, 넣을 공간이 부족하면 false 반환
- E poll() : 꺼내기, 꺼낼 대상 없으면 null 반환
- E peek() : 확인하기, 확인할 대상이 없으면 null 반환

## 큐의 구현
```java
public static void main(String[]args){
    Queue<String> que = new LinkedList<>();
    que.offer("Box");
    que.offer("Toy");
    que.offer("Robot");
    
    // 무엇이 나올지 확인
    System.out.println("next = "+que.peek());

    // 첫번째, 두번재 인스턴스 꺼내기
    System.out.println(que.poll());
    System.out.println(que.poll());
    
    // 무엇이 다음에 나올지 확인
    System.out.println("next = "+que.peek());
    
    // 마지막 인스턴스 꺼내기
    System.out.println(que.poll());
    
}
```
[코드 설명]
- LinkedList<E>는 List<E>와 동시에 Queue<E>를 구현하는 컬렉션 클래스입니다.
<br>따라서 어떠한 타입의 참조 변수로 참조하느냐에 따라 '리스트' 또는 '큐'로 사용할 수 있습니다.

# 2. Deque<E>, 스택
## Deque<E> 인터페이스의 메소드들
### <앞에서 넣고 확인>
- boolean offerFirst(E e) : 넣기 공간 부족하면 false 반환
- E poolFirst() : 꺼내기, 꺼낼 대상 없으면 null 반환
- E peekFirst() : 확인하기, 확인할 대상 없으면 null 반환

### <뒤에서 넣고 확인>
- boolean offerLast(E e) : 넣기, 공간이 부족하면 false 반환
- E poolLast() : 꺼내기, 꺼낼 대상 없으면 null 반환
- E peekLast() : 확인하기, 확인할 대상 없으면 null 반환

## 스택의 구현
```java
public static void main(String[]args){
    Deque<String> deq = new ArrayDeque<>();
    Deque<String> deq = new LinkedList<>(); // 이렇게도 생성이 가능하다.
    
    // 앞으로 넣고
    deq.offerFirst("1.Box");
    deq.offerFirst("2.Toy");
    deq.offerFirst("3.Robot");
    
    // 앞에서 꺼내기
    System.out.println(deq.pollFirst());
    System.out.println(deq.pollFirst());
    System.out.println(deq.pollFirst());
        
}
```

<hr>
<hr>

# Map<K, V> 인터페이스를 구현하는 컬렉션 클래스들
- Iterable 인터페이스를 구현하지 않는다. -> 반복자를 얻을 수 없다.
- HashMap
- TreeMap
## HashMap<K, V>
```java
public static void main(String[]args){
    HashMap<Integer, String> map = new HashMap<>();
    
    // Key-Value 기반 데이터 저장
    map.put(45, "Brown");    
    map.put(37, "James");   
    map.put(23, "Martin");
    
    // 데이터 탐색
    System.out.println("23번 : "+map.get(23));
    System.out.println("37번 : "+map.get(37));
    System.out.println("45번 : "+map.get(45));
    System.out.println();
    
    // 데이터 삭제
    map.remove(37);
    
    // 데이터 삭제 확인
    System.out.println("37번 : "+map.get(37));    
}
```
## Map 전체 데이터에 접근하려면?
```java
public Set<K> KeySet(); // 메소드를 이용하여 접근한다.

public static void main(String[]args){
        HashMap<Integer, String> map=new HashMap<>();

        // Key-Value 기반 데이터 저장
        map.put(45,"Brown");
        map.put(37,"James");
        map.put(23,"Martin");
        
        // Key만 담고 있는 컬렉션 인스턴스 생성 (Set)
        Set<Integer> ks = map.keys();
        
        // 전체 key 출력
        for(Integer n : ks)
            System.out.print(n.toString() + '\t');
        System.out.println();
        
        // 전체 Value 출력
        for(Integer n : ks)
            System.out.print(map.get(n) + '\t');
        System.out.println();
        
        // 전체 Value 출력 (반복자 기반)
        for(Iterator<Integer> itr = ks.iterator(); itr.hasNext();)
            System.out.print(map.get(itr.next()) + '\t');
        System.out.println();
        
}
```

## TreeMap<K, V>
- 데이터를 저장시, 정렬을 하며 저장을 한다.
```java
TreeMap<Integer, String> map = new TreeMap<>();
```