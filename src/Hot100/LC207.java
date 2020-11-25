package Hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 课程表
 * @author: JJGGu
 * @create: 2020-11-13 14:39
 **/
public class LC207 {
    List<List<Integer>> edges = new ArrayList<>();
    boolean result = true;
    int[] visit; // 0表示未访问，1表示正好在该dfs的路径中，2已经完成访问
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visit = new int[numCourses];
        // 根据节点创建邻接表
        for (List list: edges) {
            list = new ArrayList<Integer>();
        }
        for (int[] edge : prerequisites) {
            edges.get(edge[0]).add(edge[1]);
        }

        for (int i = 0; i < numCourses && result; i++) {
            if (visit[i] == 0) {
                dfs(i);
            }
        }
        return result;
    }
    // 方法1.深度优先
    private void dfs(int u) {
        visit[u] = 1;
        for (int v: edges.get(u)) {
            if (visit[v] == 0) {
                dfs(v);
                if (!result) {
                    return;
                }
            } else if (visit[v] == 1) {
                result = false;
                return;
            }
        }
        visit[u] = 2;
    }

}
