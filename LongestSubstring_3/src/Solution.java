import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        String s = "pwwekw";
        System.out.println(lengthOfLongestSubstring(s));
    }
    static public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        char[] c = new char[len];
        c = s.toCharArray();
        int count = 0;
        int max = 0;
        for (int i = 0; i < len-1; i++) {
            if(c[i] != c[i+1]){
                count++;
                if (max < count){
                    max = count;
                }
            }
            if (c[i] == c[i+1]){
                count = 0;
            }
        }
        return max;
    }
}
