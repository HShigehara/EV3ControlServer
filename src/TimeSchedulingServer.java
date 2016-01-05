/*
 * TimeSchedulingServer.java
 * サーバー(PC)側の時間をスケジューリングするクラス．
 */
//インポート
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

//クラスの定義
public class TimeSchedulingServer extends TimerTask{
	//変数
    private long timeStart;
    private String id;

    //メソッド
    TimeSchedulingServer(String arg){
	timeStart = System.nanoTime();
	id = arg;
    }

    public void run(){
	long timeNow = System.nanoTime() - timeStart;
	System.out.println(id +  " : " + TimeUnit.MILLISECONDS.convert(timeNow, TimeUnit.NANOSECONDS));
    }
}