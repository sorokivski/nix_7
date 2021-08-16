package level1;

import java.util.*;

public class t3_triangleSquare {

    public static class Point {
        private int x;
        private int y;
        private int z;

        public Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void triangleSquare() {
        Scanner in = new Scanner(System.in);
        System.out.println("Choose coordinate system( 2 - 2D system, 3 - 3D system): ");
        int chosenSystem = in.nextInt();
        Point[] points;
        switch (chosenSystem) {
            case 3: {
                points = new Point[3];
                for (int i = 0; i < 3; i++) {
                    System.out.println("Enter x, y, z for point " + (i + 1) + ":");
                    points[i] = new Point(in.nextInt(), in.nextInt(), in.nextInt());
                }
            }
            break;
            default: {
                points = new Point[3];
                for (int i = 0; i < 3; i++) {
                    System.out.println("Enter x, y for point " + (i + 1) + ":");
                    points[i] = new Point(in.nextInt(), in.nextInt(), 0);
                }
            }
        }
        float a = calculateLength(points[0], points[1]), b = calculateLength(points[1], points[2]), c = calculateLength(points[0], points[2]), square;
        boolean triangle = isTriangle(a, b, c);
        if (triangle) System.out.println("Triangle square = " + Math.floor(calculateSquare(a, b, c)));
        else System.out.println("!ENTERED VALUES DOES NOT CREATING TRIANGLE!");
    }

    public static boolean isTriangle(float a, float b, float c) {
        if (a + b <= c || Math.abs(a - b) >= c || a + c <= b || Math.abs(a - c) >= b || b + c <= a || Math.abs(b - c) >= a) return false;
        return true;
    }

    private static float calculateLength(Point point1, Point point2) {
        return (float) Math.sqrt(Math.pow((point2.x - point1.x), 2) + Math.pow((point2.y - point1.y), 2) + Math.pow((point2.z - point1.z), 2));
    }

    private static float calculateSquare(float a, float b, float c) {
        float p = (float) ((a + b + c) * 0.5);
        return (float) Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
