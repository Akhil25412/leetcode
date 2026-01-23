class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;  // To store minimum price so far
        int maxProfit = 0;                 // To store maximum profit

        for (int i = 0; i < prices.length; i++) {
            // Update minimum price if current price is lower
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            // Calculate profit if sold today
            else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }

        return maxProfit;
    }
}
