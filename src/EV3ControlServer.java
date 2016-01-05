/*
 * EV3ControlServer.java
 * EV3�𐧌䂷��N���C�A���g(PC)���̃��C���N���X�D
 */
//�C���|�[�g
import java.util.Timer;

//�N���X�̒�`
public class EV3ControlServer{
	//���C���֐�
    public static void main(String[] args){ //���C���֐�
	Timer t1 = new Timer(); //�^�C�}�[t1�̃C���X�^���X�𐶐�
	Timer t2 = new Timer(); //�^�C�}�[t2�̃C���X�^���X�𐶐�

	t1.schedule(new TimeSchedulingServer("First"), 1000, 100); //schedule���\�b�h���p��
	t2.scheduleAtFixedRate(new TimeSchedulingServer("Second"), 1000, 100); //scheduleAtFixdRate���\�b�h���p��

	try{ //�ʏ펞
	    Thread.sleep(5000); //5000[ms]�����҂��ē���
	} catch(InterruptedException e){ //��O������
	    System.out.println("error : " + e); //�G���[��\��
	}

	// �^�X�N�̒�~
	t1.cancel();
	t2.cancel();
    }
}