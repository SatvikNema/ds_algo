import java.util.*;
class node{
	int name;
	LinkedList<node> links;
	boolean visited = false;
	node(int a){
		this.name = a;
		this.links = new LinkedList<node>();
	}
}

class Graph{
	int numEdges;
	node[] nodes;
	Graph(int a, node[] nodes){
		this.numEdges = a;
		this.nodes = new node[this.numEdges];
		this.nodes = nodes;
	}
	public void addDirectedEdge(node a, node b){
		a.links.add(b);
	}
	public void addUndirectedEdge(node a, node b){
		a.links.add(b);
		b.links.add(a);
	}
	public void depthFirstSearch(node root){
		if(root==null){
			return;
		}else{
			root.visited = true;
			System.out.print("->"+root.name);
			for(node a:root.links){
				if(!a.visited){
					depthFirstSearch(a);
				}
			}
		}
	}
	public void breadthFirstSearch(node root){
		Queue<node> q = new LinkedList<node>();
		q.add(root); 
		while(!q.isEmpty()){
			root = q.remove();
			System.out.print("->"+root.name);
			root.visited = true;
			for(node a: root.links){
				if(!a.visited){
					q.add(a);
					a.visited = true;
				}
			}
		}
	}
	public boolean isConnnected(node a, node b){
		Queue<node> q = new LinkedList<node>();
		q.add(a);
		node curr;

		while(!q.isEmpty()){
			curr = q.remove();
			curr.visited = true;
			for(node x:curr.links){
				if(!x.visited){
					q.add(x);
					x.visited = true;
					if(x==b){
						return true;
					}
				}
			}
		}
		return false;
	}
}

class satvik{
	public static void main(String args[]){

		//Making the nodes
		node a = new node(0);
		node b = new node(1);
		node c = new node(2);
		node d = new node(3);
		node e = new node(4);
		node f = new node(5);
		node g = new node(6);
		node[] listOfnodes = {a,b,c,d,e,f};

		//Initiating the graph of 6 nodes
		Graph gh = new Graph(6, listOfnodes); 

		//Making the connections
		gh.addDirectedEdge(a, b); 
		gh.addDirectedEdge(a, e);
		gh.addDirectedEdge(a, f); 
		gh.addDirectedEdge(b, d); 
		gh.addDirectedEdge(b, e);  
		gh.addDirectedEdge(c, b); 
		gh.addDirectedEdge(d, c); 
		gh.addDirectedEdge(d, e); 

		//DFS
		// gh.depthFirstSearch(a);	

		//BFS	
		// gh.breadthFirstSearch(a);

		//Check connection
		System.out.println(gh.isConnnected(a,b));
		System.out.println(gh.isConnnected(a,g));
	}
}