public class Solution1 {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i); // For odd length palindrome
            int len2 = expandAroundCenter(s, i, i + 1); // For even length palindrome
            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        // We return the length of the palindrome (right - left - 1) instead of the end index - start index + 1
        // because we have already expanded one step beyond the valid palindrome
        return right - left - 1;
    }

    public static void main(String[] args) {
        String s1 = "babad";
        String s2 = "cbbd";

        System.out.println("Input: " + s1);
        System.out.println("Output: " + longestPalindrome(s1));
        System.out.println();

        System.out.println("Input: " + s2);
        System.out.println("Output: " + longestPalindrome(s2));
    }
}
