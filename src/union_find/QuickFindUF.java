package union_find;

public class QuickFindUF {
	private int[] id;
	
	public QuickFindUF(int N){
		id = new int[N];
		for(int i = 0;i<N; i++){
			id[i] = i;
		}
	}
	
	public boolean connected(int p,int q){
		return id[p] == id[q];
	}
	
	public void union(int p, int q){
		int pid = id[p];
		int qid = id[q];
		for(int i = 0; i< id.length; i++){
			if(id[i]==pid)
				id[i]= qid;
		}
	}
	
	public void print(QuickFindUF N){
		int[] Nums = N.id;
		for(int i = 0; i < Nums.length; i++){
			System.out.print(Nums[i]+"  ");
		}
	}
	
	public static void main(String[] args){
		QuickFindUF qf = new QuickFindUF(10);
		qf.union(9, 2);
		qf.union(5, 7);
		qf.union(0, 3);
		qf.union(3, 8);
		qf.union(0, 1);
		qf.union(1, 6);
//		qf.print(qf);
	}
}
