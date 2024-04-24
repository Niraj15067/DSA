package linkedListAndTree;

public class DynamicQueue extends CircularQueue {

	public DynamicQueue() {
		super();
	}
	public DynamicQueue(int size) {
		super(size);
	}
	
	@Override
	public boolean insert(int val) {
		
		if(isFull()) {
			resize();
		}
		super.insert(val);
		return true;
	}
	
	private void resize() {
		int[] temp = new int[data.length*2];
//		int i = front;
//		int newEnd = data.length;
		//over here i am copying the items as it is as they were in the previous array on the
		//exact same index but what we can do this copy them from 0 in the next array and
		//set the front to 0 after copying is done.
		//sequence form front till end is all that matters right.
//		do {
//			temp[i] = data[i];
//			i++;
//			i %= data.length;
//		}while(i!=end);
		//or can use for loop also like this:
		for(int i =0;i<data.length;i++) {
			temp[i] = data[(i+front)%data.length];
		}
		front = 0;
		end = data.length;
		data = temp;
	}
}
