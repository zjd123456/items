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
		for(int i=0;i<v[0].length;i++) {//这是针对每一列来操作
			boolean[] state=new boolean[v.length];//每一列对应的状态矩阵，若为false则代表该处的元素合并过，不可再变化了
			for(int j=0;j<v.length;j++) {
				//int kk;
				int[] row_v=find(i,j);
				int row=row_v[0],value=row_v[1];
				if(value==0) {
					break;
				}//找到下面不是0的离得最近的元素，如果返回值为0，说明下面都为零元素，则可以跳过，若非0，则可进行下一步操作；
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

	/*public static void main(String[] args) {//作为测试用
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
	//下的效果只要把上翻转完成后再转即可，左的效果只要把上的矩阵转置一下完成后再转置回来即可，右的效果只要把左中的矩阵向右翻转即可。
}

