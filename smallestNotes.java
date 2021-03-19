import java.util.Scanner;

public class smallestNotes {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int tc = scn.nextInt();
        int[] denom = {1, 2, 5, 10, 50, 100};
        while (tc-- != 0) {

            int sum = scn.nextInt();
            int min = 0;
            for (int i = denom.length - 1; i >= 0; i--) {

                int rem = sum % denom[i];
                min += sum / denom[i];
                sum = rem;

            }
            System.out.println(min);
        }

    }

}
