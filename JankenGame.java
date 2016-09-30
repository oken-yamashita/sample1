import java.util.Random;
import java.io.*;


public class JankenGame {

	public static void main(String[] args) {

		String[] who = {"自分","相手"};
		int player1 = 0;
		int player2 = 0;

		//グー：0 チョキ: 1 パー: 2
		player1 = InputGCP(who[0]); //変数player1には 0,1,2のいずれかが代入される
		player2 = makeRandom(who[1]); //変数player2には 0,1,2のいずれかが代入される
		Judge(player1,player2);
	}

	//自分がグー、チョキ、パーを選択して入力するメソッド
	public static int InputGCP(String who){
		int input;
		input = 0;

		System.out.println("じゃんけんゲームを開始します");
		System.out.println("グー、チョキ、パーを選択してください(数値を選択)");
		System.out.println("グー：0　チョキ：1　パー：2");

		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		try{
			String buf = br.readLine(); //インプットされた文字(0,1,2)を変数bufに代入
			input = Integer.parseInt(buf); //String型の変数bufをint型に変換して変数inputに代入
		}catch(Exception e){
			//エラー処理
			System.out.println("予期せぬ入力がされました。もう一度やり直してください。");
		}

		if(input == 0 || input == 1 || input == 2 ){
			Print(who,input);
		}
		else{
			System.out.println("0～2の範囲で整数値を入力してください。");
			System.exit(0); //強制終了
		}
		return input;
	}

	//乱数を生成して相手がグー、チョキ、パーのどれをだすのか決定するメソッド
	public static int makeRandom(String who){
		Random r = new Random();
		int r_num = r.nextInt(3); //変数r_numには0,1,2のいずれかの値が代入される
		Print(who,r_num);
		return r_num;
	}

	//自分と相手がなにをだしたのかプリントするメソッド
	public static void Print(String who,int input){
		String[] GCP = {"グー","チョキ","パー"};
		System.out.println(who + "は" + GCP[input] + "をだしました。");
	}

	//どちらが勝ったのか判定するメソッド
	public static void Judge(int x,int y){
		if( (x==0 && y==1) || (x==1 && y==2) || (x==2 && y==0)){
			System.out.println("あなたの勝ちです。");
		}
		else if( (x==0 && y==2) || (x==1 && y==0) || (x==2 && y==1)){
			System.out.println("あなたの負けです。");
		}
		else{
			System.out.println("あいこです。");
		}
	}

}
