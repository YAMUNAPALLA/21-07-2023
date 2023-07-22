import java.util.HashMap;

public class SingularSocksCount {
    public static void main(String[] args) {
        int[] arrNum = {10, 20, 20, 10, 10, 30, 50, 10, 20};

        HashMap<Integer, Integer> sockCountMap = new HashMap<>();

        // Count the occurrences of each sock ID in the array
        for (int sockId : arrNum) {
            sockCountMap.put(sockId, sockCountMap.getOrDefault(sockId, 0) + 1);
        }

        // Calculate the count of singular socks
        int singularCount = 0;
        for (int count : sockCountMap.values()) {
            if (count % 2 != 0) {
                singularCount++;
            }
        }

        System.out.println("Count of singular socks = " + singularCount);
    }
}
