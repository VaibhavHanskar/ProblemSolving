//https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
package TwoPointerSlidingWindow;

import java.util.Arrays;

public class MaximumPointsOfCards {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        if(k>n){
            return 0;
        }
        if(k==1){
            return Math.max(cardPoints[0], cardPoints[n-1]);
        }
        int ans = 0;
        if(n == k){
            for(int val : cardPoints){
                ans += val;
            }
            return ans;
        }

        int leftSum =0;
        int rightSum =0;
        for(int i=0;i<k;i++){
            leftSum += cardPoints[i];
        }
        ans = leftSum;
        int right = n-1;
        for(int i=k-1;i>=0;i--){
            leftSum -= cardPoints[i];
            rightSum += cardPoints[right];
            right--;

            ans = Math.max(ans, leftSum+rightSum);
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] cardPoints = {100,40,17,9,73,75};
        int k =3;
        MaximumPointsOfCards obj = new MaximumPointsOfCards();
        int ans = obj.maxScore(cardPoints,k);
        System.out.println(ans);
    }
}
