/* 
 * SocketServer.java
 * �T�[�o�[�N���X�DEV3����̒ʐM��PC���Ŏ󂯎��
 */
import java.io.*;
//import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
//import java.io.File;
import java.io.IOException;
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

    static double velocity; //���x
    static double yaw; //���[�p
    
    //���\�b�h
	public void ConnectServer(String arg[]) {
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
			
			//�����Ńt�@�C����ǂݍ���
			readFile(); //�t�@�C����ǂݍ��ރ��\�b�h���Ăяo��
			
			//�t�@�C������ǂݍ��񂾃f�[�^���N���C�A���g�ɑ��M����
			dos.writeDouble(velocity);
		}catch(Exception e) {
			System.out.println("Exception: " + e);
		}
	}
	
	//�t�@�C���ǂݍ��ݗp�̃��\�b�h
	public void readFile(){
		try{
			System.out.println("Reading File..."); //�t�@�C���̓ǂݍ��݂ł��邱�Ƃ�\��
			String file_name = "vyaw.dat";
			FileReader fr = new FileReader(file_name);
			StreamTokenizer st = new StreamTokenizer(fr);
			st.nextToken();
			velocity = st.nval;
			st.nextToken();
			yaw = st.nval;
			System.out.println("v = " + velocity + " Yaw = " + yaw);
			fr.close();
		}catch(IOException e){
			System.out.println("Exception: " + e);
		}
	}
}