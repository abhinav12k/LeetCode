package Arrays;

    import java.io.File;
    import java.io.FileNotFoundException;
    import java.io.PrintStream;
    import java.util.*;
    public class binarySearch {
        static int binarySearch2(int[] array, int value, int low, int high) {
            int mid;
            if (high < low) {
                return -1;
            } else {
                mid = (low + high)/2;
                if (array[mid] > value) {
                    return binarySearch2(array, value, low, mid-1);
                } else if (array[mid] < value) {
                    return binarySearch2(array, value, mid+1, high);
                } else {
                    return mid;
                }
            }
        }
        public static void main(String[] args) throws FileNotFoundException {
            Scanner sc = new Scanner(System.in);

            //Instantiating the File class
            File file = new File("/home/abhinav/IdeaProjects/LeetCode/Arrays/output.txt");
            //Instantiating the PrintStream class
            PrintStream stream = new PrintStream(file);
            System.out.println("From now on "+file.getAbsolutePath()+" will be your console");
            System.setOut(stream);

            int i, value, answer;
            int[] array = new int[10000];
            for (i=0; i<10000; i++) {
                array[i] = sc.nextInt();
            }
            for (i=0; i<10000; i++) {
                value = sc.nextInt();
                answer = binarySearch2(array, value, 0, 9999);
                System.out.printf("%d\n", answer);
            }
        }
    }


