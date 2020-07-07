class node {
	int data;
	node next;
	node(int data){
		this.data = data;
		this.next = null;
	}
}

class Result{
	node a;
	boolean result;
	Result(node a, boolean r){
		this.a = a;
		this.result = r;
	}
}

class satvik{
	public static void main(String args[]){
		node data1 = null;
		data1 = insertEnd(data1, 1);
		data1 = insertEnd(data1, 3);
		data1 = insertEnd(data1, 5);
		data1 = insertEnd(data1, 8);
		data1 = insertEnd(data1, 9);
		data1 = insertEnd(data1, 11);
		data1 = insertEnd(data1, 15);

		node data2 = null;
		data2 = insertEnd(data2, 2);
		data2 = insertEnd(data2, 4);
		data2 = insertEnd(data2, 6);
		data2 = insertEnd(data2, 7);
		data2 = insertEnd(data2, 12);
		data2 = insertEnd(data2, 16);
		data2 = insertEnd(data2, 20);

		node m = mergeSorted(data1, data2);
		printList(m);		
	}

	//Merging two sorted linked lists
	public static node mergeSorted(node a, node b){
		node n1 = a, n2 = b, res = new node(-1);
		node temp = res;
		while(n1!=null && n2!=null){
			if(n1.data < n2.data){
				temp.next = n1;
				n1 = n1.next;
			}
			else{
				temp.next = n2;
				n2 = n2.next;
			}
			temp = temp.next;
		}
		if(n1!=null){
			temp.next = n1;
		}
		if(n2!=null){
			temp.next = n2;
		}
		return res.next;
	}
	public static boolean isPalindrome(node a){
		int len = 0;
		node temp = a;
		while(temp!=null){
			len+=1;
			temp = temp.next;
		}
		Result p = isPalindromeRecurse(a, len);
		return p.result;
	} 

	public static Result isPalindromeRecurse(node a, int length){
		if(length==0 || a==null){
			return new Result(a,true);
		}else if(length==1){
			return new Result(a.next, true);
		}
		Result res= isPalindromeRecurse(a.next, length-2);
		if(!res.result || res.a==null){
			return res;
		}
		res.result = (a.data==res.a.data);
		res.a = res.a.next;
		return res;
	}

	//Adding number using linked list
	public static node addStraight(node a, node b){
		listRev(a);
		listRev(b);
		return addReverse(a,b);
	}
	public static node addReverse(node l1, node l2){
		node ans = new node(0);
        node a = l1, b = l2, res = ans;
        int sum, carry = 0;
        while(a!=null && b!=null){
            
            sum = a.data + b.data + carry;
            if(sum>9){
                carry = sum/10;
                sum = sum%10;                
                System.out.println(sum);
            }else{
                carry = 0;
            }         
            res.next = new node(sum);
            
            a = a.next;
            b = b.next;
            res = res.next;
        }
        while(a!=null){
            sum = a.data + carry;
            if(sum>9){
                carry = sum/10;
                sum = sum%10;                
            }else{
                carry = 0;
            }      
            res.next = new node(sum);
            a = a.next;
            res = res.next;
        }
        while(b!=null){
            sum = b.data + carry;
            if(sum>9){
                carry = sum/10;
                sum = sum%10;                
            }else{
                carry = 0;
            }      
            res.next = new node(sum);
            b = b.next;
            res = res.next;
        }
        if(carry!=0){
            res.next = new node(carry);
        }
        return ans.next;
	}

	//UTILITY FUNCTIONS
	public static node insertEnd(node head, int data){
		if(head==null){
			head = new node(data);
		}else{
			node temp = head;
			while(temp.next!=null){

				temp = temp.next;
			}
			temp.next = new node(data);
		}
		return head;
	}
	public static node insertAtIndex(node head, int data, int index){
		node tempNewNode = new node(data);
		node temp = head;
		if(index==0){
			head = tempNewNode;
			tempNewNode.next = temp;
		}
		else{
			for(int i=0;i<index-1;i++){
				temp = temp.next;
			}
			
			node tempHold = temp.next;
			temp.next = tempNewNode;
			tempNewNode.next = tempHold;
		}
		return head;
	}
	public static node push(node head, int data){		
		if(head==null){
			head = new node(data);
		}else{
			node front = new node(data);
			front.next = head;
			head = front;
		}
		return head;
	}
	public static void printList(node head){
		node temp = head;
		while(temp!=null){
			System.out.print(temp.data+"->");
			temp = temp.next;
		}
		System.out.println();
	}
	public static void deleteNode(node head, int index){
		if(index==0){
			head = head.next;
		}else{
			node temp = head;
			for(int i=0;i<index-1;i++){
				temp = temp.next;
			}
			temp.next = temp.next.next;
		}	
	}

	//removes the second occuring of an element
	public static void removeDup(node head){
		node temp = head;
		int min=temp.data, max = temp.data;
		int curr;
		while(temp!=null){
			curr = temp.data;
			if(curr>max){
				max = curr;
			}
			if(curr<min){
				min = curr;
			}
			temp = temp.next;
		}
		temp = head;
		int len = max-min+1;
		int[] check = new int[len];
		int indexToDelete = 0;
		while(temp!=null){	
			curr = temp.data - min;
			check[curr]+=1;
			if(check[curr] > 1){
				System.out.println("Duplicate found: "+(temp.data));
				deleteNode(head, indexToDelete);
			}
			indexToDelete+=1;
			temp = temp.next;
		}
	}
	public static void printRev(node head){
		if(head.next!=null){
			printRev(head.next);
		}
		System.out.print(head.data+"->");
	}
	public static void listRev(node head){
		node curr = head;
		node prev = null, agla = null;
		while(curr!=null){
			agla = curr.next;
			curr.next = prev;
			prev = curr;
			curr = agla;
		}
		head = prev;
	}
	public static void printLastKth(node head, int k){
		node a=head, b=head;
		int i = 0;
		while(i<k){
			a = a.next;
			i+=1;
		}
		while(a!=null){
			a = a.next;
			b = b.next;
		}
		System.out.println(b.data);
	}

	public static void deleteMid(node head){
		node a=head, b=head;
		int indexToDelete = 0;
		while(a!=null && b!=null && b.next!=null){
			a = a.next;
			b = b.next.next;
			indexToDelete++;
		}
		System.out.println("Mid element = "+a.data);
		deleteNode(head, indexToDelete);
	}
}