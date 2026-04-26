package LeetCode.TopInterviewQuestions;

public class Q121 {
    public int maxProfit(int[] prices) {
        int minBuy = prices[0];
        int maxProfit = 0;
        for (int element : prices) {
            if (element < minBuy) {
                minBuy = element;
            } else if (element - minBuy > maxProfit) {
                maxProfit = element - minBuy;
            }
        }
        return maxProfit;
    }
}
