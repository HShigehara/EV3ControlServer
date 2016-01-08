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

    //インスタンス生成
	static SocketServer ss = new SocketServer(); //インスタンスを生成
	static ReadFile rf = new ReadFile(); //staticで宣言しておくことで，他のクラスでも同じ値を取得することができる
	
    //メソッド
    //コンストラクタ
    RunServer(){
	timeStart = System.nanoTime();
    }

    //run()．処理の流れをここに書く
    public void run(){
	long timeNow = System.nanoTime() - timeStart;
	System.out.println("Time : " + TimeUnit.MILLISECONDS.convert(timeNow, TimeUnit.NANOSECONDS));
	
	//ファイルを読み込む
	rf.ReadVelocityYawFile(null);
	System.out.println("Velocity => " + rf.velocity + ", Yaw => " + rf.yaw);

	//ソケット通信
	ss.SendData(rf.velocity, rf.yaw); //ソケット接続
	
    }
}