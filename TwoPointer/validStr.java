package TwoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class validStr {
    public static void main(String[] args) {

        FastReader scn = new FastReader();
        int tc = scn.nextInt();

        while (tc-- != 0) {

            int n = scn.nextInt();
            int c = scn.nextInt();
            String str = scn.next();

            ArrayList<Integer> idx = new ArrayList<>();
            for(int i=0;i<str.length();i++){
                if(str.charAt(i) == '1')
                    idx.add(i);
            }

            int cnt = 0;
            for(int i=1;i<idx.size();i++){
                if((idx.get(i) - idx.get(i - 1)) - 1> c)
                    cnt++;
            }

            if(cnt > 1) {
                System.out.println("No");
                continue;
            }
            if(cnt == 1 && ((n-1)- idx.get(idx.size() - 1) + idx.get(0)) > c)
                System.out.println("No");
            else
                System.out.println("Yes");
        }

    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(
                    new InputStreamReader(System.in)
            );
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
    }

}
