package Sorting;/*Selection Sort in Inplace sorting algorithm which is not stable sorting algorithm.
  It works as selecting the maximum/minimum element from the unsorted part of the array and
  swapping it with the last/first element of the unsorted part.
  This sorting algorithm is used for array with small length */

import java.util.Arrays;

public class SelectionSort {
    public void sort(int[] nums){
        int size  = nums.length;
        for(int i =0;i<size;i++){
            int right = size-i-1;
            int maxIndex = getMaxIndex(nums,0,right);
            swap(nums,maxIndex,right);
        }
    }

    public int getMaxIndex(int[] nums, int start, int end){
        int maxIndex = start;
        for(int i = start+1;i<=end;i++){
            if(nums[i] > nums[maxIndex]){
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args){
        SelectionSort obj = new SelectionSort();
        int[] nums = {5,2,1,4,3};
        System.out.println("Before Sorting "+ Arrays.toString(nums));
        obj.sort(nums);
        System.out.println("After Sorting "+Arrays.toString(nums));
    }
}
