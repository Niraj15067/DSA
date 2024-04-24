package linkedListAndTree;

public class SegmentMain {

	public static void main(String[] args) {
		
		int[] arr = {3,8,7,6,-2,-8,7,9};
		SegmentTree st = new SegmentTree(arr);
		st.display();
		st.update(6, 4);
		st.update(0, 5);
		System.out.println("------------------------------------");
		st.display();
	}

}
