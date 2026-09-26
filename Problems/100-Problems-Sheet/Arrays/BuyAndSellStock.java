package Arrays;
class BuyAndSellStock {

  // public int maxProfit(int prices[]) {
  //   int profit = 0;
  //   for(int buy = 0; buy < prices.length; buy++) {
  //     for(int sell = buy + 1; sell < prices.length; sell++) {
  //       int currentProfit = prices[sell] - prices[buy];
  //       if(currentProfit > profit) {
  //         profit = currentProfit;
  //       }
  //     }
  //   }
  //   return profit;
  // }

  public int maxProfit(int prices[]) {
    int maxProfit = 0;
    int minSofar = prices[0];

    for(int i=0; i < prices.length; i++) {
      minSofar = Math.min(minSofar, prices[i]);
      int profit = prices[i] - minSofar;
      maxProfit = Math.max(maxProfit, profit);
    }
    return maxProfit; 
  }

  void main() {
    int prices[] = {7, 1, 5, 3, 6, 4};

    int maxProfit = maxProfit(prices);
    System.out.println(maxProfit);
  }
}