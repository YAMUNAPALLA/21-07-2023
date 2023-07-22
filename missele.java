import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class missele {
    public static List<Integer> findMissingNumbers(int[] arrNum) {
        List<Integer> missingNumbers = new ArrayList<>();

        int n = arrNum.length;
        int expectedNum = arrNum[0];

        for (int i = 0; i < n; i++) {
            while (arrNum[i] != expectedNum) {
                missingNumbers.add(expectedNum);
                expectedNum++;
            }
            expectedNum++;
        }

        return missingNumbers;
    }

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements you want to store: ");
        n = sc.nextInt();
        int[] array = new int[n]; // Fix the array size to 'n', not '10'
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        System.out.println("Array elements are: ");
        for (int i = 0; i < n; i++) {
            System.out.println(array[i]);
        }

        List<Integer> missingNumbers = findMissingNumbers(array);
        System.out.println("Missing numbers: " + missingNumbers);
    }
}

