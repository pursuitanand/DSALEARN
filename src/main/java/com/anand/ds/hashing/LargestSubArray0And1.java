package com.anand.ds.hashing;

/**
 * Given an array arr of 0s and 1s. Find and return the length of the longest subarray with equal number of 0s and 1s.
 *
 * Examples:
 *
 * Input: arr[] = [1, 0, 1, 1, 1, 0, 0]
 * Output: 6
 * Explanation: arr[1...6] is the longest subarray with three 0s and three 1s.
 * Input: arr[] = [0, 0, 1, 1, 0]
 * Output: 4
 * Explnation: arr[0...3] or arr[1...4] is the longest subarray with two 0s and two 1s.
 * Input: arr[] = [0]
 * Output: 0
 * Explnation: There is no subarray with an equal number of 0s and 1s.
 *
 *
 * Time Complexity: O(n)
 * Auxiliary Space: O(n)
 */
public class LargestSubArray0And1 {

    /**
     * The algorithm for this problem is usually:
     *
     * Convert every 0 to -1.
     * Compute a running prefix sum.
     * Store the first occurrence of each prefix sum in a HashMap.
     * If the same prefix sum appears again, the elements in between sum to 0, meaning they contain an equal number of 0s and 1s.
     * Meaning Prefix sum 0 occurs at indices 1 and 3.Then the subarray from index 2 to 3 has equal number of 0s and 1s.
     * @param arr
     * @return
     *
     * Algorithm:
     * sum = 0
     * map = {}
     *
     * for every element
     *     update sum
     *
     *     if sum seen before
     *          answer = max(answer, distance)
     *
     *     else
     *          store first occurrence
     */
    public int maxLen(int[] arr) {
        // Your code here
        int arrLen = arr.length;
        int maxLen = 0;
        int sum = 0;
        java.util.Map<Integer, Integer> map = new java.util.HashMap<>();
        for (int i = 0; i < arrLen; i++) {
            sum += (arr[i] == 0) ? -1 : 1;
            if (sum == 0) {
                maxLen = i + 1; // Directly from the start of the array to the current index
            }
            if (map.containsKey(sum)) { // If the sum has been seen before, calculate the length of the subarray
                maxLen = Math.max(maxLen, i - map.get(sum)); // Update maxLen if the current subarray is longer
            } else {
                map.put(sum, i); // Store the first occurrence of this sum
            }
        }
        return maxLen;
    }

    public int maxLenFailedApproach(int[] arr) {
        // Your code here
        int arrLen = arr.length;
        int countZeroes = 0;
        int countOnes = 0;
        for(int i=0;i<arrLen;i++){
            if ((arr[i] == 0)) {
                countZeroes++;
            } else {
                countOnes++;
            }
        }
        return (countZeroes == 0 || countOnes == 0) ? 0 : 2*Math.min(countZeroes, countOnes);
    }

    public static void main(String[] args){
        LargestSubArray0And1 largestSubArray0And1 = new LargestSubArray0And1();
        //int[] arr = {0 ,1 ,1 ,0 ,0 ,0 ,0, 1, 0 ,1, 1, 1, 0, 0, 1 ,0, 0, 0 ,0, 0, 1 ,0 ,0};
        int[] arr = {0 ,1 ,1 ,0 ,0 ,1};
        System.out.println("Length of the longest subarray with equal number of 0s and 1s: " + largestSubArray0And1.maxLen(arr));
    }
}
