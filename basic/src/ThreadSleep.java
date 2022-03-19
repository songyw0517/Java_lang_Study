public class ThreadSleep {
    public static void main(String[] args) {

        /*
        * Thread.sleep('파라미터') : 파라미터에 해당하는 만큼 sleep 한다.
        * 얘는 try/catch문을 사용해야한다.
        * 왜?
        *  */
        System.out.println("잔다");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("일어났다.");
    }
}
