class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> count=new HashMap<>();

        for(int n:nums){
            count.put(n,count.getOrDefault(n,0)+1);
        }
        List<Integer>[] bucket= new ArrayList[nums.length+1];

        for(int num:count.keySet()){
            int freq=count.get(num);
            if(bucket[freq]==null){
                bucket[freq]=new ArrayList<>();
            }
            bucket[freq].add(num);
        }

        int[]res=new int[k];
        int index=0;

        for(int i=bucket.length-1;i>=0 && index<k;i--){
            if(bucket[i]!=null){
                for(int num:bucket[i]){
                    res[index++]=num;
                    if(index==k){
                        break;
                    }
                }
            }
        }
            return res;
    }
}
