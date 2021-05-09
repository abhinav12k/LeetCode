package HackWithInfyGuidedPath.SearchingAndSorting;

public class firstAndLastPos {

    public static void main(String[] args) {

        int[] arr = new int[]{-10, -5, -5, -5, 2};
//        System.out.println(getFirstAndLastPos(arr,arr.length,-5));
//        System.out.println(getFirstAndLastUsingBinarySearch(arr, arr.length, -5));
        System.out.println(getFirstAndLastOccurrenceRecursiveSolution(arr,-5));
    }

    private static Pair getFirstAndLastUsingBinarySearch(int[] arr, int n, int x) {
        Pair p = new Pair();
        p.x = getFirstOccurrence(arr, x);
        p.y = getLastOccurrence(arr, x);
        return p;
    }

    private static int getFirstOccurrence(int[] arr, int x) {
        int lo = 0;
        int hi = arr.length - 1;
        int res = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == x) {
                res = mid;
                hi = mid - 1;
            } else if (arr[mid] < x) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return res;
    }

    private static int getLastOccurrence(int[] arr, int x) {
        int lo = 0;
        int hi = arr.length - 1;
        int res = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == x) {
                res = mid;
                lo = mid + 1;
            } else if (arr[mid] > x) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return res;
    }

    private static Pair getFirstAndLastPos(int[] arr, int n, int x) {

        Pair p = new Pair();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == x) {
                if (count == 0) {
                    p.x = i;
                    count++;
                }
                p.y = i;
            }
        }
        return p;
    }

    private static Pair getFirstAndLastOccurrenceRecursiveSolution(int[] arr, int x) {

        Pair p = new Pair();
        p.x = getFirstOccurrenceRecursive(arr,x,0,arr.length-1);
        p.y = getSecondOccurrenceRecursive(arr,x,0,arr.length-1);
        return p;
    }

    private static int getFirstOccurrenceRecursive(int[] arr, int x, int lo, int hi) {

        if (hi >= lo) {
            int mid = lo + (hi - lo) / 2;
            if ((mid == 0 || x > arr[mid - 1]) && arr[mid] == x)
                return mid;
            else if (x > arr[mid])
                return getFirstOccurrenceRecursive(arr, x,mid+1,hi);
            else
                return getFirstOccurrenceRecursive(arr, x, lo, (mid - 1));
        }
        return -1;
    }

    private static int getSecondOccurrenceRecursive(int[] arr, int x, int lo, int hi) {

        if (lo > hi) {
            return -1;
        }

        int mid = lo + (hi - lo) / 2;
        if ((mid == arr.length - 1 || arr[mid + 1] > x) && arr[mid] == x) {
            return mid;
        } else if (x < arr[mid]) {
            return getSecondOccurrenceRecursive(arr, x, lo, mid - 1);
        } else {
            return getSecondOccurrenceRecursive(arr, x, mid + 1, hi);
        }
    }

    private static class Pair {
        int x = -1;
        int y = -1;

        @Override
        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

}
