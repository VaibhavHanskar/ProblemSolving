//https://leetcode.com/problems/valid-anagram/description/
package Strings;

import java.util.HashMap;
import java.util.HashSet;

public class ValidAnagram {
    public boolean checkAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        if(s.length() == 1){
            if(s.charAt(0) ==  t.charAt(0)){
                return true;
            }
            return false;
        }
        HashMap<Character,Integer> mapS = new HashMap<>();
        HashMap<Character,Integer> mapT = new HashMap<>();
        for(int i=0;i<s.length();i++){
            mapS.put(s.charAt(i), mapS.getOrDefault(s.charAt(i),0)+1);
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i),0)+1);
        }

        if(mapS.size() != mapT.size()){
            return false;
        }

        for(int i=0;i<s.length();i++){
            if(!mapT.containsKey(s.charAt(i))){
                return false;
            }
            else{
                if(mapT.get(s.charAt(i)) != mapS.get(s.charAt(i))){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isAnagram(String s, String t){
        if(s.length() != t.length()){
            return false;
        }

        int[] countArr = new int[26];
        for(int i=0;i<s.length();i++){
            countArr[s.charAt(i)  - 'a']++;
            countArr[t.charAt(i)  - 'a']--;
        }

        for(int i=0;i<26;i++){
            if(countArr[i] != 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "snagram";
        String t = "nagaram";
        ValidAnagram obj = new ValidAnagram();
        System.out.println(obj.isAnagram(s,t));
    }
}
