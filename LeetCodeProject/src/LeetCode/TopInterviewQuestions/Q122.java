package LeetCode.TopInterviewQuestions;

public class Q122 {
    /*
    You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

    On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.

    Find and return the maximum profit you can achieve.
    */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int localProfit = prices[i] - prices[i - 1];
            if (localProfit > 0) {
                maxProfit += localProfit;
            }
        }
        return maxProfit;
    }
}
