class node{
	int data;
	node left;
	node right;
	node(int val){
		this.data = val;
		this.left = null;
		this.right = null;
	}
}
class queue<V>{
	V[] q;
	int len, front, back;
	queue(int len){
		this.len = len;

		q =  (V[])new Object[len];;
		front = 0;
		back = 0;
	}
	public void insert(V data){
		if(back==(len-1)){
			System.out.println("The queue is full!");
		}else{
			this.q[back++] = data;
		}
	}
	public void dequeue(){
		if(front==back){
			System.out.println("The queue is already emtpy!");
		}else{
			front+=1;
		}
	}
	public V peek(){
		return q[front];
	}
	public int isEmpty(){
		if(front==back){
			return 1;
		}
		return 0;
	}
}

class tree{
	public node insert(node root, int data){
		if(root==null){
			return new node(data);
		}else if(data>root.data){
			root.right = insert(root.right, data);
		}else{
			root.left = insert(root.left, data);
		}
		return root;
	}
	public void inorder(node root){
		if(root==null){
			return;
		}else{
			inorder(root.left);
			System.out.print(root.data+" ");
			inorder(root.right);
		}
	}
	public void levelOrderTraversal(node root, queue<node> q){
		if(root==null){
			return;
		}else{
			q.insert(root);
			while(q.isEmpty()==0){
				node temp = q.peek();
				System.out.print(temp.data+" ");
				
				if(temp.left!=null){
					q.insert(temp.left);
				}
				if(temp.right!=null){
					q.insert(temp.right);
				}
				q.dequeue();
			}
		}
	}
}

class main{
	public static void main(String args[]){
		tree t = new tree();
		node root = null;
		int[] data = {4,2,7,1,3,6};
		for(int i=0;i<data.length;i++){
			root = t.insert(root, data[i]);
		}
		System.out.println("Inorder: ");
		t.inorder(root);
		System.out.println("\nLevel order: ");
		queue<node> q = new queue<node>(20);
		t.levelOrderTraversal(root, q);
	}
}
