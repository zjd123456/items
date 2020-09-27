package game2048;

public class View {
	static int num=4;
	static int[][] v=new int[num][num];
	public static int[][] getN() {
		return v;
	}
	static public void outP() {
		System.out.println("----------------------");
		for(int[] y : v) {
			for(int x : y) {
			if(x!=0) {System.out.printf("%-5d",x);
				}
			else {
				System.out.printf("%-5c",' ');
				}	
			}
			System.out.println();	
		}
		System.out.println("----------------------");
	}
}

