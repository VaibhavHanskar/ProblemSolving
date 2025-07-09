package Arrays;

public class SecondLargestElement {
    public int findSecondLargestA1(int[] nums) {
        int size = nums.length;
        int largest = nums[0];
        for(int i =1;i<size;i++){
            if(nums[i] > largest){
                largest = nums[i];
            }
        }
        int secondLargest = Integer.MIN_VALUE;
        for(int i=0;i<size;i++){
            if(nums[i] > secondLargest  && nums[i]<largest){
                secondLargest = nums[i];
            }
        }
        return secondLargest;
    }

    public int findSecondLargestA2(int[] nums) {
        int size = nums.length;
        int largest  = nums[0];
        int secondLargest = Integer.MIN_VALUE;
        for(int i=1;i<size;i++){
            if(nums[i] < largest && nums[i] > secondLargest){
                secondLargest = nums[i];
            }
            else{
                secondLargest = largest;
                largest = nums[i];
            }
        }
        return secondLargest;
    }
    public static void main(String[] args) {
        int[] nums = {5, 2, 1, 4, 3,5};
        SecondLargestElement obj = new SecondLargestElement();
//        int secondLargest = obj.findSecondLargestA1(nums); // Better Approach
        int secondLargest = obj.findSecondLargestA2(nums);  // Optimised Approach
        System.out.println("Second Largest Element: " + secondLargest);
    }
}
