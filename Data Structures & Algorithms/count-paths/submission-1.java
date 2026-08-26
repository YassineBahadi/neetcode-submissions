class Solution {
    public int uniquePaths(int m, int n) {
        int tab[][]=new int [m][n];
        for(int i=0;i<m;i++){
            tab[i][0]=1;
        }

        for(int j=0;j<n;j++){
            tab[0][j]=1;
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                tab[i][j]=tab[i][j-1]+tab[i-1][j];
            }
        }

        return tab[m-1][n-1];
    }
}
