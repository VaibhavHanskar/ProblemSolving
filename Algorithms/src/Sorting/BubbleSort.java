package Sorting;/*Bubble sort is a Inplace Sorting Algorithm which is Stable sorting algo(Do not change the sequence of number)
  Best to use when data size is stable (fixed size array)*/

import java.util.Arrays;

class BubbleSort{
    public void sort(int[] nums){
        int size = nums.length;
        boolean swapped;
        int passes = 0;
        for(int i=0;i<size-1;i++){
            swapped = false;
            for(int j=0;j<size-i-1;j++){
                if(nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    swapped = true;
                }
            }
            if(swapped == false){
                break;
            }
            else{
                passes++;
            }
        }
        System.out.println("Number of passes : "+passes);
    }

    public static void main(String[] args){
        BubbleSort obj = new BubbleSort();
        int[] nums = {5,2,1,4,3};
        System.out.println("Before Sorting "+Arrays.toString(nums));
        obj.sort(nums);
        System.out.println("After Sorting "+Arrays.toString(nums));
    }
}