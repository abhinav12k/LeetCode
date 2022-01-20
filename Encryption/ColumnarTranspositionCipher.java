package Encryption;

import java.util.ArrayList;
import java.util.Scanner;

public class ColumnarTranspositionCipher {

    private static final int KEY_SIZE = 5;

    private static String encryptString(String str) {

        String[] strings = str.split(" ");
        str = "";
        for(String s: strings)
            str+=s;
        System.out.println(str);
        int n = str.length();
        int row = n / KEY_SIZE;
        int col = KEY_SIZE;
        if (n % KEY_SIZE > 0)
            row++;

        char[][] arr = new char[row][col];
        int idx = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (idx < n)
                    arr[i][j] = str.charAt(idx++);
                else
                    arr[i][j] = '_';
            }
        }

        int[] key = new int[KEY_SIZE];
        key[0] = 3;
        key[1] = 2;
        key[2] = 5;
        key[3] = 1;
        key[4] = 4;

        StringBuilder encryptedMsg = new StringBuilder();
        for(int k: key){
            for(int i=0;i<row;i++){
                encryptedMsg.append(arr[i][k-1]);
            }
        }
        return encryptedMsg.toString();
    }

    private void permuteKey(int[] key, ArrayList<ArrayList<Integer>> permutedKeys, ArrayList<Integer> ans) {
        if (ans.size() == key.length) {
            permutedKeys.add(new ArrayList<>(ans));
            return;
        }
        for (int i = 0; i < key.length; i++) {
            if (ans.contains(key[i]))
                ans.add(key[i]);
            permuteKey(key, permutedKeys, ans);
            ans.remove(ans.size() - 1);
        }

    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the string to be encrypted ");
        String userText = scn.nextLine();

        String encryptedString = encryptString(userText);
        System.out.println("Encrypted String: " + encryptedString);
    }

}
