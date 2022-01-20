package Practice;

import java.util.HashMap;
import java.util.HashSet;

public class FoodStalls {
    public static void main(String[] args) {

    }
    private int coupons(int input1, int input2, int[][] input3, int[][] input4, int input5, int[][] input6) {
        HashMap<Integer, HashSet<Integer>> friends = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> shops = new HashMap<>();
        for (int i = 0; i < input2; i++) {
            for (int j = 0; j < 10; j++) {
                if (input3[i][j] == 1) {
                    shops.putIfAbsent(j + 1, new HashSet<>());
                    shops.get(j + 1).add(i + 1);
                }
            }
        }
        for (int i = 0; i < input1; ++i) {
            for (int j = 0; j < 10; ++j) {
                if (input4[i][j] == 1) {
                    friends.putIfAbsent(j + 1, new HashSet<>());
                    friends.get(j + 1).add(i + 1);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < input5; ++i) {
            int person = input6[i][0];
            int stall = input6[i][1];
            for (int j = 1; j <= 10; j++) {
                if (shops.get(j).contains(stall) && friends.get(j).contains(person)) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }

}
