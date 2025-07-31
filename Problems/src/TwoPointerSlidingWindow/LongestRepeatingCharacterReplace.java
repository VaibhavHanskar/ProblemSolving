package TwoPointerSlidingWindow;

public class LongestRepeatingCharacterReplace {
        public int characterReplacement(String s, int k) {
            if(s.length() == 1){
                return 1;
            }
            if(s.length() == k){
                return k;
            }
            int maxFreq = 0;
            int maxLen = 0;
            int[] charFreq = new int[26];
            int i=0;
            int j=0;
            while(j<s.length()){
                charFreq[s.charAt(j) - 'A']++;
                maxFreq = Math.max(maxFreq , charFreq[s.charAt(j) - 'A'] );
                if((j-i+1) - maxFreq <= k){
                    maxLen = Math.max(maxLen, j-i+1);
                }
                else{
                    while(j-i+1 - maxFreq > k){
                        charFreq[s.charAt(i) - 'A']--;
                        maxFreq = charFreq[0];
                        for(int x=1;x<26;x++){
                            maxFreq  = Math.max(maxFreq,charFreq[x]);
                        }
                        i++;
                    }
                }
                j++;
            }
            return maxLen;
        }

    public int charReplace(String s, int k){
        if(s.length() == 1){
            return 1;
        }

        int max_length = 0;
        for(int i=0;i<s.length();i++){
            int[] freq = new int[26];
            int max_freq = 0;
            for(int j=i;j<s.length();j++){
                freq[s.charAt(j) - 'A']++;
                max_freq = Math.max(max_freq,freq[s.charAt(j) - 'A']);
                if((j-i+1) - max_freq <= k){
                    max_length = Math.max(max_length, j-i+1);
                }
                else{
                    break;
                }
            }
        }
        return max_length;
    }

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        LongestRepeatingCharacterReplace obj = new LongestRepeatingCharacterReplace();
        int ans = obj.characterReplacement(s,k);
        System.out.println(ans);
    }
}
