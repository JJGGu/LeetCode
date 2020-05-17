/**
 * @program: LeetCode
 * @description: 1010. Pairs of Songs With Total Durations Divisible by 60
 * @author: 你的名字
 * @create: 2020-05-17 20:41
 **/
public class Solution {
    public static void main(String[] args) {
        int[] time = {30,20,150,100,40};
        System.out.println(numPairsDivisibleBy60(time));
    }

    static public int numPairsDivisibleBy60(int[] time) {
        int ans = 0;
        int[] remainder = new int[60];
        int len = time.length;
        for (int i = 0; i < len; i++) {
            int r = time[i] % 60;
            for (int j = 0; j < 60; j++) {
                if(r == j){
                    remainder[j]++;
                    break;
                }
            }
        }

        for (int i = 1; i < 30; i++) {
            ans += remainder[i] * remainder[60-i];
        }
        int temp = 0;
        for (int i = 1; i < remainder[30]; i++) {
            temp = temp + i;
        }
        ans = ans + temp;

        temp = 0;
        for (int i = 1; i < remainder[0]; i++) {
            temp = temp + i;
        }
        ans = ans + temp;
        return ans;
    }
}
