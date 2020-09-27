package game2048;

import java.util.Scanner;

public class Impl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] v=View.getN();
		AfterEffect aft=new AfterEffect(v);
		aft.implChange(aft.Nozero(),false);//初始化；
		Effect effect=new Effect(v);
		System.out.println("初始矩阵：");
		View.outP();
		int ii=0;
		//char[] xchar= {'w','a','s','d'};
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("请输入：");
			char x = sc.next().charAt(0);
			//char x = xchar[(int)(Math.random()*xchar.length)];
			boolean b;
			if(x=='w') {
				b=effect.UpEffect();
			}
			else if(x=='a') {
				b=effect.LfEffect();
			}
			else if(x=='s') {
				b=effect.DnEffect();
			}
			else if(x=='d') {
				b=effect.RtEffect();
			}
			else if(x=='o') {
				System.out.println("手动游戏结束");
				System.out.println("您一共走的步数是"+ii);
				break;
			}
			else {
				System.out.println("输入有误，请重新输入");
				continue;
			}
			ii=b?ii:ii+1;
			if(aft.isOver(aft.Nozero())) {
				View.outP();
				System.out.println("游戏失败！");
				System.out.println("您一共走的步数是"+ii);
				break;
			}
			aft.implChange(aft.Nozero(),b);
			View.outP();	
			}
		}
		
		
	}



