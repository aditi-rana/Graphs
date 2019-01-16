class Graphs 
{ 
    int ROW, COL; 
  
    Graphs(int row, int col) {
        this.ROW = row;
        this.COL = col;
    }
    
    boolean check(int M[][], int row, int col, boolean visited[][]) 
    { 
        return (row >= 0) && (row < ROW) && 
               (col >= 0) && (col < COL) && 
               (M[row][col]==1 && !visited[row][col]); 
    } 
  
    void dfs(int M[][], int row, int col, boolean visited[][]) 
    { 
        int rowNbr[] = new int[] {-1, -1, -1,  0, 0,  1, 1, 1}; 
        int colNbr[] = new int[] {-1,  0,  1, -1, 1, -1, 0, 1}; 
  
        visited[row][col] = true; 
  
        for (int k = 0; k < 8; ++k) 
            if (check(M, row + rowNbr[k], col + colNbr[k], visited) ) 
                dfs(M, row + rowNbr[k], col + colNbr[k], visited); 
    } 
  
    int count(int M[][]) 
    { 
        boolean visited[][] = new boolean[ROW][COL]; 
  
        int count = 0; 
        for (int i = 0; i < ROW; ++i) 
            for (int j = 0; j < COL; ++j) 
                if (M[i][j]==1 && !visited[i][j]) 
                {                                 
                    dfs(M, i, j, visited); 
                    ++count; 
                } 
  
        return count; 
    } 
}

public class Solution {
    public int black(ArrayList<String> A) {
        int r = A.size(), c = A.get(0).length();
        
        Graphs graph = new Graphs(A.size(), A.get(0).length());
        
        int a[][] = new int[r][c];
        int k = 0;
        
        for(int i = 0; i < r; i++) {
            String str = A.get(i);
            for(int j = 0; j < c; j++) {
                if(str.charAt(j) == 'x' || str.charAt(j) == 'X') {
                    a[i][j] = 1;
                    k++;
                }
                else
                    a[i][j] = 0;
            }
        }
            
        return graph.count(a);
    }
}