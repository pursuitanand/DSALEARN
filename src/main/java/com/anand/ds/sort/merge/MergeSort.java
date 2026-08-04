package com.anand.ds.sort.merge;

public class MergeSort {
    // Split → Sort → Merge and 3 pointers (i, j, k)
    public void mergeSort(int[] arr, int left , int right){
        if(left >= right){
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }
    //The merge() function is also easy if you remember the 3 pointers:
    private void merge(int[] arr, int left, int mid , int right){
        int[] temp = new int[right-left+1];

        int i = left;
        int j= mid+1;
        int k=0;

        //Compare and Store smaller element
        while(i<=mid && j<=right){
            if(arr[i] <= arr[j]){
                temp[k++] = arr[i++];
            }else {
                temp[k++] = arr[j++];
            }
        }

        // Copy left elements - remaining
        while(i<=mid){
            temp[k++] = arr[i++];
        }

        // Copy right elements - remaining
        while(j<=right){
            temp[k++] = arr[j++];
        }
        System.out.print("Merged array: ");
        for (int num : temp) {
            System.out.print(num + " ");
        }
        //copy temp back to original array
        for(i=left,k=0;i<=right;i++,k++){
            arr[i]=temp[k];
        }
    }

    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(arr, 0, arr.length - 1);
        System.out.println("Sorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
