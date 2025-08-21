package Arrays;
import  java.util.*;
public class FruitsIntoBasket_II {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        if(n == 1){
            if(fruits[0] <= baskets[0]){
                return 0;
            }
            return 1;
        }
        int[] reference = new int[fruits.length];
        Arrays.fill(reference,1);
        int count = 0;
        for(int i=0;i<fruits.length;i++){
            for(int j=0;j<fruits.length;j++){
                if(fruits[i] <= baskets[j] && reference[j] != 0){
                    reference[j]--;
                    count++;
                    break;
                }
            }
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            ans+= reference[i];
        }
        return n-count;
    }


    public int numOfUnplacedFruits_III(int[] fruits, int[] baskets){
        int n = fruits.length;
        if(n==1){
            if(fruits[0]<= baskets[0]){
                return 0;
            }
            return 1;
        }
        int ans=0;
        int[] unplaced = new int[n];
        Arrays.fill(unplaced,1);
        int placedIndex = -1;
        for(int i=0;i<n;i++){
            placedIndex += 1;
            for(int j=placedIndex;j<n;j++){
                if(fruits[i]<=baskets[j] && unplaced[j] == 1){
                    unplaced[j]--;
                    placedIndex = j;
                    break;
                }
            }
        }

        for(int i=0;i<n;i++){
            if(unplaced[i] == 1 && fruits[n-1]<=baskets[i]){
                unplaced[i]--;
            }
            ans+=unplaced[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] fruits = {3,6,5};
        int[] basket = {6,4,7};
        FruitsIntoBasket_II obj = new FruitsIntoBasket_II();
//        System.out.println(obj.numOfUnplacedFruits(fruits,basket));
        System.out.println(obj.numOfUnplacedFruits(fruits,basket));

    }
}
