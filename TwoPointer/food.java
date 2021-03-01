package TwoPointer;

import java.util.Scanner;

public class food {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int tc = scn.nextInt();

        while (tc--!=0){

            int d = scn.nextInt();
            int c = scn.nextInt();

            int day1cost = 0;
            for(int i=0;i<3;i++){
                day1cost+=scn.nextInt();
            }

            int day2cost = 0;
            for(int i=0;i<3;i++){
                day2cost+=scn.nextInt();
            }

            if(day1cost>=150 && day2cost >= 150){
                int cost = day1cost + day2cost;
                if(cost + c < cost + 2*d){
                    System.out.println("Yes");
                }else{
                    System.out.println("No");
                }
            }else if(day1cost < 150 && day2cost >= 150){
                int cost = day1cost + day2cost + d;
                if(cost + c < cost + d){
                    System.out.println("Yes");
                }else{
                    System.out.println("No");
                }
            }else if(day2cost < 150 && day1cost >= 150){
                int cost = day1cost + day2cost + d;
                if(cost + c < cost + d){
                    System.out.println("Yes");
                }else{
                    System.out.println("No");
                }
            }else{
                System.out.println("No");
            }

        }
    }
}
