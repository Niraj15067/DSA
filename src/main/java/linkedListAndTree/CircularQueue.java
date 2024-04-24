package linkedListAndTree;

public class CircularQueue extends CustomQueue {
	protected int front = 0;
	protected int end = 0;
	protected int size = 0;

	public CircularQueue() {
		super();
	}

	public CircularQueue(int size) {
		super(size);
	}

	public boolean insert(int val){
		if (isFull()) {
			return false;
		}
		data[end++] = val;
		end %= data.length;
		size++;
		return true;
	}
	public int remove() throws Exception {
		if(isEmpty()) {
			throw new Exception("Can't remove from an empty queue!!");
		}
		int removed = data[front++];
		front = front % data.length;
		size--;
		return removed;
	}

	protected boolean isFull() {
		return size==data.length;
	}

	private boolean isEmpty() {
		return size==0;
	}
	public void display() {
		int i = front;
		do {
			System.out.print(data[i]+"<-");
			i++;
			i %= data.length;			
		}while(i!=end);
		System.out.print("END");
	}
	public int front() throws Exception {
		if(isEmpty()) {
			throw new Exception("Queue is empty!!");
		}
		return data[front];
	}
	public int getFront() {
		return front;
	}
	public int getEnd() {
		return end;
	}
}
