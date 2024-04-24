package linkedListAndTree;

import java.util.Arrays;

public class TwoStacks {

	public static int game(int[] a, int[] b, int max) {
		return game(max,a,b,0,0)-1;
	}
	public static int game(int max, int[] a, int[] b, int cs, int count) {
		
		if(cs>max) {
			return count;
		}
		
		if(a.length==0 || b.length==0) {
			return count;
		}
		
		int ans1 = game(max,Arrays.copyOfRange(a, 1, a.length),b,cs+a[0],count+1);
		int ans2 = game(max, a, Arrays.copyOfRange(b, 1, b.length),cs+b[0], count+1);
		
		return Math.max(ans1, ans2);
	}
}
