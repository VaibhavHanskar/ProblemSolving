//https://leetcode.com/problems/koko-eating-bananas/description/
package BinarySearch;

public class KokoEatingBanana {
    public int minEatingSpeed(int[] piles, int h){
        int ans = piles[0];
        if(piles.length == 1){
            ans = piles[0]/h;
            if(piles[0]%h != 0){
                ans++;
            }
            return ans;
        }

        for(int i =1;i<piles.length;i++){
            ans = Math.max(piles[i],ans);
        }
        int i = 1;
        int j = ans;
        while(i<=j){
            int mid = i + (j-i)/2;
            int count =0;
            for(int k=0;k<piles.length;k++){
                count += piles[k]/mid;
                if(piles[k]%mid != 0){
                    count++;
                }
                if(count > h){
                    break;
                }
            }
            if(count > h){
                i = mid+1;
            }
            else{
                ans = mid;
                j = mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] piles = {30,11,23,4,20};
        int h = 5;
        KokoEatingBanana obj = new KokoEatingBanana();
        int ans = obj.minEatingSpeed(piles,h);
        System.out.println(ans);
    }
}
