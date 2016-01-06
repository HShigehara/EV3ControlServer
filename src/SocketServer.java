/* 
 * SocketServer.java
 * �T�[�o�[�N���X�DEV3����̒ʐM��PC���Ŏ󂯎��
 */
//import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
//import java.io.File;
//import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
	//�ϐ�
	static int port= 10000; //�T�[�o�[���̑Ҏ�|�[�g�ԍ�
	static Socket socket; //�\�P�b�g
	static DataOutputStream dos; //�f�[�^�o�̓X�g���[��
	static DataInputStream dis; //�f�[�^���̓X�g���[��
    static InputStream Is; //���̓X�g���[��
    static OutputStream Os; //�o�̓X�g���[��
    static ServerSocket ss; //�T�[�o�[�\�P�b�g
    
	//static ReadFile rf; //�t�@�C���ǂݍ��݃N���X

	//���\�b�h
	public void ConnectServer(double velocity, double yaw) {
		try {
			System.out.println("Server Starting...");
			ss = new ServerSocket(port);
			socket = ss.accept(); //�N���C�A���g����̒ʐM�J�n�v��������܂őҋ@
			System.out.println("IP:"+socket.getInetAddress()); //�ڑ�����IP�A�h���X��\��
			Is = socket.getInputStream();
			dis = new DataInputStream(Is);
			Os =socket.getOutputStream();
			dos = new DataOutputStream(Os);
			System.out.println("Socket Connected!");
			
			//�t�@�C����ǂݍ���
			//rf = new ReadFile(); //�C���X�^���X�𐶐�
			//rf.ReadVelocityYawFile(null); //�t�@�C����ǂݍ��ރ��\�b�h���Ăяo��
			//System.out.println("v = " + rf.velocity + " yaw = " + rf.yaw); //�m�F�p�ɕ\��
			
			//�t�@�C������ǂݍ��񂾃f�[�^���N���C�A���g�ɑ��M����
			dos.writeDouble(velocity); //���x�𑗐M
			dos.flush();
			dos.writeDouble(yaw);
			dos.flush();
			dos.close();
			//dos.writeDouble(rf.yaw); //���[�p�𑗐M
			
		}catch(Exception e) {
			System.out.println("Exception: " + e);
		}
	}

}