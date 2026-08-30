class Solution {
        public String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();

        for (String str : strs) {
            result.append(str.length())
                  .append('#')
                  .append(str);
        }

        return result.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();

        int i = 0;

        while (i < str.length()) {

            int j = i;

            while (str.charAt(j) != '#') {
                j++;
            }

            int length = Integer.parseInt(str.substring(i, j));

            int start = j + 1;

            int end = start + length;

            result.add(str.substring(start, end));

            i = end;
        }

        return result;
    }
  
}
