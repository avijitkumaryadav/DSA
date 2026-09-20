/*
 * Approach: Brute Force (Try all buy/sell pairs)
 * Time Complexity:  O(n^2)  — nested loops over all pairs (i, j) with i < j
 * Space Complexity: O(1)    — only tracking variables
 * Sheet: Arrays Row 8 — Best Time to Buy and Sell Stock (Amazon)
 *
 * NOTE: Will TLE on LeetCode for n = 10^5. Use only to understand the problem.
 */
public class BuySellStockBrute {

    // Time: O(n^2) | Space: O(1)
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {           // buy day
            for (int j = i + 1; j < prices.length; j++) {   // sell day (must be after)
                int profit = prices[j] - prices[i];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices1)); // 5

        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(prices2)); // 0
    }
}