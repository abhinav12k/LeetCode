package Arrays;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class permutation {
    static int bitmask;
    static ArrayList<Character> characters;
    static ArrayList<Character> running;

    static void permutations() {
        int i;
        if (running.size() == characters.size()) {
            StringBuilder s = new StringBuilder();
            for (char c : running) {
                s.append(c);
            }
            System.out.printf("%s\n", s.toString());
        } else {
            for (i = 0; i < characters.size(); i++) {
                if (((bitmask >> i) & 1) == 0) {
                    bitmask |= (1 << i);
                    running.add(characters.get(i));
                    permutations();
                    bitmask ^= 1<<i;
                    running.remove(running.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        int i;
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        characters = new ArrayList<Character>();
        for (i = 0; i < s.length(); i++) {
            characters.add(s.charAt(i));
        }
        //Instantiating the File class
        File file = new File("/home/abhinav/IdeaProjects/LeetCode/Arrays/output.txt");
        //Instantiating the PrintStream class
        PrintStream stream = new PrintStream(file);
        System.out.println("From now on "+file.getAbsolutePath()+" will be your console");
        System.setOut(stream);
        running = new ArrayList<Character>();
        bitmask = 0;
        permutations();

    }
}

