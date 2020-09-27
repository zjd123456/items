package game2048;

public class Effect {
	int[][] v;
	public Effect(int[][] v) {
		this.v=v;
	}
	public boolean UpEffect() {
		int[][] vclone = new int[v.length][v[0].length];
		for(int ii= 0;ii< v.length;ii++){
            vclone[ii] = v[ii].clone();
        }
		for(int i=0;i<v[0].length;i++) {//�������ÿһ��������
			boolean[] state=new boolean[v.length];//ÿһ�ж�Ӧ��״̬������Ϊfalse�����ô���Ԫ�غϲ����������ٱ仯��
			for(int j=0;j<v.length;j++) {
				//int kk;
				int[] row_v=find(i,j);
				int row=row_v[0],value=row_v[1];
				if(value==0) {
					break;
				}//�ҵ����治��0����������Ԫ�أ��������ֵΪ0��˵�����涼Ϊ��Ԫ�أ����������������0����ɽ�����һ��������
				if(row!=j) {
					v[j][i]=value;
					v[row][i]=0;
				}
				if(j!=0 && !state[j-1] && v[j-1][i]==v[j][i]) {
					v[j-1][i]*=2;
					state[j-1]=true;
					v[j][i]=0;
					int[] row_v1=find(i,j);
					int row1=row_v1[0],value1=row_v1[1];
					if(value1==0) {
						break;
					}
					else {
						v[j][i]=value1;
						v[row1][i]=0;
					}
				}
			}
		}
		for(int ii= 0;ii< v.length;ii++){
            for(int jj=0;jj<v[0].length;jj++) {
            	if(v[ii][jj]!=vclone[ii][jj]) {
            		return false;
            	}
            }
        }
		return true;
	}
	public boolean DnEffect() {
		this.upDownSwap();
		boolean b=this.UpEffect();
		this.upDownSwap();
		return b;
	}
	public boolean LfEffect() {
		this.leftSwap();
		boolean b=this.UpEffect();
		this.leftSwap();
		return b;
	}
	public boolean RtEffect() {
		this.leftSwap();
		this.upDownSwap();
		boolean b=this.UpEffect();
		this.upDownSwap();
		this.leftSwap();
		return b;
		
	}
	public int[] find(int i,int j) {
		int[] hh={0,0};
		
		for(int kem=j;kem<v.length;kem++) {
			if(v[kem][i]!=0) {
				hh[0]=kem;
				hh[1]=v[kem][i];
				break;
			}
		}
		return hh;
	}
	public void upDownSwap() {
		for(int up=0,dn=v.length-1;up<dn;up++,dn--) {
			for(int i=0;i<v[0].length;i++) {
				int xx=v[up][i];
				v[up][i]=v[dn][i];
				v[dn][i]=xx;
			}
		}
		
	}
	public void leftSwap(){
		for(int i=0;i<v.length;i++) {
			for(int j=i+1;j<v.length;j++) {
				int x=v[i][j];
				v[i][j]=v[j][i];
				v[j][i]=x;
			}
		}
	}

	/*public static void main(String[] args) {//��Ϊ������
		int[][] v= {{4,8,8,8},
					{4,8,8,4},
					{4,16,8,4},
					{4,16,8,2}};
		Effect e=new Effect(v);
		//e.LfEffect();
		
		e.RtEffect();
		for(int[] y : v) {
			for(int x : y) {
			System.out.print(x+" ");
			}
			System.out.println();
		}
		System.out.println("-----------------");
	}*/
	//�µ�Ч��ֻҪ���Ϸ�ת��ɺ���ת���ɣ����Ч��ֻҪ���ϵľ���ת��һ����ɺ���ת�û������ɣ��ҵ�Ч��ֻҪ�����еľ������ҷ�ת���ɡ�
}

