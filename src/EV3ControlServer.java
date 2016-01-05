/*
 * EV3ControlServer.java
 * EV3を制御するクライアント(PC)側のメインクラス．
 */
//インポート
import java.util.Timer;

//クラスの定義
public class EV3ControlServer{
	//メイン関数
    public static void main(String[] args){ //メイン関数
	Timer t1 = new Timer(); //タイマーt1のインスタンスを生成
	Timer t2 = new Timer(); //タイマーt2のインスタンスを生成

	t1.schedule(new TimeSchedulingServer("First"), 1000, 100); //scheduleメソッド利用時
	t2.scheduleAtFixedRate(new TimeSchedulingServer("Second"), 1000, 100); //scheduleAtFixdRateメソッド利用時

	try{ //通常時
	    Thread.sleep(5000); //5000[ms]だけ待って動作
	} catch(InterruptedException e){ //例外発生時
	    System.out.println("error : " + e); //エラーを表示
	}

	// タスクの停止
	t1.cancel();
	t2.cancel();
    }
}