import java.util.Arrays;

public class calcm {
    public static void main(String[] args) {
        int[] arrNum = {5, 3, 4, 2, 0, 8};

        try {
            int cumulativeMultiple = arrNum[0];
            for (int i = 1; i < arrNum.length; i++) {
                if (arrNum[i] == 0) {
                    // Handle the exception when encountering 0
                    cumulativeMultiple = 0;
                } else {
                    cumulativeMultiple *= arrNum[i];
                }
                arrNum[i] = cumulativeMultiple;
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            // Handle any potential exceptions (e.g., accessing an index out of bounds)
            System.out.println("Array index out of bounds: " + e.getMessage());
        }

        System.out.println("Output: arrNum = " + Arrays.toString(arrNum));
    }
}
