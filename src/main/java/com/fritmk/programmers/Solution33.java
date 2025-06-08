import java.util.Arrays;
public class Solution33 {

    private static int[] set;

    public int solution(int n, int[][] costs) {

        Arrays.sort(costs, (o1,o2) -> Integer.compare(o1[2], o2[2]));

        set = new int[n];
        for(int i = 0; i < n; i++) {
            set[i] = i;
        }

        int result = 0;
        int edges = 0;

        for(int[] edge : costs) {
            if(edges == n - 1) {
                break;
            }

            if(findRoot(edge[0]) != findRoot(edge[1])){
                union(edge[0], edge[1]);
                result += edge[2];
                edges++;
            }



        }
        return result;
    }


    public int findRoot(int x) {
        if(set[x] == x) {
            return x;
        }
        set[x] = findRoot(set[x]);
        return set[x];
    }


    public void union(int x, int y) {
        int xRoot = findRoot(x);
        int yRoot = findRoot(y);
        if(xRoot < yRoot) {
            set[yRoot] = xRoot;
        } else {
            set[xRoot] = yRoot;
        }
    }
}