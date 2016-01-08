/* 
 * ReadFile.java
 * ファイル読み込みクラス．Kinectが生成したファイルを読み込む
 */
//インポート
import java.io.*;

//クラスの定義
public class ReadFile {
	//変数
    public double velocity; //速度
    public double yaw; //ヨー角
    
    //メソッド
    public void ReadVelocityYawFile(String args[])
    {
    	//ファイル読み込み用のメソッド
    		try{
    			System.out.println("Reading File..."); //ファイルの読み込みであることを表示
    			String file_name = "vyaw.dat";
    			FileReader fr = new FileReader(file_name);
    			StreamTokenizer st = new StreamTokenizer(fr);
    			//速度を取得(mm/frame)
    			st.nextToken();
    			velocity = st.nval;
    			//ヨー角を取得(deg)
    			st.nextToken();
    			yaw = st.nval;
    			fr.close();
    		}catch(IOException e){
    			System.out.println("Exception: " + e);
    		}
    }
}
