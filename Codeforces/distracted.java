package Codeforces;

import java.util.Scanner;

public class distracted {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int tc = scn.nextInt();
        while (tc-- != 0) {

            int n = scn.nextInt();
            String q = scn.next();
            boolean[] visited = new boolean[26];
            int fl = 0;
            for(int i=0;i<n;i++){
                char c = q.charAt(i);
                if(visited[c-'A']) {
                    fl = 1;
                    break;
                }
                while(i+1<n && q.charAt(i+1) == c){
                    i++;
                }
                visited[c-'A'] = true;
            }

            if(fl==0){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
