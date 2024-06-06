import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int maxWindowLength = 0;
        Set<Character> substring = new HashSet<>();

        for(int i = 0; i < s.length(); i++) {
            if(substring.contains(s.charAt(i))) {
                maxWindowLength = Math.max(maxWindowLength, substring.size());
                substring.clear();
            } else {
                System.out.println(s.charAt(i));
                substring.add(s.charAt(i));
            }
        }
        maxWindowLength = Math.max(maxWindowLength, substring.size());

        return maxWindowLength;
    }

    public static void main (String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));

    }
}
