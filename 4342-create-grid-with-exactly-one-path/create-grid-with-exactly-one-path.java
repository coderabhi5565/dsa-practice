class Solution {
    public String[] createGrid(int n, int m) {
        char[][] mat = new char[n][m];
        for(int i = 1; i<n; i++){
            for(int j = 0; j<mat[0].length-1; j++){
                mat[i][j] = '#';
            }
        }
        for(int i = 0; i<mat.length; i++){
            for(int j = 0; j<mat[0].length; j++){
                if(mat[i][j]!='#'){
                    mat[i][j] = '.';
                }
            }
        }
        String[] ans = new String[n];
        for(int i = 0; i<n; i++){
            String temp = "";
            for(int j = 0; j<m; j++){
                temp += mat[i][j];
            }
            ans[i] = temp;
        }
        return ans;
    }
}