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
    	Timer timer = new Timer(); //タイマーtimerのインスタンスを生成

    	//連続処理を行う前にコネクションをはる
    	SocketServer ss = new SocketServer();
    	ss.MakeConnection(null);
    	
    	//(~, 開始, 増分)
    	timer.scheduleAtFixedRate(new RunServer(), 1000, 100); //scheduleAtFixdRateメソッド利用時
    	
    	try{ //通常時
    		Thread.sleep(60000); //[ms]だけ待つ
    	} catch(InterruptedException e){ //例外発生時
    		System.out.println("error : " + e); //エラーを表示
    	}
    	timer.cancel(); //60秒後に終了
    }
}