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
    	Timer timer = new Timer(); //�^�C�}�[timer�̃C���X�^���X�𐶐�

    	//�A���������s���O�ɃR�l�N�V�������͂�
    	SocketServer ss = new SocketServer();
    	ss.MakeConnection(null);
    	
    	//(~, �J�n, ����)
    	timer.scheduleAtFixedRate(new RunServer(), 1000, 100); //scheduleAtFixdRate���\�b�h���p��
    	
    	try{ //�ʏ펞
    		Thread.sleep(60000); //[ms]�����҂�
    	} catch(InterruptedException e){ //��O������
    		System.out.println("error : " + e); //�G���[��\��
    	}
    	timer.cancel(); //60�b��ɏI��
    }
}