import java.util.ArrayList;

public class AddTwoNumbers {
    public static void main(String[] args) {
        int[] nums1 = {2, 4, 3};
        int[] nums2 = {5, 6, 4};
        ListNode l1 = Solution.create(nums1);
        ListNode l2 = Solution.create(nums2);
        ListNode l3 = Solution.addTwoNumbers(l1, l2);
        ListNode temp = l3.next;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }

    }
}
