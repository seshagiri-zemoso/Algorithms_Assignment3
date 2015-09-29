# import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

 
public class BruteCollinearPoints {
    public static void main(String[] args) throws FileNotFoundException {
    	String file="/home/seshagiri/Downloads/collinear/input8.txt";
        Scanner in = new Scanner(new FileReader(file));
        int N = in.nextInt();
        Point[] points = new Point[N];
        int n = 0;
        while (in.hasNext()) {
            int x = in.nextInt();
            int y = in.nextInt();
            points[n] = new Point(x, y);
            points[n].draw();
            n++;
        }
        Arrays.sort(points);
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                double slopeij = points[i].slopeTo(points[j]);
                for (int k = j + 1; k < N; k++) {
                    double slopeik = points[i].slopeTo(points[k]);
                    if (slopeij == slopeik) {
                        for (int m = k + 1; m < N; m++) {
                            double slopeim = points[i].slopeTo(points[m]);
                            if (slopeij == slopeim) {
                                System.out.println(points[i] + " -> " + points[j] + " -> " + points[k] + " -> " + points[m]);
                                points[i].drawTo(points[m]);
                            }
                        }
                    }
                }
            }
        }
    }
}
