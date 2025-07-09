package Arrays;

class MissingNumber {
    public int missingNumber(int[] nums) {
        int ans =-1;
        int size = nums.length;
        int i=0;
        while(i<size){
            if(nums[i] != i && nums[i]<size){
                swap(nums,i,nums[i]);
            }
            else{
               i++;
            }
        }
        for(int j=0;j<size;j++){
            if(nums[j]!=j){
                ans =j;
            }
        }
        return ans;
    }

    public void swap(int[] nums, int a, int b){
        int temp =  nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3,0,1};
        MissingNumber obj = new MissingNumber();
        int ans = obj.missingNumber(nums);
        System.out.println("Missing Number: " + ans);
    }
}