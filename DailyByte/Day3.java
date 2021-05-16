package DailyByte;

public class Day3 {

    public static void main(String[] args) {

        //Vacuum cleaner
        String str = "LR";
        System.out.println(isItPossibleToReturn(str));
    }

    private static boolean isItPossibleToReturn(String str) {

        int x = 0, y = 0;

        for (char c : str.toCharArray()) {
            if (c == 'R') {
                x++;
            } else if (c == 'L')
                x--;
            else if (c == 'D')
                y--;
            else
                y++;
        }
        return x == 0 && y == 0;
    }

}
