package union_find;
public class Percolation {
	private int[] id;
	private int[] op;
	private int length;

	public Percolation(int N){
		// create N-by-N grid, with all sites blocked
		id = new int[(N * N) + 1];
		op = new int[N * N];
		length = N;

		for (int i = 0; i < id.length; i++) {
			if (i < N) {
				id[i] = Integer.MIN_VALUE;
				op[i] = 1;
			} else if (i == id.length) {
				id[i] = Integer.MAX_VALUE;
			} else {
				id[i] = i;
				op[i] = 0;
			}
		}
	}

	public void open(int i, int j) {
		// open site (row i, column j) if it is not already
		op[j * length + i] = 1;
		int up = Integer.MAX_VALUE;
		int down = Integer.MAX_VALUE;
		int left = Integer.MAX_VALUE;
		int right = Integer.MAX_VALUE;
		if (op[(j - 1) * length + i] == 1) {
			up = id[(j - 1) * length + i];
		}
		if (op[(j + 1) * length + i] == 1) {
			down = id[(j + 1) * length + i];
		}
		if (op[j * length + i - 1] == 1) {
			left = id[j * length + i - 1];
		}
		if (op[j * length + i + 1] == 1) {
			right = id[j * length + i + 1];
		}
		int root = Math.min(
				Math.min(Math.min(Math.min(up, down), left), right), id[j
						* length + i]);
		id[j * length + i] = root;
		if (op[(j - 1) * length + i] == 1) {
			id[(j - 1) * length + i] = root;
		}
		if (op[(j + 1) * length + i] == 1) {
			id[(j + 1) * length + i] = root;
		}
		if (op[j * length + i - 1] == 1) {
			id[j * length + i - 1] = root;
		}
		if (op[j * length + i + 1] == 1) {
			id[j * length + i + 1] = root;
		}
	}

	public boolean isOpen(int i, int j) {
		// is site (row i, column j) open?
		return op[i] == 1;
	}

	public boolean isFull(int i, int j) {
		// is site (row i, column j) full?
		return id[i] == Integer.MIN_VALUE;
	}

	public boolean percolates() {
		// does the system percolate?
		return id[id.length] == Integer.MIN_VALUE;
	}

}
