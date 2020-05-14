import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        String s = "abcabda";
        System.out.println(lengthOfLongestSubstring(s));
    }
    //version1 暴力解法， 超时了
//    static public int lengthOfLongestSubstring(String s) {
//        int len = s.length();
//        char[] c = s.toCharArray();
//        int max = 0;
//        int flag = 0;
//        for (int i = 0; i < len; i++) {
//            for (int j = i; j < len; j++) {
//                String temp = s.substring(i, j+1);   //注意截取子串的范围
//                flag = 0;
//                for (int k = 0; k < temp.length(); k++) {
//                    for (int l = k+1; l < temp.length(); l++) {
//                        if (temp.charAt(l) == temp.charAt(k)){
//                            flag = 1;
//                            break;
//                        }
//                    }
//                    if (flag == 1){
//                        break;
//                    }
//                }
//                if(flag == 0){
//                    if (max < temp.length()){
//                        max = temp.length();
//                    }
//                }
//            }
//        }
//        return max;
//    }

    //version 2 滑动窗口
    static public int lengthOfLongestSubstring(String s){
        HashSet<Character> set = new HashSet<>();
        int len = s.length();
        int max = 0;
        int end = -1;
        for (int i = 0; i < len; i++) {
            if(i != 0){
                set.remove(s.charAt(i-1));
            }
            while(end + 1 < len && !set.contains(s.charAt(end + 1))){
                end++;
                set.add(s.charAt(end));
            }
            max = Math.max(max, set.size());
        }
        return max;
    }
}
