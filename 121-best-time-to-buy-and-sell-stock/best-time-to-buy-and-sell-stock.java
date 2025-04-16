class Solution {
    public int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;
        int max_profit = 0;

        while(right < prices.length){
            if(prices[right] > prices[left]){  
            int profit = prices[right] - prices[left];
            max_profit = Math.max(max_profit, profit);
            System.out.println(max_profit);
            }else{
                left = right;
            }  
            right ++;
        }
        return max_profit;
    }
}