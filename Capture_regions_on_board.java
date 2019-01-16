class Graph
{ 
    static int M, N; 
    
    Graph(int m, int n) {
        this.M = m;
        this.N = n;
    }
    
    static void floodFillUtil(ArrayList<ArrayList<Character>> mat, int x, int y, char prevV, char newV) 
    { 
        if (x < 0 || x >= M || y < 0 || y >= N) 
            return; 
              
        if (mat.get(x).get(y) != prevV) 
            return; 
      
        mat.get(x).set(y, newV);// = newV; 
      
        floodFillUtil(mat, x + 1, y, prevV, newV); 
        floodFillUtil(mat, x - 1, y, prevV, newV); 
        floodFillUtil(mat, x, y + 1, prevV, newV); 
        floodFillUtil(mat, x, y - 1, prevV, newV); 
    } 
      
    static void replaceSurrounded(ArrayList<ArrayList<Character>> mat) 
    { 
        for (int i = 0; i < M; i++) 
            for (int j = 0; j < N; j++) 
                if (mat.get(i).get(j) == 'O') 
                    mat.get(i).set(j, '-');// = '-'; 
      
        for (int i = 0; i < M; i++) 
            if (mat.get(i).get(0) == '-') 
                floodFillUtil(mat, i, 0, '-', 'O'); 
        for (int i = 0; i < M; i++) 
            if (mat.get(i).get(N - 1) == '-') 
                floodFillUtil(mat, i, N - 1, '-', 'O'); 
        for (int i = 0; i < N; i++)
            if (mat.get(0).get(i) == '-') 
                floodFillUtil(mat, 0, i, '-', 'O'); 
        for (int i = 0; i < N; i++) 
            if (mat.get(M - 1).get(i) == '-') 
                floodFillUtil(mat, M - 1, i, '-', 'O'); 
      
        for (int i = 0; i < M; i++) 
            for (int j = 0; j < N; j++) 
                if (mat.get(i).get(j) == '-') 
                    mat.get(i).set(j, 'X');// = 'X'; 
    } 
}

public class Solution {
    public void solve(ArrayList<ArrayList<Character>> a) {
        
        Graph g = new Graph(a.size(), a.get(0).size());
        char arr[][] = new char[a.size()][a.get(0).size()];
        
        g.replaceSurrounded(a);
    }
}