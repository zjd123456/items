package game2048;

import java.util.Scanner;

public class Impl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] v=View.getN();
		AfterEffect aft=new AfterEffect(v);
		aft.implChange(aft.Nozero(),false);//��ʼ����
		Effect effect=new Effect(v);
		System.out.println("��ʼ����");
		View.outP();
		int ii=0;
		//char[] xchar= {'w','a','s','d'};
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("�����룺");
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
				System.out.println("�ֶ���Ϸ����");
				System.out.println("��һ���ߵĲ�����"+ii);
				break;
			}
			else {
				System.out.println("������������������");
				continue;
			}
			ii=b?ii:ii+1;
			if(aft.isOver(aft.Nozero())) {
				View.outP();
				System.out.println("��Ϸʧ�ܣ�");
				System.out.println("��һ���ߵĲ�����"+ii);
				break;
			}
			aft.implChange(aft.Nozero(),b);
			View.outP();	
			}
		}
		
		
	}



