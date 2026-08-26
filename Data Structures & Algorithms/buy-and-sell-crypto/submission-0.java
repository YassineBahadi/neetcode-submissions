class Solution {
    public int maxProfit(int[] prices) {
        int minPrice=Integer.MAX_VALUE;
        int ans=0;

        for(int p:prices){
            minPrice=Math.min(minPrice,p);
            ans=Math.max(ans,p-minPrice);
        }
        return ans;
    }
}
