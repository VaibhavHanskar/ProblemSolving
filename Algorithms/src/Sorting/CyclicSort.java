package Sorting;/* Use when we have given value from 1-n*/
import java.util.Arrays;

public class CyclicSort {
    public void sort(int[] nums){
        int size = nums.length;
        int i =0;
        while(i<size){
            if(nums[i] == i+1){
                i++;
            }else{
                swap(nums,i,nums[i]-1);
            }
        }
    }

    public void swap(int[] nums, int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args){
        CyclicSort obj = new CyclicSort();
        int[] nums = {5,2,1,4,3};
        System.out.println("Before Sorting "+ Arrays.toString(nums));
        obj.sort(nums);
        System.out.println("After Sorting "+Arrays.toString(nums));
    }
}
