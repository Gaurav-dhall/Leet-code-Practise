class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        StringBuilder ans = new StringBuilder();
        StringBuilder word = new StringBuilder();

        // traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            if (ch != ' ') {
                // build current word in reverse (since we go right->left)
                word.append(ch);
            } else {
                // we hit a space -> if we have a word collected, add it
                if (word.length() > 0) {
                    // reverse to restore word order, then append to answer
                    word.reverse();
                    if (ans.length() > 0) ans.append(' ');
                    ans.append(word);
                    // reset word
                    word.setLength(0);
                }
            }
        }

        // last word (if string does not end with space)
        if (word.length() > 0) {
            word.reverse();
            if (ans.length() > 0) ans.append(' ');
            ans.append(word);
        }

        return ans.toString();
    }
}
