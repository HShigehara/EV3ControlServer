/*
 * TimeSchedulingServer.java
 * �T�[�o�[(PC)���̎��Ԃ��X�P�W���[�����O����N���X�D
 */
//�C���|�[�g
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

//�N���X�̒�`
public class RunServer extends TimerTask{
	//�ϐ�
    private long timeStart;
    private String id;

    //�C���X�^���X����
	static SocketServer ss = new SocketServer(); //�C���X�^���X�𐶐�
	static ReadFile rf = new ReadFile(); //static�Ő錾���Ă������ƂŁC���̃N���X�ł������l���擾���邱�Ƃ��ł���
	
    //���\�b�h
    //�R���X�g���N�^
    RunServer(String arg){
	timeStart = System.nanoTime();
	id = arg;
    }

    //run()�D�����̗���������ɏ���
    public void run(){
	long timeNow = System.nanoTime() - timeStart;
	System.out.println(id +  " : " + TimeUnit.MILLISECONDS.convert(timeNow, TimeUnit.NANOSECONDS));
	

	//�t�@�C����ǂݍ���
	rf.ReadVelocityYawFile(null);
	System.out.println(rf.velocity + " run " + rf.yaw);

	//�\�P�b�g�ʐM
	ss.ConnectServer(rf.velocity, rf.yaw); //�\�P�b�g�ڑ�
	
    }
}