/*!
 * @file ReadFile.java
 * @brief ファイル読み込みクラス．Kinectが生成したファイルを読み込む
 * @date 2016.01.05
 * @author H.Shigehara
 */
//インポート
import java.io.*;

/*!
 * @class ReadFile
 * @brief ファイルを読み込むクラス
 */
public class ReadFile {
	//変数
    public double velocity; //!<速度
    public double yaw; //!<ヨー角
    
    //メソッド
    /*!
     * @brief ファイルを読み込むメソッド
     * @param args[] String型
     */
    public void ReadVelocityYawFile(String args[])
    {
    	//ファイル読み込み用のメソッド
    		try{
    			System.out.println("Reading File..."); //ファイルの読み込みであることを表示
    			String file_name = "vyaw.dat"; //読み込むファイル名
    			FileReader fr = new FileReader(file_name); //ファイルリーダーを生成
    			StreamTokenizer st = new StreamTokenizer(fr); //ストリームを取得するように生成
    			//速度を取得(mm/frame)
    			st.nextToken(); //1列目の要素を取得
    			velocity = st.nval; //速度用の変数に保存
    			//ヨー角を取得(deg)
    			st.nextToken(); //2列目の要素を取得
    			yaw = st.nval; //ヨー角用の変数に保存
    			fr.close(); //ファイルリーダーを閉じる
    		}catch(IOException e){
    			System.out.println("Exception: " + e);
    		}
    }
}