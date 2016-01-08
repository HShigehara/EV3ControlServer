/* 
 * ReadFile.java
 * �t�@�C���ǂݍ��݃N���X�DKinect�����������t�@�C����ǂݍ���
 */
//�C���|�[�g
import java.io.*;

//�N���X�̒�`
public class ReadFile {
	//�ϐ�
    public double velocity; //���x
    public double yaw; //���[�p
    
    //���\�b�h
    public void ReadVelocityYawFile(String args[])
    {
    	//�t�@�C���ǂݍ��ݗp�̃��\�b�h
    		try{
    			System.out.println("Reading File..."); //�t�@�C���̓ǂݍ��݂ł��邱�Ƃ�\��
    			String file_name = "vyaw.dat";
    			FileReader fr = new FileReader(file_name);
    			StreamTokenizer st = new StreamTokenizer(fr);
    			//���x���擾(mm/frame)
    			st.nextToken();
    			velocity = st.nval;
    			//���[�p���擾(deg)
    			st.nextToken();
    			yaw = st.nval;
    			fr.close();
    		}catch(IOException e){
    			System.out.println("Exception: " + e);
    		}
    }
}
