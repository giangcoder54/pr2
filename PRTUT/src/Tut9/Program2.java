package Tut9;

public class Program2 {
    public static void main(String[] args) {
        int[] x = { 1, 3, 5 };
        int[] y = { 1, 2, 3, 4 };

        int[] z = y;
         int j;
         for (int i = 0; i < x.length; i++) {
            for (j = 1; j < z.length; j++) {
                 z[j] = z[j] + z[j - 1];
                 }
             x[i] = x[i] * z[j-1];

            System.out.println(x[i]);
             }

        for (int i = 0; i < y.length; i++)
             System.out.println(y[i]);
         }

}
