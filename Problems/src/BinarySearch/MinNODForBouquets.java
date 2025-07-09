// https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
package BinarySearch;

public class MinNODForBouquets {
    public int numberOfDays(int[] bloomDay, int m, int k){
        int ans = -1;
        long requiredFlowers = m*k;
        if(requiredFlowers > bloomDay.length){
            return ans;
        }

        int max = bloomDay[0];
        int min = bloomDay[0];
        for (int day : bloomDay) {
            max = Math.max(day, max);
            min = Math.min(day, min);
        }
        int i = min;
        int j = max;
        while(i<=j){
            int mid = i + (j-i)/2;
            boolean isPossible = possible(bloomDay,mid,m,k);
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

    public boolean possible(int[] bloomDay, int day, int m , int k){
        int numberOfBouquets = 0;
        int count =0;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i] <= day){
                count++;
            }else{
                numberOfBouquets += count/k;
                count=0;
            }
        }
        numberOfBouquets += count/k;
        if(numberOfBouquets >= m){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] bloomDay = {7,7,7,7,12,7,7};
        int m = 2;
        int k = 3;
        MinNODForBouquets obj = new MinNODForBouquets();
        int ans = obj.numberOfDays(bloomDay,m,k);
        System.out.println(ans);
    }
}
