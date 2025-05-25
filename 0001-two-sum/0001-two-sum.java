import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> complementMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (complementMap.containsKey(complement)) {
                return new int[]{complementMap.get(complement), i};
            }
            complementMap.put(nums[i], i);
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int[] nums = new int[size];
        System.out.println("Enter the array elements:");
        for (int i = 0; i < size; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.print("Enter the target value: ");
        int target = scanner.nextInt();
        int[] result = twoSum(nums, target);
        if (result.length == 2) {
            System.out.println("Output: [" + result[0] + ", " + result[1] + "]");
        } else {
            System.out.println("No solution found.");
        }

        scanner.close();
    }
}
