import java.util.*;

class satvik{
	public static void main(String args[]){
				  // 0,1,2,3,4,5,6,7,8
		int[] arr = {1,9,2,3,8,4,7,5,6};
				  // 1,2,3,4,5,6,7,8,9
		quickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	public static void quickSort(int[] arr, int l, int h){
		if(l<h){
			int p = partition(arr, l, h);
			quickSort(arr, l, p-1);
			quickSort(arr, p+1, h);
		}
	}
	public static int partition(int[] arr, int l, int h){
		int pivot = arr[h];
		int i = l-1;
		for(int j=l;j<h;j++){
			if(arr[j]<pivot){
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i+1, h);
		return i+1;
	}
	public static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}