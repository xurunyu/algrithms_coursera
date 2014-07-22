package union_find;

public class QuickUnionUF {
	private int[] id;
	private int[] sz;
	
	public QuickUnionUF(int N){
		id = new int[N];
		sz = new int[N];
		for(int i = 0; i < N; i++){
			id[i] = i;
			sz[i] = 1;
		}
	}
	
	private int root(int i){
		while(id[i]!=i){
//			id[i] = id[id[i]];
			i = id[i];
		}
		return i;
	}
	
	public boolean connected(int p, int q){
		return root(p) == root(q);
	}
	
	public void union(int p, int q){
		int i = root(p);
		int j = root(q);
//		id[i] = j;
		if(i == j) return;
		if(sz[i]< sz[j]){ id[i] = j; sz[j]+=sz[i];	}
		else { id[j] = i; sz[i]+=sz[j];	}
	}
	
	public void print(QuickUnionUF N){
		int[] Nums = N.id;
		for(int i = 0; i < Nums.length; i++){
			System.out.print(Nums[i]+" ");
		}
	}
	
	public static void main(String[] args){//4-0 0-3 4-5 6-2 0-7 9-8 9-2 4-6 1-9 
		QuickUnionUF qf = new QuickUnionUF(10);
		qf.union(4, 0);
		qf.union(0, 3);
		qf.union(4, 5);
		qf.union(6, 2);
		qf.union(0, 7);
		qf.union(9, 8);
		qf.union(9, 2);
		qf.union(4, 6);
		qf.union(1, 9);
		qf.print(qf);
	}
}
