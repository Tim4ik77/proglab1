import java.util.Random;

public class Main {
    public static void main(String[] args) {

        long[] z = new long[10];
        for (int i = 0; i < 10; i++) {
            z[i] = 24 - i*2;
        }

        float[] x = new float[14];
        Random rand = new Random();

        for (int i = 0; i < 14; i++) {
            x[i] = (float) rand.nextDouble(-8., 2.);
        }


        double[][] z1 = new double[10][14];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 14; j++) {
                z1[i][j] = count(z[i], x[j]);
            }
        }

        printMatrix(z1);
    }

    public static double count(long zi, float xj) {
        if (zi == 24) {
            double arg = (xj - 3)*Math.E+1;
            return Math.pow(Math.PI*Math.pow(Math.asin(arg), Math.atan(arg))+0.5, Math.atan(Math.sin(xj)));
        } else if (zi == 6 || zi == 8 || zi == 12 || zi == 14 || zi == 22) {
            return Math.pow(2*xj*xj, Math.sin(xj)*(Math.pow(Math.log(Math.abs(xj)), 1./3) - 2./3));
        } else {
            return Math.sin(Math.pow(Math.pow(Math.tan(xj), 1./3)*(Math.cos(Math.tan(xj))+1), Math.pow( Math.pow(xj, 3)/(Math.pow(xj, 1./3) + 1./4), 3 )));
        }
    }

    public static void printMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%8.3f", matrix[i][j]);
            }
            System.out.println();
        }
    }
}