class Solution {
    public boolean canJump(int[] nums) {
        int lastGoodIndexPosition=nums.length-1;
        for(int i=nums.length-2 ; i>=0;i--){
            if(i+nums[i]>= lastGoodIndexPosition){
                lastGoodIndexPosition=i;
            }
        }
        return lastGoodIndexPosition==0;
    }
}
