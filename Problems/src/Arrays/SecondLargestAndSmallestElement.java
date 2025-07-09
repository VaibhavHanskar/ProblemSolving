package Arrays;

public class SecondLargestAndSmallestElement {
    public int[] findSecondLargestAndSmallest(int[] nums){
        int[] ans = new int[2];
        int size = nums.length;
        int largest = nums[0];
        int secondLargest = Integer.MIN_VALUE;


        for(int i =1;i<size;i++){
            if(nums[i] < largest && nums[i]>secondLargest){
                secondLargest = nums[i];
            }else{
                secondLargest = largest;
                largest = nums[i];
            }
        }
        ans[0] = secondLargest;

        int smallest = nums[0];
        int secondSmallest = Integer.MAX_VALUE;

        for(int i=1;i<size;i++){
            if(nums[i] > smallest && nums[i]<secondSmallest){
                secondSmallest = nums[i];
            }else if(nums[i] < smallest){
                secondSmallest = smallest;
                smallest = nums[i];
            }
        }
        ans[1] = secondSmallest;
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {5, 2, 1,1, 4, 3,5};
        SecondLargestAndSmallestElement obj = new SecondLargestAndSmallestElement();
        int[] ans  = obj.findSecondLargestAndSmallest(nums);
        System.out.println("Second Largest Element: " + ans[0]);
        System.out.println("Second Smallest Element: " + ans[1]);
    }
}
