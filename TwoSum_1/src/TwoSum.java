import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        Helper helper = new Helper();
        int[] nums = helper.readStr();
        int target = 6;
        int[] results = twoSum_v3(nums, target);
        for(int i: results){
            System.out.println(i);
        }

    }

    //暴力法解
    public static int[] twoSum_v1(int[] nums, int target){
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if(nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("no such twoSum");
    }

    //hashmap  两次遍历
    public static int[] twoSum_v2(int[] nums, int target){
        Map<Integer, Integer> hmap = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            hmap.put(nums[i], i);
        }
        System.out.println(hmap);
        for (int i = 0; i < len; i++) {
            int complement = target - nums[i];
            if(hmap.containsKey(complement) && hmap.get(complement) != i){
                return new int[]{i, hmap.get(complement)};
            }
        }
        throw new IllegalArgumentException();
    }

    //一次遍历完成
    public static int[] twoSum_v3(int[] nums, int target){
        Map<Integer, Integer> hmap = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            hmap.put(nums[i], i);
            int complement = target - nums[i];
            if(hmap.containsKey(complement) && hmap.get(complement) != i){
                return new int[]{i, hmap.get(complement)};
            }
        }
        throw new IllegalArgumentException();
    }
}
