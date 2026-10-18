class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();

        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        Integer[] numbers=map.keySet().toArray(new Integer[0]);

        Arrays.sort(numbers,(a,b)->Integer.compare(map.get(b),map.get(a)));

        int []result=new int[k];

        for(int i=0;i<k;i++){
            result[i]=numbers[i];
        }

        return result;
    }
}
