# 스트림(Stream)
- 여러 작업이 순차적으로 이루어지는 경우에 
- 코드를 간단히 하기 위해 제공되는 인스턴스?로 생각하면 좋을 것 같다.

## 중간연산 VS 최종연산
- 중간연산 예시)
  - 홀수만 걸러내는 것
- 최종연산 예시)
  - 덧셈

## 스트림 생성, 중간 연산, 최종연산
```java
/** 학습용 코드 **/
int[] ar = {1,2,3,4,5};
// 스트림 생성
IntStream stm1 = Arrays.stream(ar);

// 중간 연산 수행 - 홀수만 거르기
IntStream stmm2 = stm1.filter(n -> n%2 == 1);

// 최종 연산 수행 - 덧셈
int sum = stm2.sum();

System.out.println(sum);
```
```java
/** 실무용 코드 1 **/
int[] ar = {1,2,3,4,5};

int sum = Arrays.stream(ar)
        .filter(n -> n%2 == 1)
        .sum();

System.out.println(sum);

/** 실무용 코드 2 **/
String[] names = {"Yoon", "LEE", "PARK"};
Arrays.stream(names)
        .forEach(s -> System.out.println(s));

/** 실무용 코드 3 **/
// Collection의 경우-> .stream()으로 수행할 수 있다.
List<String> list = Arrays.asList("Toy", "Robot", "Box");
list.stream()
        .forEach(s -> System.out.println(s + "\t"));
System.out.println();
```

## 