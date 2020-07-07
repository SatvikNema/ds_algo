import java.util.*;

class Heap{
    int[] arr;
    int capactiy, size;

    Heap(){
        arr = new int[10];
        capactiy = 10;
        size = 0;
    }

    public void handleSize(){
        if(size == capactiy){
            this.arr = Arrays.copyOf(arr, capactiy*2);
            capactiy*=2;
        }
    }

    public int peek(){
        if(size==0){
            throw new IllegalStateException();
        }
        return arr[0];
    }

    public void add(int item){
        this.handleSize();
        arr[size] = item;
        size++;
        heapifyUp();
    }

    public int poll(){
        if(size==0){
            throw new IllegalStateException();
        }
        int item = arr[0];
        arr[0] = arr[size-1];
        size--;
        heapifyDown();
        return item;
    }

    public void heapifyDown(){
        int start = 0, smallIndex;
        while(leftChildExists(start)){
            smallIndex = getLeftChild(start);
            if(rightChildExists(start) && (arr[getRightChild(start)] < arr[smallIndex])){
                smallIndex = getRightChild(start);
            }

            if(arr[smallIndex] > arr[start]){
                break;
            }else{
                swap(smallIndex, start);
                start = smallIndex;
            }
        }
    }

    public void heapifyUp(){
        int index = size-1;
        while(parentExists(index) && (arr[getParent(index)] > arr[index])){
            swap(getParent(index), index);
            index = getParent(index);
        }
    }

    public void swap(int i1,int i2){
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    public boolean parentExists(int index){
        return ((index-1)/2 >= 0);
    }

    public int getParent(int index){
        return (index-1)/2;
    }

    public boolean leftChildExists(int index){
        return getLeftChild(index)<size;
    }

    public int getLeftChild(int index){
        return 2*index+1;
    }

    public boolean rightChildExists(int index){
        return getRightChild(index)<size;
    }

    public int getRightChild(int index){
        return 2*index+2;
    }

    public void printHeap(){
        for(int i=0;i<size;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("");
    }

    public boolean isEmpty(){
        return (size==0);
    }
}

class heaps{
    public static void main(String[] args){
        Heap heap = new Heap();
        int[] test = {20,16,10,17,25,5,15};
        for(int i:test){
            heap.add(i);
            heap.printHeap();
        }
        //expected output:
        // 20
        // 16 20
        // 10 20 16
        // 10 17 16 20
        // 10 17 16 20 25
        // 5 17 10 20 25 16
        // 5 17 10 20 25 16 15

        System.out.println("\nNow deleting...");
        heap.printHeap();
        while(!heap.isEmpty()){
            heap.poll();
            heap.printHeap();
        }

        //expected output:
        // 5 17 10 20 25 16 15
        // 10 17 15 20 25 16
        // 15 17 16 20 25
        // 16 17 25 20
        // 17 20 25
        // 20 25
        // 25

        // Another case: {20,16,10,17,25,5,18}
        // Adding:
        // 20
        // 16 20
        // 10 20 16
        // 10 17 16 20
        // 10 17 16 20 25
        // 5 17 10 20 25 16
        // 5 17 10 20 25 16 18

        // Deleting:
        // 5 17 10 20 25 16 18
        // 10 17 16 20 25 18
        // 16 17 18 20 25
        // 17 20 18 25
        // 18 20 25
        // 20 25
        // 25
    }
}
