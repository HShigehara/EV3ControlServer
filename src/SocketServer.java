/* 
 * SocketServer.java
 * サーバークラス．EV3からの通信をPC側で受け取る
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
	//変数
	static int port= 10000; //サーバー側の待受ポート番号
	static Socket socket; //ソケット
	static DataOutputStream dos; //データ出力ストリーム
	static DataInputStream dis; //データ入力ストリーム
    static InputStream Is; //入力ストリーム
    static OutputStream Os; //出力ストリーム
    static ServerSocket ss; //サーバーソケット

    static double velocity; //速度
    static double yaw; //ヨー角
    
    //メソッド
	public void ConnectServer(String arg[]) {
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
			
			//ここでファイルを読み込む
			readFile(); //ファイルを読み込むメソッドを呼び出す
			
			//ファイルから読み込んだデータをクライアントに送信する
			dos.writeDouble(velocity);
		}catch(Exception e) {
			System.out.println("Exception: " + e);
		}
	}
	
	//ファイル読み込み用のメソッド
	public void readFile(){
		try{
			System.out.println("Reading File..."); //ファイルの読み込みであることを表示
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