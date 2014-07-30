package sort;

public class Shell{
	private static boolean less(Comparable v, Comparable w) {
		System.out.println("1"+" "+v+" "+w);
		return v.compareTo(w) < 0;
	}

	private static void exch(Comparable[] a, int i, int j) {
		Comparable<Integer> swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	public static void sort(Comparable[] a) {
		int N = a.length;
		int h = 1;
		while (h < N / 3)
			h = 3 * h + 1; // 1, 4, 13, 40, 121, 364, ...
		while (h >= 1) { // h-sort the array.
			for (int i = h; i < N; i++) {
				for (int j = i; j >= h && less(a[j], a[j - h]); j -= h)
					exch(a, j, j - h);
			}

			h = h / 3;
		}
	}
	
	public static void main(String[] args){
		Comparable[] a = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17};
		Shell.sort(a);
	}
}
