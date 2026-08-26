class Solution {
    public boolean isAnagram(String s, String t) {
      if(s.length()!=t.length()){
        return false;
      }
      int count_char[]=new int[26];
      for(int i=0;i<s.length();i++){
        count_char[s.charAt(i)-'a']++;
        count_char[t.charAt(i)-'a']--;
      }

      for(int i:count_char){
        if(i!=0){
            return false;
        }
      }
      return true;
    }
}
