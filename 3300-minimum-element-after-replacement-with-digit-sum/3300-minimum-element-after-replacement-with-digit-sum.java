class Solution {
    public int minElement(int[] nums) {
        int minSum = Integer.MAX_VALUE;
        
        for (int num : nums) {
            int currentDigitSum = getDigitSum(num);
            if (currentDigitSum < minSum) {
                minSum = currentDigitSum;
            }
        }
        
        return minSum;
    }
    
    // Helper method to calculate the sum of digits of a number
    private int getDigitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10; // Extract the last digit
            n /= 10;       // Remove the last digit
        }
        return sum;
    }
}