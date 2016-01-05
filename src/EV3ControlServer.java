/*
 * EV3ControlServer.java
 * EV3�𐧌䂷��N���C�A���g(PC)���̃��C���N���X�D
 */
import java.util.Timer;

public class EV3ControlServer{
    public static void main(String[] args){
	Timer t1 = new Timer();
	Timer t2 = new Timer();

	t1.schedule(new TimeSchedulingServer("First"), 1000, 100);
	t2.scheduleAtFixedRate(new TimeSchedulingServer("Second"), 1000, 100);

	// 5000 [msec]��������
	try{
	    Thread.sleep(5000);
	} catch(InterruptedException e){
	    System.out.println("error : " + e);
	}

	// �^�X�N�̒�~
	t1.cancel();
	t2.cancel();

    }
}