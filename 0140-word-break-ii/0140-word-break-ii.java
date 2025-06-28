class Solution {
    public void solve(int index, String s, Set<String>wordSet, List<String> result, String temp){
        if(index>=s.length()){
            result.add(temp.trim());
            return;
        }

        StringBuilder subString = new StringBuilder();
        for(int i= index; i<s.length(); i++){
            subString.append(s.charAt(i));
            if(wordSet.contains(subString.toString())){
                solve(i+1, s, wordSet, result, temp+subString + " ");
            }
        }

    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        List<String> result = new ArrayList<>();
        solve(0, s, wordSet, result, "");
       return result; 
    }
}