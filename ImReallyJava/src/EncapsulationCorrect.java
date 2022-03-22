/**********************
 * Correct
 *
 * 코드상에서 알아야할 것이 ColdPatient, SinusCap으로 줄어든다.
 *
 * **********************/

class SinusCap{
    // 캡슐화
    public void sniTake(){
        System.out.println("콧물이 싹~ 납니다.");
    }
    public void sneTake(){
        System.out.println("재채기가 멎습니다.");
    }
    public void snuTake(){
        System.out.println("코가 뻥 뚫립니다.");

    }
    public void take(){
        sniTake();
        sneTake();
        snuTake();
    }
}
class ColdPatientC{
    void takeSinus(SinusCap cap){
        cap.take();
    }
}
public class EncapsulationCorrect {
    public static void main(String[] args) {
        ColdPatientC suf = new ColdPatientC();
        suf.takeSinus(new SinusCap());
    }


}
