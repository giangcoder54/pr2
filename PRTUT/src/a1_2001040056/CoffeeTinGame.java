
package a1_2001040056;
import java.util.Arrays;
import java.util.Random;

/**
 * @overview A program that performs the coffee tin game on a
 *    tin of beans and display result on the standard output.
 *
 */
public class CoffeeTinGame {

    /** constant value for the green bean*/
    private static final char GREEN = 'G';
    /** constant value for the blue bean*/
    private static final char BLUE = 'B';
    /** constant for removed beans */
    private static final char REMOVED = '-';
    /** the null character*/
    private static final char NULL = '\u0000';
    /**
     * constant for the bag of available beans
     */
    private static final  char[] BeansBag={BLUE,BLUE,GREEN,GREEN,BLUE,BLUE,REMOVED,GREEN,REMOVED,GREEN,BLUE,REMOVED,BLUE,BLUE,GREEN,GREEN,GREEN,GREEN,
            BLUE,REMOVED,REMOVED,REMOVED,GREEN,GREEN,GREEN,GREEN,REMOVED,REMOVED,BLUE,BLUE,BLUE};

    /**
     * the main procedure
     * @effects
     *    initialise a coffee tin
     *     print the tin content
     *     perform the coffee tin game on tin
     *     print the tin content again
     *    if last bean is correct
     *       print its colour
     *    else
     *      : print an error message
     */
    public static void main(String[] args) {
        // initialise some beans
        // initialise some beans
        char[][] tins = {
                {BLUE, BLUE, BLUE, GREEN, GREEN},
                {BLUE, BLUE, BLUE, GREEN, GREEN, GREEN},
                {GREEN},
                {BLUE},
                {BLUE, GREEN}
        };

        for (char[] tin : tins) {
            // expected last bean
            // p0 = green parity /\
            // (p0=1 -> last=GREEN) /\ (p0=0 -> last=BLUE)
            // count number of greens
            int greens = 0;
            for (char bean : tin) {
                if (bean == GREEN)
                    greens++;
            }
            final char last = (greens % 2 == 1) ? GREEN : BLUE;// last = blue

            // print the content of tin before the game
            System.out.printf("%nTIN (%d Gs): %s %n", greens, Arrays.toString(tin));

            // perform the game
            char lastBean = tinGame(tin);
            // lastBean = last \/ lastBean != last

            // print the content of tin and last bean
            System.out.printf("tin after: %s %n", Arrays.toString(tin));

            // check if last bean as expected and print
            if (lastBean == last) {
                System.out.printf("last bean: %c%n", lastBean);
            } else {
                System.out.printf("Oops, wrong last bean: %c (expected: %c)%n", lastBean, last);
            }
        }
    }
    /**
     * @requires tin has at least two beans
     * @effects
     * Performs the coffee tin game to determine the colour of the last bean
     * @return last bean from tin
     */

    public static char tinGame(char[] tin) {
        while (hasAtLeastTwoBeans(tin)) {

            updateTin(tin,takeTwo(tin));
        }
        return anyBean(tin);
    }
    /**
     * @effects
     *  if tin has at least two beans
     *    return true
     *  else
     *    return false
     */

    private static boolean hasAtLeastTwoBeans(char[] tin) {
        int count = 0;
        for (char bean : tin) {
            if (bean != REMOVED) {
                count++;
            }

            if (count >= 2) // enough beans
                return true;
        }

        // not enough beans
        return false;
    }
    /**
     * @requires tin has at least 2 beans left
     * @modifies tin
     * @effects
     *  remove any two beans from tin and return them
     */
    private static char[] takeTwo(char[] tin) {

        char first = takeOne(tin);
        char second = takeOne(tin);

        return new char[]{first, second};
    }
    /**
     * @requires tin has at least one bean
     * @modifies tin
     * @effects
     *    take out randomly a bean from tin ,remove and return it
     */
    public static char takeOne(char[] tin) {

        int random =0;
        char bean = REMOVED;
        while(bean == REMOVED){

            random = randInt(tin.length);
            bean = tin[random];
        }
        tin[random]= REMOVED;


        return bean;
    }
    /**
     * @requires tin has vacant positions for new beans
     * @modifies tin
     * @effects
     *   place bean into any vacant position in tin
     */
    private static void putIn(char[] tin, char bean) {
        for (int i = 0; i < tin.length; i++) {
            if (tin[i] == REMOVED) { // vacant position
                tin[i] = bean;
                break;
            }
        }
    }

    /**
     * @effects
     *  if there are beans in tin
     *    return any such bean
     *  else
     *    return '\u0000' (null character)
     */
    private static char anyBean(char[] tin) {
        for (char bean : tin) {
            if (bean != REMOVED) {
                return bean;
            }
        }

        // no beans left
        return NULL;
    }

    /**
     *
     * @param n
     * @requires a positive n
     * @return an integer number randomly which range from 0 to n
     */

    public static int randInt(int n){
        Random rd = new Random();
        int random = rd.nextInt(n); // (max - min + 1) + min
        return random ;
    }
    /**
     *
     * @param BeanBags the BeansBag
     * @param beanType the type of bean you wanna take out
     * @requires BeanBags has at least one bean
     * @return that beanType in the bag, also remove it from the bag
     */
    public static char getBean(char[] BeanBags, char beanType) {
        char bean = NULL;
        int random=0;
        while(bean != beanType){

            random = randInt(BeanBags.length);
            bean = BeanBags[random];
        }
        BeanBags[random]= REMOVED;

        return bean;
    }
    /**
     *  @requires tin is not null /\ tin.length > 0
     *   @modifies tin
     * @effects
     *   take out two beans from tin
     *   if same color
     *     throw both away, put one blue bean back
     *   else
     *     put green bean back
     *
     */
    public static void updateTin(char[] tin, char[] twoBeans){


        char  b1 = twoBeans[0];
        char  b2 = twoBeans[1];
        // process beans to update tin
        if (b1 == b2) {// BB, GG
            // put B in bin
            putIn(tin, getBean(BeansBag,BLUE));
        } else { // BG, GB
            // put G in bin
            putIn(tin, getBean(BeansBag,GREEN));
        }
    }


}









