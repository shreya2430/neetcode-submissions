class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for(int i=1;i<=amount;i++){
            for(int coin : coins){
                if(i-coin >= 0){
                    dp[i] = Math.min(dp[i], dp[i-coin] + 1);
                }
            }
        }
        return dp[amount] == amount+1 ? -1 : dp[amount];
    }
}
/*
1 5 10 , amount = 12
       0 1 2 3 4 5 6 7 8 9 10 11 12
dp -> [0 1 2 3 4 5]
Number of coins i need to generate ith Amount 
dp -> [0 1 2]
dp[i] -> (i-coin)-> number of coins i used to make this amount + 1-> curr coin i used 
for(int coin: coins){
    dp[i] = Math.min(dp[i], dp[i-coin] + )
}
*/