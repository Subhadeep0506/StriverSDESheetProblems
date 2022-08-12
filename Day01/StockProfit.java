/*
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * 
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different
 * day in the future to sell that stock.
 * 
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit
 * return 0.
 * 
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 */

package Day01;

public class StockProfit {
    public static void main(String[] args) {
        
    }

    public int maxProfit(int[] prices) {
        int length = prices.length;
        // For stock list size less than 2
        if (length < 2)
            return 0;
        int buy = prices[0];
        int maxProfit = 0;

        for (int i = 0; i < length; i++) {
            buy = Math.min(buy, prices[i]); // Check the min prices
            maxProfit = Math.max(maxProfit, prices[i] - buy);
        }
        
        return maxProfit;
    }
}
