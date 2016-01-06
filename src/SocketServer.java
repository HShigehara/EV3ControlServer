/* 
 * SocketServer.java
 * サーバークラス．EV3からの通信をPC側で受け取る
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
	//変数
	static int port= 10000; //サーバー側の待受ポート番号
	static Socket socket; //ソケット
	static DataOutputStream dos; //データ出力ストリーム
	static DataInputStream dis; //データ入力ストリーム
    static InputStream Is; //入力ストリーム
    static OutputStream Os; //出力ストリーム
    static ServerSocket ss; //サーバーソケット
    
	//static ReadFile rf; //ファイル読み込みクラス

	//メソッド
	public void ConnectServer(double velocity, double yaw) {
		try {
			System.out.println("Server Starting...");
			ss = new ServerSocket(port);
			socket = ss.accept(); //クライアントからの通信開始要求が来るまで待機
			System.out.println("IP:"+socket.getInetAddress()); //接続したIPアドレスを表示
			Is = socket.getInputStream();
			dis = new DataInputStream(Is);
			Os =socket.getOutputStream();
			dos = new DataOutputStream(Os);
			System.out.println("Socket Connected!");
			
			//ファイルを読み込む
			//rf = new ReadFile(); //インスタンスを生成
			//rf.ReadVelocityYawFile(null); //ファイルを読み込むメソッドを呼び出す
			//System.out.println("v = " + rf.velocity + " yaw = " + rf.yaw); //確認用に表示
			
			//ファイルから読み込んだデータをクライアントに送信する
			dos.writeDouble(velocity); //速度を送信
			dos.flush();
			dos.writeDouble(yaw);
			dos.flush();
			dos.close();
			//dos.writeDouble(rf.yaw); //ヨー角を送信
			
		}catch(Exception e) {
			System.out.println("Exception: " + e);
		}
	}

}