package Arrays;

import java.util.*;

public class faction {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int tc = scn.nextInt();

        int count = 1;
        while (count<=tc){
            int r = scn.nextInt();
            int c = scn.nextInt();

            String[][] maps = new String[r][c];
            boolean[][] visited= new boolean[r][c];
            HashSet<String> tempFractions = new HashSet<>();
            TreeMap<String,Integer> fractions = new TreeMap<String,Integer>();

            for (int i = 0; i < r; i++) {
                String str = scn.next();
                for (int j = 0; j < str.length(); j++) {
                    maps[i][j] = String.valueOf(str.charAt(j));
                    visited[i][j] = false;
                }
            }

            int cqr = 0;
            for (int j = 0; j < r; j++) {
                for (int k = 0; k < c; k++) {
                    tempFractions.clear();

                    findAndContest(maps,visited,tempFractions,r,c,j,k);

                    Iterator<String> tempITR = tempFractions.iterator();
                    if(tempFractions.size() > 1){
                        cqr++;
                    }else{
                        while(tempITR.hasNext()){
                            String fct = tempITR.next();
                            if(fractions.get(fct) != null){
                                fractions.put(fct, fractions.get(fct)+1);
                            }else
                                fractions.putIfAbsent(fct, 1);
                        }
                    }
                }
            }

            System.out.println("Case "+count+":");
            for(Map.Entry<String,Integer> entry : fractions.entrySet()) {
                String key = entry.getKey();
                Integer val = entry.getValue();

                System.out.println(key+" "+val);
            }
            System.out.println("contested "+cqr);
            count++;
        }
    }

    public static void findAndContest(String[][] maps,boolean[][] visited,HashSet<String> tempFraction,int row, int col,int x, int y){ //Map< String,Integer> fractions
        if(x < 0 || x >= row || y < 0 || y >= col || visited[x][y]){
            return;
        }

        visited[x][y] = true;
        if(maps[x][y].equals("#")){
            return;
        }
        if(!maps[x][y].equals(".")){
            tempFraction.add(maps[x][y]);
        }

        findAndContest(maps,visited,tempFraction,row,col,x,y+1);
        findAndContest(maps,visited,tempFraction,row,col,x,y-1);
        findAndContest(maps,visited,tempFraction,row,col,x+1,y);
        findAndContest(maps,visited,tempFraction,row,col,x-1,y);

    }

}
