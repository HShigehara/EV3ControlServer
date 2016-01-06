/*
 * TimeSchedulingServer.java
 * サーバー(PC)側の時間をスケジューリングするクラス．
 */
//インポート
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

//クラスの定義
public class RunServer extends TimerTask{
	//変数
    private long timeStart;
    private String id;

    //インスタンス生成
	static SocketServer ss = new SocketServer(); //インスタンスを生成
	static ReadFile rf = new ReadFile(); //staticで宣言しておくことで，他のクラスでも同じ値を取得することができる
	
    //メソッド
    //コンストラクタ
    RunServer(String arg){
	timeStart = System.nanoTime();
	id = arg;
    }

    //run()．処理の流れをここに書く
    public void run(){
	long timeNow = System.nanoTime() - timeStart;
	System.out.println(id +  " : " + TimeUnit.MILLISECONDS.convert(timeNow, TimeUnit.NANOSECONDS));
	

	//ファイルを読み込む
	rf.ReadVelocityYawFile(null);
	System.out.println(rf.velocity + " run " + rf.yaw);

	//ソケット通信
	ss.ConnectServer(rf.velocity, rf.yaw); //ソケット接続
	
    }
}