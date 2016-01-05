/*
  TimerTask�����삳�����
  �ȉ��̂悤�ɂ���ƁAt1, t2 ������œ��삷��
  
  schedule �͊��荞�݊Ԋu������ɒx�����Ă���
  scheduleAtFixedRate �͓����̊��荞�݊Ԋu����낤�Ƃ���
  ���R��҂𗘗p���܂��傤�B
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