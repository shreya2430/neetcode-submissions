class Solution {
    public int maxProfit(int[] prices) {
        int hold = Integer.MIN_VALUE;
        int sold = 0;
        int rest = 0;
        for(int price : prices){
            int prevHold = hold, prevSold = sold, prevRest = rest;
            // i will either resting from yesterday, Or i have buy a stock today because i was on rest yesterday
            hold = Math.max(hold, rest - price);
            sold = prevHold + price;
            rest = Math.max(rest, prevSold);
        }
        return Math.max(sold, rest);
    }
}
