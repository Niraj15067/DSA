package linkedListAndTree;

public class DynamicStack extends CustomStack {

	public DynamicStack() {
		super();
	}
	public DynamicStack(int size) {
		super(size);
	}

	public int push(int val) throws StackException {
		if (isFull()) {
			resize();
		}
//		ptr++;
//		data[ptr] = val; can do this or 
		super.push(val);
		return val;
	}

	private void resize() {
		int[] newData = new int[data.length * 2];
		for (int i = 0; i < data.length; i++) {
			newData[i] = data[i];
			data = newData;
		}
	}

}
