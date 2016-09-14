import java.util.Scanner;

public class Miain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scannerA = new Scanner(System.in);
		Double A=scannerA.nextDouble();
		Scanner scannerB = new Scanner(System.in);
		Double B=scannerB.nextDouble();
		Scanner scannerK = new Scanner(System.in);
		int K=scannerK.nextInt();
		
		double Aoki=0.5;
		double Takahashi=0.0;
		int count=0,flag=0;;
		while(count<K){
			if((B+Aoki)<(A+Takahashi)){
				Aoki+=B;
				flag=0;
			}else{
				Takahashi+=A;
				flag=1;
			}
			count++;
		}
		if(flag==0){
			System.out.println("Aoki");
		}
		if(flag==1){
			System.out.println("Takahashi");
		}
	}

}
