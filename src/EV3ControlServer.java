/*
 * EV3ControlServer.java
 * EV3�𐧌䂷��N���C�A���g(PC)���̃��C���N���X�D
 */
//�C���|�[�g
import java.util.Timer;

//�N���X�̒�`
public class EV3ControlServer{
	//���C�����\�b�h
    public static void main(String[] args){ //���C���֐�
    	Timer timer = new Timer(); //�^�C�}�[t2�̃C���X�^���X�𐶐�

    	//�A���������s���O�ɃR�l�N�V�������͂�
    	SocketServer ss = new SocketServer();
    	ss.MakeConnection(null);
    	
    	//(~, �J�n, ����)
    	timer.scheduleAtFixedRate(new RunServer("Time Scheduling Server"), 1000, 5000); //scheduleAtFixdRate���\�b�h���p��
    	
    	try{ //�ʏ펞
    		Thread.sleep(5000); //5000[ms]�����҂��ē�����J�n
    	} catch(InterruptedException e){ //��O������
    		System.out.println("error : " + e); //�G���[��\��
    	}
    	
    	
    	// �^�X�N�̒�~
    	//timer.cancel();
    }
}