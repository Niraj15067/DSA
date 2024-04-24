 package linkedListAndTree;

public class CustomQueue {

	protected int[] data;
	private final static int DEFAULT_SIZE = 10;
	private int end = 0;

	public CustomQueue() {
		this(DEFAULT_SIZE);
	}

	public CustomQueue(int size) {
		data = new int[size];
	}
	
	protected boolean isFull() {
		return end == data.length;
	}

	private boolean isEmpty() {
		return end == 0;
	}
	public boolean insert(int val) throws Exception {
		if(isFull()) {
			return false;
		}
		data[end++] = val;
		return true;
	}
	//to remove ele we just left shift all the elements by 1.
	public int remove() throws Exception {
		if(isEmpty()) {
			throw new Exception("can't remove as queue is already empty!!");
		}
		int removed = data[0];
		for(int i=1;i<end;i++) {
			data[i-1] = data[i];
		}
		end--;
		return removed;
	}
	public int front() throws Exception{
		if(isEmpty()) {
			throw new Exception("Queue is empty!!");
		}
		return data[0];
	}
	public void display() {
		for(int i=0;i<end;i++) {
			System.out.print(data[i]+"<-");
		}
		System.out.print("END");
	}
}
