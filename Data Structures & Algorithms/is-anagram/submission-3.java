class Solution {
    public boolean isAnagram(String s, String t) {
      if(s.length()!=t.length()){
        return false;
      }
      int stringLength=s.length();
      int [] chars=new int[26];
      for(int i=0;i<stringLength;i++){
        chars[s.charAt(i)-'a']++;
        chars[t.charAt(i)-'a']--;
      }
      for(int num:chars){
        if(num!=0){
          return false;
        }
      }
      return true;
    }
}
