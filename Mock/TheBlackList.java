package Mock;

public class TheBlackList {

    /**
     * Raymond "Red" Reddington is a wanted fugitive. Agent Elizabeth Keen is tasked to catch him.
     * But Reddington is smart. He kidnaps Agent Keen before she can catch up to him. He decides to
     * give Agent Keen a fair chance for her life. Reddington loves the game of chess and challenges Agent
     * Keen to a match. Reddington has made slight changes in the game of chess. He has designed a variation
     * of the game. In this variation, the board is of size N * N and she has allowed only 1 piece i.e. Rook.
     * Now, he explains the rules to Agent Keen. He says -
     * 1. I will give you K rook pieces. Each rook piece will have a row and a column and a power value attached to it.
     * 2. Rook can attack on all fields in its row and column.
     * 3. A field is called as super-attackable if the binary XOR of all the power of the rooks that can attack
     * the field is greater than 0.
     * He further adds - "So, Initially I have placed the rooks in a certain layout at K different fields.
     * Now, I will make P moves. You have to tell number of super-attackable fields after each move.
     * Each rook can be moved to any free field on the whole board(not only across its column and row)."
     * It is guaranteed that there will not be two rooks on one field at any point. You have to help Agen
     * Keen solve this riddle and save herself from Reddington.
     *
     * Input Format:
     *
     * The first line of input contains integers N, K, P (1 <= N <= 1000000000, 1 <= K <= 100000, 1 <= P <= 100000)
     * Each of the following K lines contains integers: R, C, X, where R and C are row and column where rook is
     * placed and X is the associated power value with it. It is given that 1 <= R, C <= N and 1 <= X <= 1000000000
     * Each of following P lines contain four integers R1, C1, R2, C2. We have to shift rook from (R1, C1)
     * to (R2, C2). It is given that 1<= R1, C1, R2, C2 <= N.
     *
     * Constraints:
     *
     * Time Limit: 1 second
     *
     * Output Format:
     *
     * The output must consist of P lines where ith line contains total number of super-attackable fields after
     * i moves.
     *
     * Sample Test Cases:
     * Sample Input 1:
     *
     * 2 2 2
     * 1 1 1
     * 2 2 1
     * 2 2 2 1
     * 1 1 1 2
     *
     * Sample Output 1:
     *
     * 4
     * 0
     *
     * Explanation for test case:
     *
     * After the first move, every field on the board is super-attackable.
     * For example: (1, 1) can only be attacked by one rook, so, XOR for (1, 1) is 1.
     * After the second move, none of the fields are super-attackable.
     * For example: field (1, 1) is seen by both rooks so the total XOR field (1, 1) is 0.
     * **/

    public static void main(String[] args) {



    }

}
