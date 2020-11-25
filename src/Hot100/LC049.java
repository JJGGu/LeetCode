package Hot100;

import java.util.*;

/**
 * @program: LeetCode
 * @description: 字母异位词分组
 * @author: JJGGu
 * @create: 2020-10-30 14:31
 **/
public class LC049 {
    public static void main(String[] args) {
        List<List<String>> lists = groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        for (List list: lists){
            System.out.println(list.toString());
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return null;
        }
        return fun1(strs);
    }

    private static List<List<String>> fun1(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s: strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String string = Arrays.toString(chars);
            if (map.containsKey(string)) {
                List<String> list = map.get(string);
                list.add(s);
            } else {
                List<String> arrayList = new ArrayList<>();
                arrayList.add(s);
                map.put(string, arrayList);
                lists.add(arrayList);
            }
        }
        return lists;
    }
}
