package Strings;

//Given a string s, sort it in decreasing order based on the frequency of the characters.
//The frequency of a character is the number of times it appears in the string.
//Return the sorted string. If there are multiple answers, return any of them.


import java.util.*;

public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        char[] charArr = s.toCharArray();
        for(int i=0;i<charArr.length;i++){
            map.put(charArr[i],map.getOrDefault(charArr[i],0)+1);
        }
        int n = charArr.length;
        char[] ans = new char[s.length()];
        for(int i=0;i<charArr.length;i++){
            if(i==0){
                ans[i] = charArr[i];
                continue;
            }
            if(map.get(charArr[i]) > map.get(ans[i-1]) || charArr[i] == ans[i-1]){
                ans[i] = charArr[i];
            }
            else{
                int j=i-1;
                while(j>=0 && map.get(ans[j]) >= map.get(charArr[i]) && ans[j] != charArr[i]){
                    char temp = ans[j];
                    ans[j] = charArr[i];
                    ans[j+1] = temp;
                    j--;
                }
            }
        }
        int l=0;
        int r=n-1;
        while(l<r){
            char temp  = ans[l];
            ans[l] = ans[r];
            ans[r] = temp;
            l++;
            r--;
        }
        return new String(ans);
    }

    public String freqSort(String s){
        char[] charArr = s.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i=0;i<charArr.length;i++){
            map.put(charArr[i],map.getOrDefault(charArr[i],0)+1);
        }

        Map<Integer,ArrayList<Character>> counterMap = new TreeMap<>(Collections.reverseOrder());
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            if(counterMap.containsKey(entry.getValue())){
                ArrayList<Character> list = counterMap.get(entry.getValue());
                list.add(entry.getKey());
                counterMap.put(entry.getValue(), list);
            }
            else {
                counterMap.put(entry.getValue(), new ArrayList<>(Arrays.asList(entry.getKey())));
            }
        }
        StringBuilder ans  = new StringBuilder();
        for(Map.Entry<Integer,ArrayList<Character>> entry : counterMap.entrySet()){
            int count = entry.getKey();
            ArrayList<Character> list = entry.getValue();

            for(char c:list){
                for(int i=0;i<count;i++){
                    ans.append(c);
                }
            }
        }

        return ans.toString();
    }
    public static void main(String[] args) {
        String s = "dacca";
        SortCharactersByFrequency obj = new SortCharactersByFrequency();
        System.out.println(obj.freqSort(s));
    }
}
