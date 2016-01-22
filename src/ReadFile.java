/*!
 * @file ReadFile.java
 * @brief �t�@�C���ǂݍ��݃N���X�DKinect�����������t�@�C����ǂݍ���
 * @date 2016.01.05
 * @author H.Shigehara
 */
//�C���|�[�g
import java.io.*;

/*!
 * @class ReadFile
 * @brief �t�@�C����ǂݍ��ރN���X
 */
public class ReadFile {
	//�ϐ�
    public double velocity; //!<���x
    public double yaw; //!<���[�p
    
    //���\�b�h
    /*!
     * @brief �t�@�C����ǂݍ��ރ��\�b�h
     * @param args[] String�^
     */
    public void ReadVelocityYawFile(String args[])
    {
    	//�t�@�C���ǂݍ��ݗp�̃��\�b�h
    		try{
    			System.out.println("Reading File..."); //�t�@�C���̓ǂݍ��݂ł��邱�Ƃ�\��
    			String file_name = "vyaw.dat"; //�ǂݍ��ރt�@�C����
    			FileReader fr = new FileReader(file_name); //�t�@�C�����[�_�[�𐶐�
    			StreamTokenizer st = new StreamTokenizer(fr); //�X�g���[�����擾����悤�ɐ���
    			//���x���擾(mm/frame)
    			st.nextToken(); //1��ڂ̗v�f���擾
    			velocity = st.nval; //���x�p�̕ϐ��ɕۑ�
    			//���[�p���擾(deg)
    			st.nextToken(); //2��ڂ̗v�f���擾
    			yaw = st.nval; //���[�p�p�̕ϐ��ɕۑ�
    			fr.close(); //�t�@�C�����[�_�[�����
    		}catch(IOException e){
    			System.out.println("Exception: " + e);
    		}
    }
}