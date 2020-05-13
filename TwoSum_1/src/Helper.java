import java.util.Scanner;

public class Helper {
    public int[] readStr(){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strs = str.split(",");
        int len = strs.length;
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = Integer.parseInt(strs[i].trim());
        }
        return nums;
    }
}
