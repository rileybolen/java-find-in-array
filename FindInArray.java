import java.util.ArrayList;
import java.util.List;

public class FindInArray {
    private static int[] newArray = new int[100];

    public static void main(String[] args) {

        //Min + (int)(Math.random() * ((Max - Min) + 1))

        for (int i = 0; i < (newArray.length - 1); i++) {
            newArray[i] = 1 + (int) (Math.random() * ((100 - 1) + 1));
        }
        for (int anArray : newArray) System.out.print(String.valueOf(anArray) + ", ");
        sortLow(newArray);
        ArrayList inRangeBinary = findInRangeBinary(1, 20, newArray);

        ArrayList inRangeLinear = findInRangeLinear(40, 50, newArray);

        ArrayList values = findInByValue(21, newArray);

        System.out.println("");
        System.out.println("Binary");
        for (Object i : inRangeBinary){
            System.out.print(String.valueOf(i) + ", ");
        }
        System.out.println("");
        System.out.println("Linear");
        for (Object i : inRangeLinear){
            System.out.print(String.valueOf(i) + ", ");
        }
        System.out.println("");
        System.out.println("Specific Values");
        for (Object i : values){
            System.out.print(String.valueOf(i) + ", ");
        }
    }

    private static ArrayList findInRangeBinary(int low, int high, int[] array){
        ArrayList list = new ArrayList();

        int position = Math.round(array.length) /2;

        while(list.isEmpty()) {

            if (array[position] >= low && array[position] <= high) {
                list.add(array[position]);

                addInRange(low, high, array, list, position);
            } else if (array[position] > high) {
                position = position - (position / 2);
            } else {
                position = position + (position / 2);
            }
        }

        return list;
    }

    private static void addInRange(int low, int high, int[] array, ArrayList list, int position) {
        int holder1 = position;
        position ++;
        holder1 --;
        while(array[position] <= high){
            list.add(array[position]);
            position = position + 1;
        }
        while(array[holder1] >= low){
            list.add(array[holder1]);
            holder1 = holder1 - 1;
        }
    }

    public static ArrayList findInRangeLinear(int low, int high, int[] array){
        ArrayList list = new ArrayList();
        for (int i : array){
            if(i >= low && i <= high){
                list.add(i);
            }
        }
        return list;
    }

    public static ArrayList findInByValue(int value, int[] array){
        ArrayList list = new ArrayList();
        for (int i : array){
            if(i == value){
                list.add(i);
            }
        }
        return list;
    }


    private static void sortLow(int[] array){
        for (int length = array.length; length > 0; length--) {
            for (int i = array.length - 1; i > 0; i--) {
                if (array[i] < array[i - 1]) {
                    numSwitch(array, i, (i - 1));
                }
            }
        }
        System.out.println("");
        System.out.println("After");
        for (int anArray : array) System.out.print(String.valueOf(anArray) + ", ");
    }
    private static void numSwitch(int[] anArray, int first, int second){
        int holder = anArray[first];
        anArray[first] = anArray[second];
        anArray[second] = holder;
    }
}
