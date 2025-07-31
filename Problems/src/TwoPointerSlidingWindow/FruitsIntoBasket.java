package TwoPointerSlidingWindow;

import java.util.HashMap;

public class FruitsIntoBasket {
    public int totalFruit(int[] fruits) {
        if(fruits.length <= 2){
            return fruits.length;
        }
        HashMap<Integer,Integer> map  = new HashMap();
        int max_length = 0;
        int i = 0;
        int j = 0;
        while(j<fruits.length){
            if(map.containsKey(fruits[j]) || map.size() < 2){
                map.put(fruits[j],map.getOrDefault(fruits[j],0)+1);
                max_length = Math.max(max_length,j-i+1);
                j++;
            }
            else{
                int val = map.get(fruits[i]);
                if(val <=1 ){
                    map.remove(fruits[i]);
                }
                else{
                    map.put(fruits[i],val-1);
                }
                i++;
            }
        }
        return max_length;
    }

    public int tFruits(int[] fruits){
        if(fruits.length <= 2){
            return fruits.length;
        }
        HashMap<Integer,Integer> map  = new HashMap();
        int max_length = 0;
        int i = 0;
        int j = 0;
        while(j<fruits.length){
            if(map.containsKey(fruits[j]) || map.size() < 2){
                map.put(fruits[j],j);
                max_length = Math.max(max_length,j-i+1);
                j++;
            }
            else{
                int val = map.get(fruits[i]);
                map.clear();
                map.put(fruits[val+1] , val+1);
                i = val+1;
            }
        }
        return max_length;
    }

    public static void main(String[] args) {
        int[] fruits = {1,0,1,4,1,4,1,2,3};
        FruitsIntoBasket obj = new FruitsIntoBasket();
        System.out.println(obj.tFruits(fruits));
    }
}
