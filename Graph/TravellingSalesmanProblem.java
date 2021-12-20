package Graph;

public class TravellingSalesmanProblem {

    static int tcp(int[][] dist, int setOfCities, int city, int n) {

        if (setOfCities == (1 << n) - 1) {
            return dist[city][0];
        }

        int ans = Integer.MAX_VALUE;
        for (int choice = 0; choice < n; choice++) {

            if((setOfCities & (1<<choice)) == 0){
                int subProblem = dist[city][choice] + tcp(dist,(setOfCities | (1<<choice)),choice,n);
                ans = Math.min(ans,subProblem);
            }

        }
        return ans;
    }

    public static void main(String[] args) {

        int[][] dist = {{0, 20, 42, 25},
                {20, 0, 30, 34},
                {42, 30, 0, 10},
                {25, 34, 10, 0}};

        System.out.println(tcp(dist, 1, 0, dist.length));

    }

}
