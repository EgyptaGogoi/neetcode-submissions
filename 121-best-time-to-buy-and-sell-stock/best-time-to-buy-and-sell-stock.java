class Solution {
    public int maxProfit(int[] prices) {
        int sell_p = 0;
        int buy_p = 100000;
        int max_profit = 0;
        for(int i = 0; i< prices.length; i++){
            int curr_profit = 0;
            if(prices[i]<buy_p){
                buy_p = prices[i];
                sell_p = 0;
            }
            else if(prices[i]>sell_p)
                sell_p = prices[i];
            curr_profit = sell_p - buy_p;
            if (curr_profit > max_profit)
                max_profit = curr_profit;
        }
        return max_profit;
    }
}