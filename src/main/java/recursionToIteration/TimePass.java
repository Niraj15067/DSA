package recursionToIteration;

import java.util.ArrayList;
import java.util.List;

public class TimePass {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 2 };
		List<List<Integer>> ans = subset(arr);
		System.out.println(ans);

	}

	private static List<List<Integer>> subset(int[] arr) {

		List<List<Integer>> ans = new ArrayList<>();
		ans.add(new ArrayList<>());

		for (int i = 0; i < arr.length; i++) {
			int size = ans.size();
			int start = 0, end = 0;

			if (i > 0 && arr[i] == arr[i - 1]) {
				start = end+1;
			}
			end = size-1;
			for (int j = start; j < size; j++) {
				List<Integer> internal = new ArrayList<>(ans.get(j));
				internal.add(arr[i]);
				ans.add(internal);

			}
		}
		return ans;
	}

}
