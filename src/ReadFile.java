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
    			st.nextToken();
    			velocity = st.nval;
    			st.nextToken();
    			yaw = st.nval;
    			//System.out.println("v = " + velocity + " Yaw = " + yaw);
    			fr.close();
    		}catch(IOException e){
    			System.out.println("Exception: " + e);
    		}
    }
}
