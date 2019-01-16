class AdjList {
    int v;
    ArrayList<Integer> arr[];
    
    AdjList(int v) {
        this.v = v;
        arr = new ArrayList[v];
        
        for(int i = 0; i < v; i++) {
            arr[i] = new ArrayList<Integer>();
        }
    }
    
    void addEdge(int i, int j) {
        arr[i].add(j);
    }
    
    void print() {
        for(int i = 0; i < v; i++) {
            int x = arr[i].size();
            System.out.print(i);
            for(int j = 0; j < x; j++) {
                System.out.print("->" + arr[i].get(j));
            }
            System.out.println();
        }
    }
    
    boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack)  
    { 
        if (recStack[i]) 
            return true; 
  
        if (visited[i]) 
            return false; 
              
        visited[i] = true; 
  
        recStack[i] = true; 
        List<Integer> children = arr[i]; 
          
        for (Integer c: children) 
            if (isCyclicUtil(c, visited, recStack)) 
                return true; 
                  
        recStack[i] = false; 
  
        return false; 
    } 
  
    boolean isCyclic()  
    { 
        boolean[] visited = new boolean[v]; 
        boolean[] recStack = new boolean[v]; 
          
        for (int i = 0; i < v; i++) 
            if (isCyclicUtil(i, visited, recStack)) 
                return true; 
  
        return false; 
    }
    
}

public class Solution {
    public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
        
        AdjList graph = new AdjList(A);
        
        for(int i = 0; i < B.size(); i++) {
            graph.addEdge(B.get(i) - 1, C.get(i) - 1);
        }
        
        if(graph.isCyclic()) 
            return 0;
        else
            return 1;
    }
}