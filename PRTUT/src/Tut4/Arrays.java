package Tut4;



public class Arrays {


    /** Count the number of the negative elements of an array
     * @ requires a not null
     * @ effects return the numbers of negative elements in an array
     *   i.e. result = {x\in a && x<0}.length
     *  eg : countNegative({-2,-3,-4}) = 3
     */
    public  static  int  countNegative(int[] a){
        int count =0;
        for(int i =0;i<a.length;i++){
            if(a[i]<0){
                count++;
            }
        }
    return count;

    }
    /**
     * Count the number of even elements of an array of positive integers
     *
     * @requires a not null array a /\ for all x in a. x>0
     * @effects return number of even elements of a,
     *
     *      i.e. result = [x | x in a /\ x % 2 = 0].length
     *      e.g. countEvents([1,2,4,6,8] = 4
     */
    public static int countEvens(int[] a) {
        int count = 0;
        for(int i =0;i<a.length;i++){
            if(a[i]%2==0){
                count++;
            }
        }
        return count;
    }


    /**
     * divide the elements of a real number array by a real number
     * @requires a not  null array
     *          real n number is not 0 \/ null
     * @effects return the result of the length of array for a real number
     *      i.e. result = x = [ array.length / n | n is real number]
     *      e.g. divArray = ( [1,2,3,4,5,6], 3) = 2
     */
    public static void divArray(double[] a, double b) {
        System.out.println(a.length/b);
    }


    /**
     * find the minimum element in an array of integers
     * @requires a not null array
     * @effect return the smallest number in the array
     *         i.e. result = {x | x in a /\ x is smallest}
     *         e.g. min([2,3,1,6]) = 1
     */
    public static int min(int[] a) {
        int min =a[0];
        for(int i =1;i<a.length;i++){
            if(min>a[i]){
                min = a[i];
            }
        }
        return min;
    }


    /**
     * determine whether an array of integers is in ascending order
     * @require a not null
     * @effect check whether the array is in ascending order or not
     *          return boolean true or false
     *
     *          e.g. isAscSorted([1,2,3,4,5]) = true
     *
     */
    public static boolean isAscSorted(int[] a ) {
        for(int i=0;i<a.length-1;i++){
            if(a[i]>a[i+1]){
                return false;
            }
        }
        return true;
    }
    /** find the length of an array of CHARs
     * any characters after characters NUL are not to be
     * counted
     * @require a not null
     * @effect return the length of an array
     *      i.e. result = {x\in a }.length
     *      e.g length({'a','b','c'}) =3  a,b,c,d,e, ,f
     */
    public static int length(char[] a){
        int count =0;
        for(int i =0;i<a.length;i++){

            if(a[i] == '\u0000'){
                break;
            }
            count++;
        }
        return count;
    }
    /**
     * In an array of reals, FIND the median
     * @requires  a not null array
     * @effects find the element
     *          which have the value is greater than x elements /\ smaller than (x \/ x +- 1) elements
     *
     *          i.e. result =
     *          e.g. median([24, 31, 35, 96, 23, 41, 36]) = 35
     */
    public static double median(double[] a) {
        java.util.Arrays.sort(a);
        int n = a.length;
        if (n % 2 != 0)
            return a[n / 2];

        return (a[(n - 1) / 2] + a[n / 2]) / 2.0;
    }

    /**
     * Compare the two array of real numbers
     *
     * @requires array a and b aren't both null
     * @effects Check if a ⊂ b, a ⊃ b, a ∩ b,or a = b
     *
     *          e.g. compare([1,2,3,4,5], [1,2,3,4]) = "a ⊃ b"
     *               compare([1,2,3], [1,2,3]) = "a = b"
     *               compare([1,2,3], [3,4,5]) = "a ∩ b"
     */
    public static void compare(int[] a, int[] b){
        int m = a.length;
        int n = b.length;
        int count = 0;
        java.util.Arrays.sort(a);
        java.util.Arrays.sort(b);
        int i, j =0;
        for( i = 0;i< m;i++){
            for( j = 0;j<n;j++){
                if(b[j]== a[i]){
                   count++;
                   break;
                }

            }
            if(j == n){

            }
        }

    }
    /**compute the frequencies of each element of an array of reals
     * @require a not null
     * @effect return an array that stored frequencies of each element of an array a
     */
    public static int[] freq(int[] arr) {
        int[] fr = new int[arr.length];
        int visited = -1;

        for (int i = 0; i < arr.length; i++) {
            int count = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                    //To avoid counting same element again
                    fr[j] = visited;
                }
            }
            if (fr[i] != visited)
                fr[i] = count;
        }

        //Displays the frequency of each element present in array
        System.out.println("---------------------");
        System.out.println(" Element | Frequency");
        System.out.println("---------------------");
        for(int i = 0; i < fr.length; i++){
            if(fr[i] != visited)
                System.out.println("    " + arr[i] + "    |    " + fr[i]);
        }
        System.out.println("---------------------");
    return fr;
    }


}
