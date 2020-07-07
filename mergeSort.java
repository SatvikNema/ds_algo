import java.util.*;
// class mergeInvCount {
//     public static void splitThenMerge(int[] arr, int left, int right){
//         int mid = left + (right-left)/2;
//         if(left < right){
//             splitThenMerge(arr, left, mid);
//             splitThenMerge(arr, mid+1, right);
//             System.out.println(left+" "+right);   
//             merge(arr, left, mid, right);         
//         }
//     }
//     public static void merge(int[] arr, int left, int mid, int right){
//         int alen = mid-left+1, blen = right-mid;
//         int[] a = new int[alen];
//         int[] b = new int[blen];
//         for(int i=0;i<alen;i++){
//             a[i] = arr[i+left];
//         }
//         for(int i=0;i<blen;i++){
//             b[i] = arr[i+mid+1];
//         }
//         int i = 0, j = 0, index = left;
//         while(i<alen && j<blen){
//             if(a[i]>b[j]){
//                 arr[index++] = b[j];
//                 j++;
//             }else{
//                 arr[index++] = a[i];
//                 i++;
//             }
//         }
//         while(i<alen){
//             arr[index++] = a[i];
//             i++;
//         }
//         while(j<blen){
//             arr[index++] = b[j];
//             j++;
//         }
//     }
//     public static void main(String args[]){
//         int[] arr = {2,3,8,6,1};
//         // System.out.println(splitThenMerge(arr, 0, arr.length-1));
//         splitThenMerge(arr, 0, arr.length-1);
//         System.out.println(Arrays.toString(arr));
//     }
// }


// Practise marge

class satvik{
    public static void main(String args[]){
        int[] arr = {5,3,7,1,8,3,9};
        split(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void split(int[] arr, int l, int r){
        if(l<r){
            int m = l + (r-l)/2;
            split(arr, l, m);
            split(arr, m+1, r);
            merge(arr, l, m, r);
        }
    }
    public static void merge(int[] arr, int l, int m, int r){
        int n1 = m-l+1;
        int n2 = r-m;
        int[] a = new int[n1];
        int[] b = new int[n2];
        int i=0,j=0,k=l;
        for(int o=0;o<n1;o++){
            a[o] = arr[k+o];
        }
        for(int o=0;o<n2;o++){
            b[o] = arr[m+o+1];
        }
        while(i<n1 && j<n2){
            if(a[i]<b[j]){
                arr[k] = a[i];
                i++;
            }else{
                arr[k] = b[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            arr[k] = a[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k] = b[j];
            j++;
            k++;
        }
    }
}