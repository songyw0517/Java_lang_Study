/*************
 * 캡슐화가 무너진 예
 * 
 * 가정) 코감기는 콧물, 재채기, 코 막힘을 늘 동반한다.
 *
 *
 * ****************/
class SinivelCap{
    public void take(){
        System.out.println("콧물이 싹~ 납니다.");
    }
}
class SneezeCap{
    public void take(){
        System.out.println("재채기가 멎습니다.");
    }
}
class SnuffleCap{
    public void take(){
        System.out.println("코가 뻥 뚤립니다.");
    }
}
class ColdPatient{
    public void takeSinivelCap(SinivelCap cap){cap.take();}
    public void takeSneezeCap(SneezeCap cap){cap.take();}
    public void takeSnuffleCap(SnuffleCap cap){cap.take();}
}
public class EncapsulationWrong {
    public static void main(String[] args) {
        ColdPatient sufferer = new ColdPatient();
        sufferer.takeSinivelCap(new SinivelCap());
        sufferer.takeSneezeCap(new SneezeCap());
        sufferer.takeSnuffleCap(new SnuffleCap());
    }


}
