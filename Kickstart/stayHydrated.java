package Kickstart;

import java.util.Scanner;

public class stayHydrated {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int tc = scn.nextInt();
        int ct = 1;
        while (ct != tc + 1) {

            int n_obj = scn.nextInt();
            Rect[] objects = new Rect[n_obj];
            long x_min = Integer.MAX_VALUE;
            long y_min = Integer.MAX_VALUE;
            long x_max = Integer.MIN_VALUE;
            long y_max = Integer.MIN_VALUE;
            for (int i = 0; i < n_obj; i++) {
                Rect obj = new Rect();
                long x1 = scn.nextLong();
                long y1 = scn.nextLong();
                long x2 = scn.nextLong();
                long y2 = scn.nextLong();
                x_min = Math.min(x_min, Math.min(x1, x2));
                x_max = Math.max(x_max, Math.max(x1, x2));
                y_min = Math.min(y_min, Math.min(y1, y2));
                y_max = Math.max(y_max, Math.max(y1, y2));

                obj.lowerLeftPt = new Rect.Point(x1, y1);
                obj.topRightPt = new Rect.Point(x2, y2);
                objects[i] = obj;
            }

            int min_dist = Integer.MAX_VALUE;
            long ans_x = 0, ans_y = 0;
            for (long x = x_min; x <= x_max; x++) {
                for (long y = y_min; y <= y_max; y++) {
                    int dist = 0;
                    for (Rect obj : objects) {

                        long p_min_x = obj.lowerLeftPt.x;
                        long p_min_y = obj.lowerLeftPt.y;

                        long p_max_x = obj.topRightPt.x;
                        long p_max_y = obj.topRightPt.y;

                        if (x >= p_min_x && x <= p_max_x && y >= p_min_y && y <= p_max_y) {
                            dist += 0;
                        } else {
                            if (x > p_max_x && y > p_max_y) {
                                dist += x - p_max_x + y - p_max_y;
                            } else if (y > p_max_y) {
                                dist += y - p_max_y;
                            } else if (x > p_max_x) {
                                dist += x - p_max_x;
                            }
                        }
                        System.out.println(dist+" "+min_dist);
                    }
                    if (dist < min_dist) {
                        System.out.println(dist+" "+min_dist);
                        min_dist = dist;
                        ans_x = x;
                        ans_y = y;
                    }
                }
            }
            System.out.println("Case #" + ct + ": " + ans_x + " " + ans_y);
            ct++;
        }
    }

    static class Rect {

        Point lowerLeftPt, topRightPt;

        private static class Point {
            long x, y;

            Point(long x, long y) {
                this.x = x;
                this.y = y;
            }
        }
    }

}
