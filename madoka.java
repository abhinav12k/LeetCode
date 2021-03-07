import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class madoka {

    public static void main(String[] args) {

        FastReader scn = new FastReader();
        int tc = scn.nextInt();
        while (tc-- != 0) {

            int n = scn.nextInt();
            int[] arr = new int[n];
            int sum=0;
            for(int i=0;i<n;i++){
                arr[i] = scn.nextInt();
            }
            Arrays.sort(arr);
            boolean isValid = true;
            for(int k = 1;k<=n;k++){
                if(k - arr[k-1]<0){
                    isValid = false;
                    break;
                }
                sum+= k - arr[k-1];
            }
            if(!isValid) {
                System.out.println("Second");
                continue;
            }
            if (sum % 2 == 0) {
                System.out.println("Second");
            } else {
                System.out.println("First");
            }
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
