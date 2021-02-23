package TwoPointer;

public class strStr {

    public static void main(String[] args) {

        String haystack = "mississippi",needle = "issip";
        System.out.println(new Solution().strStr(haystack,needle));
    }

    static class Solution {
        public int strStr(String haystack, String needle) {

            if(needle.isEmpty())
                return 0;

            int quesSize = haystack.length();
            int subStrSize = needle.length();

            if(quesSize < subStrSize)
                return -1;

            for(int i=0;i<quesSize - subStrSize;i++){
                int j;
                for(j=0;j<subStrSize;j++){
                    if(haystack.charAt(i+j) != needle.charAt(j))
                        break;
                }
                if(j==subStrSize)
                    return i;
            }
            return -1;
        }
    }

}
