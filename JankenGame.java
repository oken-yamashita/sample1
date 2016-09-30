import java.util.Random;
import java.io.*;


public class JankenGame {

	public static void main(String[] args) {

		String[] who = {"����","����"};
		int player1 = 0;
		int player2 = 0;

		//�O�[�F0 �`���L: 1 �p�[: 2
		player1 = InputGCP(who[0]); //�ϐ�player1�ɂ� 0,1,2�̂����ꂩ����������
		player2 = makeRandom(who[1]); //�ϐ�player2�ɂ� 0,1,2�̂����ꂩ����������
		Judge(player1,player2);
	}

	//�������O�[�A�`���L�A�p�[��I�����ē��͂��郁�\�b�h
	public static int InputGCP(String who){
		int input;
		input = 0;

		System.out.println("����񂯂�Q�[�����J�n���܂�");
		System.out.println("�O�[�A�`���L�A�p�[��I�����Ă�������(���l��I��)");
		System.out.println("�O�[�F0�@�`���L�F1�@�p�[�F2");

		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		try{
			String buf = br.readLine(); //�C���v�b�g���ꂽ����(0,1,2)��ϐ�buf�ɑ��
			input = Integer.parseInt(buf); //String�^�̕ϐ�buf��int�^�ɕϊ����ĕϐ�input�ɑ��
		}catch(Exception e){
			//�G���[����
			System.out.println("�\�����ʓ��͂�����܂����B������x��蒼���Ă��������B");
		}

		if(input == 0 || input == 1 || input == 2 ){
			Print(who,input);
		}
		else{
			System.out.println("0�`2�͈̔͂Ő����l����͂��Ă��������B");
			System.exit(0); //�����I��
		}
		return input;
	}

	//�����𐶐����đ��肪�O�[�A�`���L�A�p�[�̂ǂ�������̂����肷�郁�\�b�h
	public static int makeRandom(String who){
		Random r = new Random();
		int r_num = r.nextInt(3); //�ϐ�r_num�ɂ�0,1,2�̂����ꂩ�̒l����������
		Print(who,r_num);
		return r_num;
	}

	//�����Ƒ��肪�Ȃɂ��������̂��v�����g���郁�\�b�h
	public static void Print(String who,int input){
		String[] GCP = {"�O�[","�`���L","�p�["};
		System.out.println(who + "��" + GCP[input] + "�������܂����B");
	}

	//�ǂ��炪�������̂����肷�郁�\�b�h
	public static void Judge(int x,int y){
		if( (x==0 && y==1) || (x==1 && y==2) || (x==2 && y==0)){
			System.out.println("���Ȃ��̏����ł��B");
		}
		else if( (x==0 && y==2) || (x==1 && y==0) || (x==2 && y==1)){
			System.out.println("���Ȃ��̕����ł��B");
		}
		else{
			System.out.println("�������ł��B");
		}
	}

}
