class InstCnt{

    /********** instNum은 모든 InstCnt 객체가 공유한다. ************/
    static int instNum = 0;

    public InstCnt(){
        instNum++;
        System.out.println("인스턴스 생성 : "+instNum);
    }
    public int IncreaseInstCnt(){
        instNum++;
        return instNum;
    }
}
class AccdssInstCnt{
    // InstCnt의 '클래스변수' instNum에 접근하는 방법
    public AccdssInstCnt(){
        InstCnt.instNum++; // InstCnt 클래스 변수에 접근
        System.out.println("subInstCnt에서의 instNum 접근 = "+InstCnt.instNum);
    }
}
class StaticMethod{
    private int myNum = 0;
    static void showInt(int n){
        System.out.println(n);
    }
}



public class StaticEx {
    public static void main(String[] args) {
        InstCnt cnt1 = new InstCnt();
        System.out.println("cnt1.Increase = >" + cnt1.IncreaseInstCnt());
        InstCnt cnt2 = new InstCnt();
        InstCnt cnt3 = new InstCnt();
        AccdssInstCnt cnt4 = new AccdssInstCnt();
        StaticMethod.showInt(13); // static 메소드 실행
    }
}
