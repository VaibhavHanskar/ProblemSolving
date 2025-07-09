//https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/
package BinarySearch;

public class CapacityOfShipPackage {
    public int shipWithinDays(int[] weights, int days) {
        if(weights.length == 1){
            return weights[0];
        }
        int maxValue = weights[0];
        int minValue = weights[0];

        for(int i =1;i<weights.length;i++){
            maxValue  = maxValue+weights[i];
            minValue  = Math.max(minValue,weights[i]);
        }

        int ans = maxValue;
        int i = minValue;
        int j = maxValue;

        while(i<=j){
            int mid = i + (j-i)/2;
            boolean isPossible = possible(weights,mid,days);

            if(isPossible){
                ans = mid;
                j = mid-1;
            }
            else{
                i = mid+1;
            }
        }
        return ans;
    }

    public boolean possible(int[] weights, int capacity, int days){
        int load = 0 ;
        int day =1;
        for(int i=0;i<weights.length;i++){
            if(load + weights[i] > capacity){
                day++;
                load = weights[i];
            }
            else{
                load += weights[i];
            }
        }
        if(day > days){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int[] weights = {3,2,2,4,1,4};
        int days = 3;
        CapacityOfShipPackage obj = new CapacityOfShipPackage();
        int ans = obj.shipWithinDays(weights,days);
        System.out.println(ans);
    }

}
