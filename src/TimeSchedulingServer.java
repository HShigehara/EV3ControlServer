/*
 * TimeSchedulingServer.java
 * �T�[�o�[(PC)���̎��Ԃ��X�P�W���[�����O����N���X�D
 */
//�C���|�[�g
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

//�N���X�̒�`
public class TimeSchedulingServer extends TimerTask{
	//�ϐ�
    private long timeStart;
    private String id;

    //���\�b�h
    TimeSchedulingServer(String arg){
	timeStart = System.nanoTime();
	id = arg;
    }

    public void run(){
	long timeNow = System.nanoTime() - timeStart;
	System.out.println(id +  " : " + TimeUnit.MILLISECONDS.convert(timeNow, TimeUnit.NANOSECONDS));
    }
}