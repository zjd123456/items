package game2048;

import java.util.HashMap;
//import java.util.HashSet;

public class AfterEffect {
	int[][] v;
	public AfterEffect(int[][] v) {
		this.v=v;
	}
	public HashMap<Integer,Integer[]> Nozero() {
		HashMap<Integer,Integer[]> nozero=new HashMap<>();
		int kk=0;
		for(int i=0;i<v.length;i++) {
			for(int j=0;j<v[0].length;j++) {
				if(v[i][j]==0) {
					Integer[] insz=new Integer[2];
					kk++;
					insz[0]=i;insz[1]=j;
					nozero.put(kk,insz);
				}
			}
		}
		return nozero;
	}
	public boolean isOver(HashMap<Integer,Integer[]> x) {
			boolean ov=false;
			if(x.isEmpty()) {
				int[][] vw = new int[v.length][v[0].length];
				int[][] va = new int[v.length][v[0].length];
				int[][] vs = new int[v.length][v[0].length];
				int[][] vd = new int[v.length][v[0].length];
				for(int ii= 0;ii< v.length;ii++){
		            vw[ii] = v[ii].clone();
		            va[ii] = v[ii].clone();
		            vs[ii] = v[ii].clone();
		            vd[ii] = v[ii].clone();
		        }
				Effect w=new Effect(vw);
				Effect a=new Effect(va);
				Effect s=new Effect(vs);
				Effect d=new Effect(vd);
				ov=w.UpEffect() && a.LfEffect() && s.DnEffect() && d.RtEffect();
			}
			return ov;
		}
	public void implChange(HashMap<Integer,Integer[]> x,boolean mm) {
		if(!mm) {
			Integer[] keys=x.keySet().toArray(new Integer[0]);
			int rs = keys[(int)(Math.random()*keys.length)];
			int rKey=x.get(rs)[0];
			int rValue = x.get(rs)[1];
			int newcount=(Math.random()>0.8)?4:2;
			v[rKey][rValue]=newcount;	
		}
	}
}

