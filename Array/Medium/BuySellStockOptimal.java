/*
 * Approach: Single Pass (Optimal)
 * Time Complexity:  O(n)  — one pass through the array
 * Space Complexity: O(1)  — only two variables
 * Sheet: Arrays Row 8 — Best Time to Buy and Sell Stock (Amazon)
 *
 * Logic:
 *   - Track the minimum price seen so far (best day to buy).
 *   - For each day, compute profit if we sold today: prices[i] - minPrice.
 *   - Update maxProfit if this profit is larger.
 *   - Move to the next day.
 *
 * Key Insight:
 *   The best time to sell on day i is to have bought at the MINIMUM price
 *   seen in days 0..i-1. So we track that minimum as we sweep left to right.
 */
public class BuySellStockOptimal {

    // Time: O(n) | Space: O(1)
    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;   // best buy price seen so far
        int maxProfit = 0;                  // best profit seen so far

        for (int price : prices) {          // O(n)
            if (price < minPrice) {
                minPrice = price;           // update best buy day
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice; // update best sell profit
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices1)); // 5

        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(prices2)); // 0

        int[] prices3 = {2, 4, 1};
        System.out.println(maxProfit(prices3)); // 2 (buy 2, sell 4)
    }
}