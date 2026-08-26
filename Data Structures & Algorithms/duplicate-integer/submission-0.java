class Solution {
    public boolean hasDuplicate(int[] nums) {
      HashSet<Integer> set= new HashSet<>();

      for(Integer num:nums){
        if(!set.add(num)){
            return true;
        }
      }
      return false;
    }
}