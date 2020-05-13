import java.util.ArrayList;

public class AddTwoNumbers {
    public static void main(String[] args) {
        int[] nums1 = {5};
        int[] nums2 = {5};
        ListNode l1 = Solution.create(nums1);
        ListNode l2 = Solution.create(nums2);
        ListNode l3 = Solution.addTwoNumbers(l1, l2);
        ListNode temp = l3;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }

    }
}
