package LeetCode.TopInterviewQuestions;

public class Q121_2 {
    /*
    You are given an array prices where prices[i] is the price of a given stock on the ith day.

    You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

    Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
    */
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int minimumPrice = prices[0];
        int maximumProfit = prices[1] - prices[0];
        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - minimumPrice;
            if (profit > maximumProfit) {
                maximumProfit = profit;
            }
            if (prices[i] < minimumPrice) {
                minimumPrice = prices[i];
            }
        }
        return Math.max(maximumProfit, 0);
    }
}
