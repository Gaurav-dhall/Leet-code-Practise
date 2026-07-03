class Solution {

    int i = 0;

    public String decodeString(String s) {
        StringBuilder ans = new StringBuilder();
        int k = 0;

        while (i < s.length()) {

            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0');
            }

            else if (ch == '[') {
                i++;

                String decoded = decodeString(s);

                for (int j = 0; j < k; j++)
                    ans.append(decoded);

                k = 0;
            }

            else if (ch == ']') {
                return ans.toString();
            }

            else {
                ans.append(ch);
            }

            i++;
        }

        return ans.toString();
    }
}