package Strings;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int ans =0;
        int n = s.length();
        if(n == 1){
            ans = map.get(s.charAt(0));
            return ans;
        }

        char[] charArr = s.toCharArray();
        ans += map.get(charArr[n-1]);
        for(int i=n-2;i>=0;i--){
            if(charArr[i] == 'I' &&(charArr[i+1] == 'V' || charArr[i+1] == 'X')){
                ans -= map.get(charArr[i]);
            }
            else if(charArr[i] == 'X' &&(charArr[i+1] == 'L' || charArr[i+1] == 'C')){
                ans -= map.get(charArr[i]);
            }
            else if(charArr[i] == 'C' &&(charArr[i+1] == 'D' || charArr[i+1] == 'M')){
                ans -= map.get(charArr[i]);
            }
            else{
                ans += map.get(charArr[i]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "MCMXCIV";
        RomanToInteger obj = new RomanToInteger();
        System.out.println(obj.romanToInt(s));
    }
}
