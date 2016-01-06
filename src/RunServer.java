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
	
	//�\�P�b�g�ʐM
	SocketServer socket_server = new SocketServer(); //�C���X�^���X�𐶐�
	socket_server.ConnectServer(null); //�\�P�b�g�ڑ�
    }
}