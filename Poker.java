import java.util.*;

public class Poker{
	

	public static int compare(Hand hand1,Hand hand2){


		return 0;
	}

	public static void main(String[] args){


		Scanner sc = new Scanner(System.in);
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		String[] keys = {"1","2","3","4","5","6","7","8","9","T","J","Q","K","A"};
		int[] values = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};

		HashMap<String,Integer> map2 = new HashMap<String,Integer>();
		String[] keys2 = {"H","D","S","C"};
		int[] values2 = {1,2,3,4};

		for(int i=0;i<keys.length;i++){

			map.put(keys[i],values[i]);
			map2.put(keys2[i],values2[i]);
		}
		int p1won = 0;
		String line;
		while((line = sc.nextLine()) != null ){

			h1v = new int[5];
			h1s = new int[5];
			h2v = new int[5];
			h2s = new int[5];

			String[] splitted = line.trim().split(" ");
			for(int i=0;i<5;i++){

				char[] schar = splitted[i].toCharArray();
				String val = "" +schar[0];
				String suit = "" +schar[1];

				int value = map.get(val);
				int fsuit = map2.get(suit);
				h1v[i] = value;
				h1s[i] = fsuit;

				char[] other = splitted[i+5].toCharArray();
				String val2 = "" +other[0];
				String suit2 = "" +other[1];

				int value2 = map.get(val2);
				int fsuit2 = map2.get(suit2);
				h2v[i] = value2;
				h2s[i] = fsuit2;



			}
			Hand h1 = new Hand(h1v,h1s);
			Hand h2 = new Hand(h2v,h2s);

			if(compare(h1,h2)==1){
				p1won++;
			}


		}
		System.out.println(""+p1won);
	}


}

class Hand{

	public int[] values;
	public int[] suits;

	public boolean checkFlush(){
		int last = suits[0];
		for(int i=1;i<suits;i++){
			if(suits[i]!=last){
				return false;
			}
		}
		return true;

	}

	public Hand(int[] v,int[] s){

		this.values = v;
		this.suits = s;
	}
}
