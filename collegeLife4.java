import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class collegeLife4 {

    public static void main(String[] args) {
        FastReader scn = new FastReader();
        int tc = scn.nextInt();
        while (tc-- != 0) {

            int n = scn.nextInt();
            int e = scn.nextInt();
            int h = scn.nextInt();
            int[] price = new int[3];
            price[0] = scn.nextInt();
            price[1] = scn.nextInt();
            price[2] = scn.nextInt();
            

            PriorityQueue<PricePair> pq = new PriorityQueue<>(new Comparator<PricePair>() {
                @Override
                public int compare(PricePair o1, PricePair o2) {
                    return Integer.compare(o1.price, o2.price);
                }
            });

            for (int i = 0; i < 3; i++) {
                pq.add(new PricePair(i + 1, price[i]));
            }


            int minPrice = 0;
            int size = pq.size();
            boolean fl = false;
            for (int i = 0; i < size; i++) {
                PricePair p = pq.remove();
                if (p.dish == 1) {
                    //omelette
                    int omelette = e / 2;

                    omelette = Math.min(n, omelette);

                    e -= 2 * omelette;
                    n -= omelette;
                    minPrice += omelette * p.price;
                } else if (p.dish == 2) {
                    //shake
                    int shake = h / 3;
                    shake = Math.min(n, shake);

                    h -= 3 * shake;
                    n -= shake;
                    minPrice += shake * p.price;
                } else {
                    //cake
                    int maxCake = Math.min(e, h);
                    int cake = Math.min(maxCake, n);

                    e -= cake;
                    h -= cake;
                    n -= cake;
                    minPrice += cake * p.price;
                }
                if (n == 0) {
                    fl = true;
                    break;
                }
            }
            if (!fl)
                System.out.println(-1);
            else
                System.out.println(minPrice);

        }

    }

    static class PricePair {
        int dish;
        int price;

        PricePair(int dish, int price) {
            this.dish = dish;
            this.price = price;
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
