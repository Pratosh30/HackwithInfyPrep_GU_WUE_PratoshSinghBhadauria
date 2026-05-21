class Solution {
    // Trie node class
    class TrieNode {
        TrieNode[] children = new TrieNode[10]; // Since digits are 0-9
    }

    // Insert a number (as string) into the Trie
    private void insert(TrieNode root, String num) {
        TrieNode current = root;
        for (char c : num.toCharArray()) {
            int index = c - '0';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
    }

    // Find the longest common prefix between a number and the Trie
    private int findCommonPrefix(TrieNode root, String num) {
        TrieNode current = root;
        int commonLength = 0;
        for (char c : num.toCharArray()) {
            int index = c - '0';
            if (current.children[index] != null) {
                commonLength++; // Increment common length if prefix exists
                current = current.children[index];
            } else {
                break; // Stop if no more common prefix
            }
        }
        return commonLength;
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        TrieNode root = new TrieNode();
        // Insert all elements from arr2 into the Trie
        for (int num : arr2) {
            insert(root, String.valueOf(num));
        }

        int maxLength = 0;
        // Find the longest common prefix for each element in arr1
        for (int num : arr1) {
            int commonLength = findCommonPrefix(root, String.valueOf(num));
            maxLength = Math.max(maxLength, commonLength);
        }
        
        return maxLength;
    }
}