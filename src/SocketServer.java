/*!
 * @file SocketServer.java
 * @brief �T�[�o�[�N���X�DEV3����̒ʐM��PC���Ŏ󂯎��
 * @date 2016.01.05
 * @author H.Shigehara
 */
//�C���|�[�g
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//�N���X��`
/*!
 * @class SocketServer
 * @brief �\�P�b�g�ʐM�̃T�[�o�[���N���X
 */
public class SocketServer {
	//�ϐ�
	static int port= 10000; //!<�T�[�o�[���̑Ҏ�|�[�g�ԍ�
	static Socket socket; //!<�\�P�b�g
	static DataOutputStream dos; //!<�f�[�^�o�̓X�g���[��
	static DataInputStream dis; //!<�f�[�^���̓X�g���[��
    static InputStream Is; //!<���̓X�g���[��
    static OutputStream Os; //!<�o�̓X�g���[��
    static ServerSocket ss; //!<�T�[�o�[�\�P�b�g
    
	//���\�b�h
    /*!
     *�@@brief �R�l�N�V�������͂郁�\�b�h
     */
    public void MakeConnection(String args[]){
    	try{
			System.out.println("Starting Server...");
			ss = new ServerSocket(port);
			socket = ss.accept(); //�N���C�A���g����̒ʐM�J�n�v��������܂őҋ@
			System.out.println("IP:"+socket.getInetAddress()); //�ڑ�����IP�A�h���X��\��
			Is = socket.getInputStream();
			dis = new DataInputStream(Is);
			Os =socket.getOutputStream();
			dos = new DataOutputStream(Os);
			System.out.println("Socket Connected!");
    	}catch(Exception e){
    		System.out.println(e);
    	}
    }
    
    /*!
     * @brief �f�[�^�𑗐M���郁�\�b�h
     */
	public void SendData(double velocity, double yaw) {
		try {
			//�t�@�C������ǂݍ��񂾃f�[�^���N���C�A���g�ɑ��M����
			dos.writeDouble(velocity); //���x�𑗐M
			dos.flush();
			dos.writeDouble(yaw); //���[�p�𑗐M
			dos.flush();
		}catch(Exception e) {
			System.out.println("IOException: " + e);
			System.exit(-1);
		}
	}
}