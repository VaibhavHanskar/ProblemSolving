package Sorting;/*Insertion sort is an stable inplace sorting algorithm which is used for small length array.
  It partially sorts the array and then inserts the next element in the sorted part of the array.
  Best to use when the flow of Data is continuous */

import java.util.Arrays;

public class InsertionSort {
    public void sort(int[] nums){
        int size = nums.length;
        for(int i=0;i<size-1;i++){
            int j = i+1;
            while(j>0){
                if(nums[j] < nums[j-1]){
                    swap(nums,j,j-1);
                    j--;
                }
                else{
                    break;
                }
            }
        }
    }

    public void swap(int[] nums, int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args){
        InsertionSort obj = new InsertionSort();
        int[] nums = {5,2,1,4,3};
        System.out.println("Before Sorting "+ Arrays.toString(nums));
        obj.sort(nums);
        System.out.println("After Sorting "+Arrays.toString(nums));
    }
}
