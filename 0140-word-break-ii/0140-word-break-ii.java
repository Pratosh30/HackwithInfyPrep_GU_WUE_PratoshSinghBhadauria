class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Map<String, List<String>> memo = new HashMap<>();
        return backtrack(s, wordSet, memo);
    }

    private List<String> backtrack(String s, Set<String> wordSet, Map<String, List<String>> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        List<String> result = new ArrayList<>();
        if (s.length() == 0) {
            result.add(""); // base case for successful split
            return result;
        }

        for (int end = 1; end <= s.length(); end++) {
            String prefix = s.substring(0, end);
            if (wordSet.contains(prefix)) {
                List<String> suffixBreaks = backtrack(s.substring(end), wordSet, memo);
                for (String suffix : suffixBreaks) {
                    if (suffix.isEmpty()) {
                        result.add(prefix);
                    } else {
                        result.add(prefix + " " + suffix);
                    }
                }
            }
        }

        memo.put(s, result);
        return result;
    }
}
