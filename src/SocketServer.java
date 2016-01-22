/*!
 * @file SocketServer.java
 * @brief サーバークラス．EV3からの通信をPC側で受け取る
 * @date 2016.01.05
 * @author H.Shigehara
 */
//インポート
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//クラス定義
/*!
 * @class SocketServer
 * @brief ソケット通信のサーバー側クラス
 */
public class SocketServer {
	//変数
	static int port= 10000; //!<サーバー側の待受ポート番号
	static Socket socket; //!<ソケット
	static DataOutputStream dos; //!<データ出力ストリーム
	static DataInputStream dis; //!<データ入力ストリーム
    static InputStream Is; //!<入力ストリーム
    static OutputStream Os; //!<出力ストリーム
    static ServerSocket ss; //!<サーバーソケット
    
	//メソッド
    /*!
     *　@brief コネクションをはるメソッド
     */
    public void MakeConnection(String args[]){
    	try{
			System.out.println("Starting Server...");
			ss = new ServerSocket(port);
			socket = ss.accept(); //クライアントからの通信開始要求が来るまで待機
			System.out.println("IP:"+socket.getInetAddress()); //接続したIPアドレスを表示
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
     * @brief データを送信するメソッド
     */
	public void SendData(double velocity, double yaw) {
		try {
			//ファイルから読み込んだデータをクライアントに送信する
			dos.writeDouble(velocity); //速度を送信
			dos.flush();
			dos.writeDouble(yaw); //ヨー角を送信
			dos.flush();
		}catch(Exception e) {
			System.out.println("IOException: " + e);
			System.exit(-1);
		}
	}
}