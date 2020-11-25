package Hot100;

import java.util.*;

/**
 * @program: LeetCode
 * @description: LRU缓存机制
 * @author: JJGGu
 * @create: 2020-11-09 16:53
 **/
public class LRUCache {
    Map<Integer, Integer> map;
    List<Integer> list;
    int capacity;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        list = new LinkedList<>();
        this.capacity = capacity;
    }

    // 判断map中有没有然后从中取出,并调整list中的位置
    public int get(int key) {
        if (map.containsKey(key)) {
            list.remove((Integer) key);
            list.add(0, key);
            return map.get(key);
        } else {
            return -1;
        }
    }

    // 满了就从最后删除
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            if (map.get(key) != value) {
                map.replace(key, value);
            }
            list.remove((Integer)key);
            list.add(0, key);
        } else {
            map.put(key, value);
            list.add(0, key);
        }
        if (list.size() > capacity) {
            Integer last = list.get(list.size() - 1);
            map.remove(last);
            list.remove(list.size() - 1);
        }
    }
}
