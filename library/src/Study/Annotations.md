# Annotations (어노테이션 @)
## @Override
```java
interface Viewable{
    public void showIt(String str);
}
class Viewer implements Viewable{
    
    @Override
    public void showIt(String str){
        System.out.println(str);
    }
}
```
- @Override는 컴파일러에게 아래의 메소드를 오버라이딩하겠음을 알린다.
- 만약 개발자가 @Override 선언을 했음에도 불구하고 오버라이딩이 아닌 오버로딩을 하는 등의 실수를 한다면
- 컴파일러는 이를 찾아 컴파일 에러를 발생시킨다.


## @Deprecated
```java
interface Viewable{
    @Deprecated
    public void showIt(String str);
    
    public void brShowIt(String str);
}
class Viewer implements Viewable{
    
    // 컴파일러에서 경고를 준다.
    @Override
    public void showIt(String str){
        System.out.println(str);
    }
    
    @Override
    public void brShowIt(String str){
        System.out.println('['+str+']');
    }
}
```
- @Deprecated는 하위 호환성을 위해 제공해주는 것임을 알린다.
- 만약 java 버전 5에 a라는 기능이 있고, java 버전 8에 기존의 a를 개선한 a2코드가 있다고 가정하면
- java 버전 5의 a에 @Deprecated를 선언함으로써, 개선된 코드가 있음을 알릴 수 있다. 



## @SuppressWarnings
```java
interface Viewable{
    @Deprecated
    public void showIt(String str);
    
    public void brShowIt(String str);
}
class Viewer implements Viewable{
    
    // 컴파일러에서 경고를 줘야하지만
    // @SuppressWarnings를 선언함으로써 경고를 무시한다.
    @Override
    @SuppressWarnings("deprecation")
    public void showIt(String str){
        System.out.println(str);
    }
    
    @Override
    public void brShowIt(String str){
        System.out.println('['+str+']');
    }
}
```
- @SuppressWarnings( 무시할 경고 ) : 경고를 무시한다.

# 함수형 인터페이스와 어노테이션
## @FuntionalInterface
- 컴파일러보고, 함수형 인터페이스 조건을 갖추었는지 검사하라고 요청하는 것이다.
```java
/** 다음 인터페이스에 대해
 *  함수형 인터페이스 조건(추상 메소드가 하나인 인터페이스)을 갖추었는지 확인해줘
 *  **/
@FunctionalInterface
interface Calculate{
    int cal(int a, int b);
}
```