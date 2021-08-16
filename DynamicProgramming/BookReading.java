package DynamicProgramming;

import java.util.Arrays;

public class BookReading {
    public static void main(String[] args) {

        int books = 3;
        int time_limit = 7;
        int[] rewards = {2, 6, 9};
        int[] reading_time = {3, 5, 3};

        System.out.println(getMaxRewardsBottomUp(books, time_limit, rewards, reading_time));
        System.out.println(getMaxRewardsRecursive(books,time_limit,rewards,reading_time));

        container = new int[books+1][time_limit+1];
        System.out.println(getMaxRewardsTopDown(books,time_limit,rewards,reading_time));
    }

    private static int getMaxRewardsRecursive(int books, int time_limit, int[] rewards, int[] reading_time) {

        if (books == 0 || time_limit == 0) {
            return 0;
        }

        if (reading_time[books - 1] <= time_limit) {
            return Math.max(rewards[books - 1] + getMaxRewardsRecursive(books - 1, time_limit -
                    reading_time[books - 1], rewards, reading_time),
                    getMaxRewardsRecursive(books - 1, time_limit, rewards, reading_time));
        }
        return getMaxRewardsRecursive(books-1,time_limit,rewards,reading_time);
    }

    static int[][] container;
    private static int getMaxRewardsTopDown(int books,int time_limit,int[] rewards,int[] reading_time){

        if (books == 0 || time_limit == 0) {
            return 0;
        }

        if(container[books][time_limit]!=0)
            return container[books][time_limit];

        if (reading_time[books - 1] <= time_limit) {
            container[books][time_limit] = Math.max(rewards[books - 1] + getMaxRewardsRecursive(books - 1, time_limit -
                            reading_time[books - 1], rewards, reading_time),
                    getMaxRewardsRecursive(books - 1, time_limit, rewards, reading_time));
            return container[books][time_limit];
        }
        container[books][time_limit] = getMaxRewardsRecursive(books-1,time_limit,rewards,reading_time);
        return container[books][time_limit];
    }

    private static int getMaxRewardsBottomUp(int books, int time_limit, int[] rewards, int[] reading_time) {

        int[][] t = new int[books + 1][time_limit + 1];

        for (int i = 1; i <= books; i++) {
            for (int j = 1; j <= time_limit; j++) {
                if (reading_time[i - 1] <= j) {
                    t[i][j] = Math.max(t[i - 1][j], rewards[i - 1] + t[i - 1][j - reading_time[i - 1]]);
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        return t[books][time_limit];
    }

}
