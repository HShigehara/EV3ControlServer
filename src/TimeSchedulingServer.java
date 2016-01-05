import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class TimeSchedulingServer extends TimerTask{
    private long timeStart;
    private String id;

    TimeSchedulingServer(String arg){
	timeStart = System.nanoTime();
	id = arg;
    }

    public void run(){
	long timeNow = System.nanoTime() - timeStart;

	System.out.println(id +  " : " + TimeUnit.MILLISECONDS.convert(timeNow, TimeUnit.NANOSECONDS));
    }
}