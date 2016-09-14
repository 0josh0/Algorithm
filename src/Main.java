import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scannerS = new Scanner(System.in);
		String S=scannerS.next();
		Scanner scannerT = new Scanner(System.in);
		String T=scannerT.next();
		//System.out.println(S+"  "+T);
		
		if(S.length()!=T.length()){
			System.out.println("Impossible");
			return;
		}else{
			if(S.equals(T)){
				System.out.println("Possible");
				return;
			}else{
				//int count=0;
				Map<Character,Character> map = new HashMap<Character,Character>();
				for(int i=0;i<S.length();i++){
					//if(count>2) return "Impossible";
					char s=S.charAt(i);
					char t=T.charAt(i);
					if(s!=t){
						
						if(!map.containsKey(s)){
							map.put(S.charAt(i), T.charAt(i));
						}else{
							if(map.get(s)!=t){
								System.out.println("Impossible");
								return;
							}
							
						}
						if(map.size()>2){
							System.out.println("Impossible");
							return;
						}
						
					}
				}
				System.out.println("Possible");
				return;
			}
		}
	}


}
