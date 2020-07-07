class myQueue<T>{

	class queueNode<T>{
		T value;
		queueNode<T> next;
		queueNode(T value){
			this.value = value;
		}
	}

	queueNode<T> front=null, rear=null;
 
	public void queue(T value){
		queueNode<T> newQueueNode = new queueNode<T>(value);
		if(front==null && rear==null){
			front = newQueueNode;
		}
		else{
			rear.next = newQueueNode;
		}
		rear = newQueueNode;
	}
	public T dequeue()throws queueException{
		if(front!=null){
			T t = front.value;
			front = front.next;
			if(front==null){
				rear = null;
			}
			return t;
		}
		else{
			throw new queueException("The queue is already empty!");
		}
	}
	public T peek()throws queueException{
		if(front==null){
			throw new queueException("The queue is already empty!");
		}
		return front.value;
	}
}

class satvik{
	public static void main(String args[])throws Exception{
		myQueue<String> data = new myQueue<String>();
		data.queue("Satvik");
		data.queue("Piyush");
		data.queue("Annunay");
		System.out.println(data.dequeue());
		System.out.println(data.dequeue());
		System.out.println(data.dequeue());
		data.queue("hello there!");
		System.out.println(data.peek());
	}
}

class queueException extends Exception{
	queueException(String s){
		super(s);
	}
}