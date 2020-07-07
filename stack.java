class myStack<T>{

	class stackNode<T>{
		T value;
		stackNode<T> next;
		stackNode(T value){
			this.value = value;
		}
	}	

	stackNode<T> top;

	public void push(T value){
		if(top==null){
			top = new stackNode<T>(value);
		}else{
			stackNode<T> temp = new stackNode<T>(value);
			temp.next = top;
			top = temp;
		}
	}
	public T pop()throws stackException{
		if(top==null){
			throw new stackException("Stack already empty");
		}else{
			T temp = top.value;
			top = top.next;
			return temp;
		}
	}
	public T peek()throws stackException{
		if(top!=null){
			return top.value;
		}else{
			throw new stackException("Stack already empty");
		}
	}
	public boolean isEmpty(){
		return top==null;
	}
}

class stackException extends Exception{
	stackException(String s){
		super(s);
	}
}

class satvik{
	public static void main(String args[])throws Exception{
		myStack<String> data = new myStack<String>();
		data.push("Satvik");
		data.push("Sarvesh");
		data.push("Kartik");
		System.out.println(data.peek());
		data.pop();
		data.push("Neetal");
		System.out.println(data.peek());
		data.pop();
		System.out.println(data.peek());
		data.pop();
		data.pop();
		data.push("hello");
		System.out.println(data.peek());
	}
}