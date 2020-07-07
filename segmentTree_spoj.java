import java.util.Scanner;
class treeNode{
    int preSum, sufSum, sum, maxSubSum;
    treeNode(int min){
        preSum = sufSum = sum = maxSubSum = min;
    }
}
class segmentTree{
    treeNode[] a;
    int[] input;
    int index, ipSize, digit, min;
    segmentTree(int[] ip, int len, int m){
        digit = index = 0;
        input = ip;
        ipSize = len;
        min = m;
        while(len > (1<<digit)){
            digit++;
        }
        this.a = new treeNode[1<<(digit+1)];
        a[0] = new treeNode(min);
        buildTree(1);
    }
    public treeNode buildTree(int node){
        a[node] = new treeNode(min);
        if(node >= (1<<digit)){
            if(index < ipSize){
                a[node].maxSubSum = a[node].sufSum = a[node].preSum = a[node].sum = input[index++];
                return a[node];
            }
            return a[node];
        }
        treeNode x = buildTree(node << 1);
        treeNode y = buildTree((node << 1)+1);
        a[node] = calcParams(x,y);
        return a[node];
    }
    public treeNode calcParams(treeNode x, treeNode y){
        treeNode res = new treeNode(min);
        res.sum = x.sum + y.sum;
        res.preSum = Math.max(x.preSum, (x.sum+y.preSum));
        res.sufSum = Math.max(y.sufSum, (x.sufSum + y.sum));
        res.maxSubSum = Math.max((x.sufSum+y.preSum), Math.max(x.maxSubSum, y.maxSubSum));
        return res;
    }
    public treeNode handleQuery(int l, int r){
        return ansQuery(1, (1 << digit)+l, (1 << digit)+r, (1<<digit), (1 << (digit+1))-1);
    }
    public treeNode ansQuery(int node, int l, int r, int leftMost, int rightMost){
        treeNode res = new treeNode(min);
        if(l <= r){            
            if(leftMost >= l && rightMost <= r){
                return a[node];
            }else{
                int mid = (rightMost+leftMost)>>1;
                if(l > mid){
                    return ansQuery(((node << 1)+1), l, r, ((rightMost+leftMost)>>1)+1, rightMost);
                }
                if(r <= mid){
                    return ansQuery((node << 1), l, r, leftMost, (rightMost+leftMost)>>1);
                }
                treeNode a = ansQuery((node << 1), l, r, leftMost, (rightMost+leftMost)>>1); 
                treeNode b = ansQuery(((node << 1)+1), l, r, ((rightMost+leftMost)>>1)+1, rightMost);
                return calcParams(a, b);
                // return min;
            }
        }
        return res;
    }
} 
class tempQ {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        StringBuilder res = new StringBuilder("");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int len = n, min = -15008;
        segmentTree tree = new segmentTree(arr, len, min);
        int q = sc.nextInt();
        treeNode ans;
        for(int i=0;i<(q-1);i++){
            ans = tree.handleQuery((sc.nextInt() - 1), (sc.nextInt() - 1));
            res.append(ans.maxSubSum+"\n");            
        }
        ans = tree.handleQuery((sc.nextInt() - 1), (sc.nextInt() - 1));
        res.append(ans.maxSubSum);
        System.out.println(res);
    }
}