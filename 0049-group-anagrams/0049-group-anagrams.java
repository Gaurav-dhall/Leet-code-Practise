class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            int[] freq = new int[26];

            for (char ch : str.toCharArray()) {
                freq[ch - 'a']++;
            }

            StringBuilder key = new StringBuilder();

            for (int count : freq) {
                key.append(count).append('#');
            }

            String hashKey = key.toString();

            map.putIfAbsent(hashKey, new ArrayList<>());
            map.get(hashKey).add(str);
        }

        return new ArrayList<>(map.values());
    }
}