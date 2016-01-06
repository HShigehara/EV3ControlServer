/*
 * EV3ControlServer.java
 * EV3を制御するクライアント(PC)側のメインクラス．
 */
//インポート
import java.util.Timer;

//クラスの定義
public class EV3ControlServer{
	//メインメソッド
    public static void main(String[] args){ //メイン関数
    	Timer timer = new Timer(); //タイマーt2のインスタンスを生成

    	//連続処理を行う前にコネクションをはる
    	SocketServer ss = new SocketServer();
    	ss.MakeConnection(null);
    	
    	//(~, 開始, 増分)
    	timer.scheduleAtFixedRate(new RunServer("Time Scheduling Server"), 1000, 5000); //scheduleAtFixdRateメソッド利用時
    	
    	try{ //通常時
    		Thread.sleep(5000); //5000[ms]だけ待って動作を開始
    	} catch(InterruptedException e){ //例外発生時
    		System.out.println("error : " + e); //エラーを表示
    	}
    	
    	
    	// タスクの停止
    	//timer.cancel();
    }
}