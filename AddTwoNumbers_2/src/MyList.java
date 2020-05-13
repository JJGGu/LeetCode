import com.sun.org.apache.bcel.internal.generic.LNEG;

import java.util.ArrayList;
import java.util.List;

class Solution{
    static public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode temp = null;
        int[] nums1 = getListVal(l1);
        int[] nums2 = getListVal(l2);
        String str1 = "";
        String str2 = "";
        for(int num: nums1){
            str1 += num + "";
        }
        for (int num: nums2){
            str2 += num + "";
        }
        int result = Integer.parseInt(str1) + Integer.parseInt(str2);
        String str3 = String.valueOf(result);
        int len = str3.length();
        char[] ch = new char[len];
        ch = str3.toCharArray();
        int[] nums3 = new int[len];
        for (int i = 0; i < len; i++) {
            nums3[i] = (int)ch[i] - 48;
        }
        temp = create(nums3);
        return temp;
    }

    static public ListNode reverse(ListNode l1){
        //重新使用头插法创建
        ListNode temp = l1.next;
        int len = 0;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        temp = l1.next;
        int[] nums = new int[len];
        int i = 0;
        while(temp != null){
            nums[i] = temp.val;
            i++;
            temp = temp.next;
        }
        temp = create(nums);
        return temp;
    }

    static public ListNode create(int[] nums){
        ListNode first = new ListNode(0);
        first.next = null;
        ListNode temp = null;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            temp = new ListNode(nums[i]);
            temp.next = first.next;
            first.next = temp;
        }
        return first;
    }

    static private int[] getListVal(ListNode l){
        int len = 0;
        ListNode temp = l.next;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        int[] nums = new int[len];
        temp = l.next;
        int i = 0;
        while (temp != null) {
            nums[i] = temp.val;
            temp = temp.next;
            i++;
        }
        return nums;
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){val = x;}
}