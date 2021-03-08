package SlidingWindow;

public class maxScore {

    public static void main(String[] args) {

    }

    static class Solution {
        public int maxScore(int[] cardPoints, int k) {

            int tSum = 0;
            for(int num: cardPoints)
                tSum+=num;

            System.out.println(tSum);
            int n = cardPoints.length;
            if(n==k)
                return tSum;

            int winSize = n - k;
            int score =0;
            for(int i=0;i<winSize;i++){
                score += cardPoints[i];
            }

            int maxScore = tSum - score;
            for(int i=0;i<k;i++){
                score = score - cardPoints[i] + cardPoints[i+winSize];
                maxScore = Math.max(maxScore,tSum - score);
            }
            return maxScore;
        }
    }
}
