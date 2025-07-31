package TwoPointerSlidingWindow;

public class CountNiceSubarray {
    public int numberOfSubarrays(int[] nums, int k) {
        if(k > nums.length){
            return 0;
        }
        if(nums.length == 1){
            if(nums[0]%2 == 0){
                return 0;
            }
            return 1;
        }
        int[] binaryArray = new int[nums.length];
        for(int x=0;x<nums.length;x++){
            if(nums[x]%2 != 0 ){
                binaryArray[x] = 1;
            }
        }

        return f(binaryArray,k) - f(binaryArray,k-1);
    }

    public int f(int[] arr, int k){
        int sum = 0;
        int count = 0;
        int l = 0;
        int r = 0;
        while(r<arr.length){
            sum += arr[r];
            while(sum > k){
                sum -= arr[l];
                l++;
            }
            count += r-l+1;
            r++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums ={2,2,2,1,2,2,1,2,2,2};
        int k = 2;
        CountNiceSubarray obj = new CountNiceSubarray();
        System.out.println(obj.numberOfSubarrays(nums,k));
    }
}
