import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * A xylophone is a musical instrument that consists of a sequence of wooden bars. In order to make a sound, you have to strike one of the bars by a mallet.
 * <p>
 * For the purpose of this problem we will assume that our xylophone has exactly 50 bars. The bars are numbered from 1 to 50 in the order from the left to the right.
 * <p>
 * There are 7 notes: A, B, C, D, E, F, G. Each bar of our xylophone plays one of these notes. The notes repeat periodically. When you play the bars from the left to the right, you will hear the following sequence of notes: A,B,C,D,E,F,G,A,B,C,D,E,F,G,A,B,C,...
 * <p>
 * In other words: bar 1 produces the note A, bar 2 plays B, bar 3 plays C, ..., bar 7 plays G, and then the sequence of notes starts repeating: bar 8 plays the note A again, bar 9 is B, and so on.
 * <p>
 * You have hit a sequence of bars. You are given their numbers in the int[] keys. Return the number of distinct notes you've hit.
 */
public class Xylophone {
    public static void main(String[] args) {


        System.out.println(countKeys(arrayReader()));



    }

    public static int countKeys(int[] keyHit) {

        int count = 0;
        LinkedList<Integer> keys = new LinkedList<>();
        for (int a : keyHit) {
            keys.add(a);
        }

        Iterator it = keys.iterator();
        while (it.hasNext()) {
            count++;
            int lookingAt = keys.pop() % 7;

            for (int fromKeys: keys) {

                if (fromKeys % 7 == lookingAt) {
                    keys.remove(Integer.valueOf(fromKeys));
                }
            }
        }

        return count;
    }

    public static int[] arrayReader(){
        System.out.println("please enter the array:");
        Scanner in = new Scanner(System.in);
        String array = in.nextLine();

        String[] items = array.replaceAll("\\{", "").replaceAll("\\}", "").replaceAll("\\s", "").split(",");

        System.out.println(items);

        int[] results = new int[items.length];

        for (int i = 0; i < items.length; i++) {
            try {
                results[i] = Integer.parseInt(items[i]);
            } catch (NumberFormatException nfe) {
                nfe.getMessage();
            }
        }

        return results;


    }

}


