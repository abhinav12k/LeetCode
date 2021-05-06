package Codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ordinaryNumbers {

    static void solve(int TC) throws Exception {

        int n = ni();

        if (n < 10) {
            System.out.println(n);
        } else {

            int[] a = new int[9];
            for(int i=0;i<9;i++)
                a[i]=i+1;
            int count=9;
            while(true){
                int fl=0;
                for(int i=0;i<a.length;i++){

                    int val=10*a[i]+i+1;
                    if(val<=n)
                        count++;
                    else{
                        fl=1;
                        break;
                    }
                    a[i] = val;
                }
                if(fl==1)
                    break;
            }
            pn(count);
        }

    }


    public static void main(String[] args) throws java.lang.Exception {
        run();
    }

    static boolean multipleTC = true;
    static FastReader in;
    static PrintWriter out;

    static void run() throws Exception {
        in = new FastReader();
        out = new PrintWriter(System.out);
        int T = (multipleTC) ? ni() : 1;
        for (int t = 1; t <= T; t++)
            solve(t);
        out.flush();
        out.close();
    }

    static int bit(long n) {
        return (n == 0) ? 0 : (1 + bit(n & (n - 1)));
    }

    static void p(Object o) {
        out.print(o);
    }

    static void pn(Object o) {
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

    static int ni() throws Exception {
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
