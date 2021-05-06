package Codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class sameDifferences {

    void solve(int TC) throws Exception {

        int n = ni();
        int[] arr = new int[n];
        HashMap<Integer,Integer> fmap = new HashMap<>();

        for(int i=0;i<n;i++) {
            arr[i] = ni();
            fmap.put(arr[i]-i,1+fmap.getOrDefault(arr[i]-i,0));
        }
//        pn(fmap);
        long count=0;
        for(Integer val: fmap.values()){
            //bcoz we select pairs
            count+=((long) (val - 1) *val/2);
        }
        pn(count);
    }


    public static void main(String[] args) throws java.lang.Exception {
        new sameDifferences().run();
    }

    static boolean multipleTC = true;
    static FastReader in;
    static PrintWriter out;

    void run() throws Exception {
        in = new FastReader();
        out = new PrintWriter(System.out);
        int T = (multipleTC) ? ni() : 1;
        for (int t = 1; t <= T; t++)
            solve(t);
        out.flush();
        out.close();
    }

    int bit(long n) {
        return (n == 0) ? 0 : (1 + bit(n & (n - 1)));
    }

    void p(Object o) {
        out.print(o);
    }

    void pn(Object o) {
        out.println(o);
    }

    void pni(Object o) {
        out.println(o);
        out.flush();
    }

    String n() throws Exception {
        return in.next();
    }

    String nln() throws Exception {
        return in.nextLine();
    }

    int ni() throws Exception {
        return Integer.parseInt(in.next());
    }

    long nl() throws Exception {
        return Long.parseLong(in.next());
    }

    double nd() throws Exception {
        return Double.parseDouble(in.next());
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
