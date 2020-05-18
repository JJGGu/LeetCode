import com.sun.scenario.animation.shared.ClipEnvelope;

/**
 * @program: LeetCode
 * @description: A conveyor belt has packages that must be shipped from one port to another within D days.
 * @create: 2020-05-17 21:52
 **/
public class Solution {
    public static void main(String[] args) {
        int[] weight = {3,2,2,4,1,4};
        int D = 3;
        System.out.println(shipWithinDays(weight, D));
    }
    //核心思路：不断减小最大载重量，找到最小的可载重的重量
    static public int shipWithinDays(int[] weights, int D) {
        //最小承载low，为货物中重量最大的 最大承载high，为总重量
        int low = 0 , high = 0, mid = 0;
        int len = weights.length;
        for (int i = 0; i < len; i++) {
            if(low < weights[i]){
                low = weights[i];
            }
        }

        for (int i = 0; i < len; i++) {
            high += weights[i];
        }

        while (low < high){
            mid = (low + high) / 2;
            //如果当前最大载重mid能在D天运完则需减小mid继续尝试
            int x = canShip(weights,mid,D);
            if(x == 2 || x == 0){
                low = mid+1;
            }else if(x == 1 ){
                high = mid;
            }
        }
        return high;

    }
    //M为最大运载力，D为天数
    static int canShip(int cargo[], int M, int D){
        int d = 0;
        int sum = 0;
        int len = cargo.length;
        for (int i = 0; i < len; i++) {
            sum += cargo[i];
            if (sum > M){
                sum = cargo[i];
                d++;
            }
        }
        System.out.println(d);
        if (d < D) {
            return 1;
        }else if (d > D){
            return 2;
        }
        else return 0;
        //test vcs
    }
}
