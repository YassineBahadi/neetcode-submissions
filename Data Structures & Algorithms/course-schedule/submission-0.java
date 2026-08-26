class Solution {
    Map<Integer,List<Integer>> preMap=new HashMap<>();
    Set<Integer> visiting=new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        for(int i=0;i<numCourses;i++){
            preMap.put(i,new ArrayList<>());
        }
        for(int[] p: prerequisites){
            preMap.get(p[0]).add(p[1]);
        }

        for(int i=0;i<numCourses;i++){
            if(!dfs(i)){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int course){
        if(visiting.contains(course)){
            return false;
        }
        if(preMap.get(course).isEmpty()){
            return true;
        }

        visiting.add(course);

        for(int pre:preMap.get(course)){
            if(!dfs(pre)){
                return false;
            }
        }
        visiting.remove(course);
        preMap.get(course).clear();
        return true;
    }
}
