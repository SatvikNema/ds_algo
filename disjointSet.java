import java.util.*;

class Node{
    int name;
    int gSize;
    Node(int i){
        this.name = i;
        this.gSize = 1;
    }
}

class Set{
    int[] parent;
    Node[] nodes;
    Set(int num, Node[] n){
        this.parent = new int[num+1];
        for(int i=1;i<=num;i++){
            parent[i] = -1;
        }
        this.nodes = n;
    }

    int find(int v){
        if(parent[v]==-1){
            return v;
        }else{
            return find(parent[v]);
        }
    }

    void merge(Node a, Node b){
        int fa = this.find(a.name), fb = this.find(b.name);
        if(fa!=fb){
            nodes[fb].gSize += nodes[fa].gSize;
            parent[fa] = fb; 
        }
    }
}

class disjointSet{
    public static void main(String args[]){
        int n = 10;
        int[][] edges = {
            {1,2},
            {2,3},
            {2,4},
            {4,5},
            {6,7},
            {8,9},
            {9,10}
        };
        int e = edges.length;
        Node[] nodes = new Node[n+1];
        for(int i=1;i<=n;i++){
            nodes[i] = new Node(i);
        }

        Set set = new Set(10, nodes);

        for(int i=0;i<e;i++){
            if(set.find(edges[i][0]) != set.find(edges[i][1])){
                set.merge(nodes[edges[i][0]], nodes[edges[i][1]]);
            }
        }
        for(int i=1;i<=n;i++){
            System.out.println(i+" "+nodes[set.find(i)].gSize);
        }
    }
}