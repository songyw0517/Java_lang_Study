# Optional 클래스
- 많은 if ~ else ~ 문이 마음에 들지 않는다.
- if ~ else ~ 가 Optional 클래스에게 떠넘길 수 있다.
- 모든 if else 문을 담당하는 것은 아니다.

## Optional 클래스를 사용하는 경우
- null값을 가지는 인스턴스 변수가 있을 경우 (NullPointerException)
  - 계속적으로 null인 것을 확인해야하는 경우 // ```if( f != null )```

## Optional 클래스 사용방법 1
- Optional.of
- Optional.ofNullable
- Optional.isPresent
- Optional.get
```java
public static void main(String[]args){
    Optional<String> os1 = Optional.of(new String("Toy1")); // of : null 허용하지 않음
    Optional<String> os2 = Optional.ofNullable(new String("Toy2")); // ofNullable : null 허용
    
    if(os1.isPresent())
        System.out.println(os1.get());
    if(os2.isPresent())
        System.out.println(os2.get())
}
```

## Optional 클래스 사용방법 2
- ifPresent
```java
class StringOptional2{
    public static void main(String[] args) {
        Optional<String> os1 = Optional.of(new String("Toy1")); // of : null 허용하지 않음
        Optional<String> os2 = Optional.ofNullable(new String("Toy2")); // ofNullable : null 허용
        
        os1.ifPresent(s -> System.out.println(s)); // 람다식
        os2.ifPresent(System.out::println); // 메소드 참조
        
    }
}
```

# Optional 클래스를 사용하면 if~else문을 대신할 수 있다.

```java
/** Optional 클래스를 사용하지 않아, if else문을 사용하는 경우 **/
class ContInfo {
    String phone; // null 일 수 있음
    String adrs; // null 일 수 있음

    public ContInfo(String ph, String ad) {
        phone = ph;
        adrs = ad;
    }

    public String getPhone() {return phone;}

    public String getAdrs() {return adrs;}
}

    public static void main(String[] args) {
        ContInfo ci = new ContInfo(null, "Republic of Korea");
        String phone;
        String addr;
        
        /** null인지 아닌지 확인하기 위한 if else문 **/
        if(ci.phone != null)
            phone = ci.getPhone();
        else
            phone = "There is no phone number";
        
        if(ci.adrs != null)
            addr = ci.getAdrs();
        else
            addr = "There is no address";
        System.out.println(phone);
        System.out.println(addr);
    }
```
## Optional 클래스 사용법 3.
- map
  - 기능을 수행한 값을 Optional 클래스에 감싸서 반환한다.
  - 즉, 
```java
public static void main(String[]args){
        Optional<String> os1 = Optional.of("Optional String");
        Optional<String> os2 = os1.map(s -> s.toUpperCase());
        System.out.println(os2.get());
        
        /** map은 이어서 호출이 가능하다. **/
        Optional<String> os3 = os1.map(s -> s.replace(' ', '_'))
                                  .map(s -> s.toLowerCase());
        
}
```

## Optional 클래스 사용법 4.
- orElse
  - 값이 없으면(null 이면) -> 안의 매개변수를 반환한다.
- empty
  - null 값을 가진 Optional 객체 생성
```java
public static void main(String[]args){
        Optional<String> empty = Optional.empty();
        Optional<String> os1 = Optional.of("Optional String");
        Optional<String> os2 = os1.map(s -> s.toUpperCase())
                                  .orElse("Empty");
         
}
```