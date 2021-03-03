package TwoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class admit {

    public static void main(String[] args) {

        FastReader scn = new FastReader();
        int tc = scn.nextInt();
        PrintWriter out = new PrintWriter(System.out);

        // Will give tle - Approach 1
//        while (tc--!=0){
//            int nC = scn.nextInt();
//            int nS = scn.nextInt();
//
//            int[] cR = new int[nC];
//            rp[] sR = new rp[nS];
//            boolean[] free = new boolean[nC];
//            for(int i=0;i<nC;i++){
//                cR[i] = scn.nextInt();
//                free[i] = true;
//            }
//
//            for(int i=0;i<nS;i++){
//                sR[i] = new rp(scn.nextInt(),i);
//            }
//            Arrays.sort(sR, Comparator.comparingInt((rp o) -> o.rank));
//
//            Integer[][] prefList = new Integer[nS][];
//            for(int i=0;i<nS;i++){
//                //Preference lists
//
//                int size = scn.nextInt();
//                Integer[] cList = new Integer[size];
//                for(int k=0;k<size;k++){
//                    cList[k] = scn.nextInt();
//                }
//                Arrays.sort(cList, Comparator.comparingInt(o -> cR[o-1]));
//                prefList[i] = cList;
//
//            }
//
//            int ans = 0;
//            for(int i=0;i<sR.length;i++) {
//                int pos = sR[i].pos;
//                for (int college : prefList[pos]) {
//                    if (free[college - 1]) {
//                        free[college - 1] = false;
//                        if (pos == 0)
//                            ans = college;
//                        break;
//                    }
//                }
//            }
//            System.out.println(ans);
//        }

        //Approach 2
        while(tc--!=0){

            int nc = scn.nextInt();
            int ns = scn.nextInt();

            int[] collegeRank = new int[nc];

            for(int i=0;i<nc;i++){
                collegeRank[i] = (scn.nextInt());
            }

            student[] std = new student[ns];
            for(int i=0;i<ns;i++){

                student nstd = new student();
                nstd.id = i;
                nstd.rank = scn.nextInt();
                std[i] = nstd;

            }

            for(int i=0;i<std.length;i++){

                int size = scn.nextInt();
                int[] prefList = new int[size];
                for(int k=0;k<prefList.length;k++){
                    prefList[k] = scn.nextInt();
                }

                std[i].prefList = prefList;

            }

            Arrays.sort(std, Comparator.comparingInt(o -> o.rank));

//            for(student student: std){
//                int ans = 0;
//                int maxRank = Integer.MAX_VALUE;
//
//                for(int collegeID : student.prefList){
//
//                    if(collegeRank.containsKey(collegeID)){
//
//                        int rank = collegeRank.get(collegeID);
//                        if(rank < maxRank){
//                            maxRank = rank;
//                            ans = collegeID;
//                        }
//
//                    }
//
//                }
//                if(student.id == 0){
//                    System.out.println(ans);
//                    break;
//                }
//                collegeRank.remove(maxRank);
//
//            }

            boolean[] available = new boolean[nc];
            Arrays.fill(available, true);
            int ans = -1;
            for(student s:std){
                int assigned = -1;
                for(int college:s.prefList){
                    if(!available[college])
                        continue;
                    if(assigned == -1 || collegeRank[college] < collegeRank[assigned])
                        assigned = college;
                }
                if(assigned != -1)available[assigned] = false;
                if(s.id == 0){
                    ans = assigned;
                    break;
                }
            }

            out.println(ans);

        }
        out.flush();
        out.close();

    }

    private static class student{
        int id, rank;
        int[] prefList;
    }


    private static class rp{
        int rank;
        int pos;
        rp(int rank,int pos){
            this.rank = rank;
            this.pos = pos;
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
