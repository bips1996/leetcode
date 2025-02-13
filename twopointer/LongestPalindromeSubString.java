package twopointer;

public class LongestPalindromeSubString {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) return s;
        String lp = "";
        for (int i = 1; i < s.length(); i++) {
            int left = i;
            int right = i;
            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) != s.charAt(right)) {
                    break;
                }
                left -= 1;
                right += 1;
            }

            if (right - left > lp.length()) {
                lp = s.substring(left + 1, right);
            }

            left = i - 1;
            right = i;
            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) != s.charAt(right)) {
                    break;
                }
                left -= 1;
                right += 1;
            }
            if (right - left > lp.length()) {
                lp = s.substring(left + 1, right);
            }
        }
        return lp;
    }

    public static void main(String[] args) {
        String s = "shjflksdjhfaaaabbbaaajjoieuwrdhfh";
        System.out.println(new LongestPalindromeSubString().longestPalindrome(s));
    }
}
