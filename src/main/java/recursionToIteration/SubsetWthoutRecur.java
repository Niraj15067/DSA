package recursionToIteration;

import java.util.ArrayList;
import java.util.List;

public class SubsetWthoutRecur {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 2 };
		List<List<Integer>> ans = subset(arr);
		for (List<Integer> list : ans) {
			System.out.println(list);
		}
	}

	static List<List<Integer>> subset(int[] arr) {

		List<List<Integer>> outer = new ArrayList<>();

		outer.add(new ArrayList<>());
		for (int i = 0; i < arr.length; i++) {
			
			int n = outer.size();

			for (int j = 0; j < n; j++) {
				List<Integer> internal = new ArrayList<>(outer.get(j));
				internal.add(arr[i]);
				if(!outer.contains(internal)) {
					outer.add(internal);
				}
			}
		}
		return outer;
	}

}
