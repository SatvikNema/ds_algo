import java.util.*;

class satvik 
{ 
	static int max_ref;
	static int _lis(int arr[], int n) 
	{ 
		int[] lis = new int[n];
		ArrayList<ArrayList<Integer>> data = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> temp, temp2;
		for(int i=0;i<n;i++){
			lis[i] = 1;
		}
		int tempLis = 0, sameCount = 0;
		for(int i=1;i<n;i++){
			temp = new ArrayList<Integer>();

			for(int j=0;j<i;j++){
				if((arr[j] < arr[i]) && (lis[j]+1)>lis[i]){
					lis[i] = lis[j]+1;
					temp.add(arr[j]);
				}
			}
			temp.add(arr[i]);
			data.add(temp);
		}
		
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for(int i:lis){
			max = Math.max(max, i);
		}

		System.out.println("One of the longest subsequence is: ");
		for(ArrayList<Integer> i:data){
			if(i.size() == max){
				System.out.println(i.toString());
			}
		}
		return max; 
	}  
	public static void main(String args[]) 
	{ 
		// int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60, 20}; 
		// int[] arr = {1,3,5,4,7};
		int[] arr = {1,2,3,3};
		int n = arr.length; 
		System.out.println("Length of lis is "+ _lis(arr, n)); 
	} 
} 
