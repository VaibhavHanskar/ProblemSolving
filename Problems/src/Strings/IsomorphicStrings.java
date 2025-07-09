//https://leetcode.com/problems/isomorphic-strings/description/
package Strings;

import java.util.HashMap;

public class IsomorphicStrings {



    public boolean isIsomorphic(String s, String t){
        if(s.length() != t.length() && s == t){
            return false;
        }
        HashMap<Character,Integer> mapS = new HashMap<>();
        HashMap<Character,Integer> mapT = new HashMap<>();

        for(int i=0;i<s.length();i++){
            if(!mapS.containsKey(s.charAt(i))){
                mapS.put(s.charAt(i),i);
            }
            if(!mapT.containsKey(t.charAt(i))){
                mapT.put(t.charAt(i),i);
            }

            if(!mapS.get(s.charAt(i)).equals(mapT.get(t.charAt(i)))){
                return false;
            }
        }
        return true;
    }

    public boolean isomorphic(String s, String t){
        if(s.length() != t.length() && s == t){
            return false;
        }

        HashMap<Character,Character> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(!map.containsKey(s.charAt(i))){
                if(!map.containsValue(t.charAt(i))){
                    map.put(s.charAt(i),t.charAt(i));
                }
                else{
                    return false;
                }
            }
            else{
                if(map.get(s.charAt(i)) != t.charAt(i)){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "bbbaaaba";
        String t = "aaabbbba";
        IsomorphicStrings obj = new IsomorphicStrings();
        boolean ans = obj.isomorphic(s,t);
        System.out.println(ans);
    }
}
