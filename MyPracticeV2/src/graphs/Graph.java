package graphs;

import java.util.*;

public class Graph
{
    private int v;
    private List<Integer> adj[];

    public Graph(int v)
    {
        this.v = v;
        this.adj = new LinkedList[v];

        for (int i = 0; i < v; i++)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int u, int v)
    {
        adj[u].add(v);
    }

    // Similar to level order traversal in BT
    void BFS(int n){

        boolean visited[] = new boolean[v];
        Arrays.fill(visited, false);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited[n] = true;

        while (!queue.isEmpty()){

            int ele = queue.poll();
            System.out.print(ele + " ");

            for(int vertex: adj[ele]){

                if(!visited[vertex]){
                    queue.add(vertex);
                    visited[vertex] = true;
                }
            }
        }
    }

    void DFS(int n){

        boolean visited[] = new boolean[v];
        Arrays.fill(visited, false);

        Stack<Integer> stack = new Stack<>();
        stack.push(n);

        while (!stack.empty()){

            int ele = stack.pop();

            if(!visited[ele]){
                System.out.println(ele + " ");
                visited[ele] = true;
            }

            for (int vertex : adj[ele]){
                if(!visited[vertex])
                    stack.push(vertex);
            }
        }
    }

    private void fillIslands(int mat[][], int row, int col, int rowLen, int colLen){

        if(row >= 0 && col >= 0 &&
                   row < rowLen && col < colLen){

            if(mat[row][col] == 1){
                mat[row][col] = 2;

                fillIslands(mat, row+1, col, rowLen, colLen);
                fillIslands(mat, row-1, col, rowLen, colLen);
                fillIslands(mat, row, col+1, rowLen, colLen);
                fillIslands(mat, row, col-1, rowLen, colLen);
            }
        }
    }

    int numberOfIslands(int mat[][]){

        int count = 0;

        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){

                if(mat[i][j] == 1){
                    System.out.println("Found Island at Row: " + i + " Col: " + j);
                    count++;
                    fillIslands(mat, i, j, mat.length, mat[0].length);
                }
            }
        }

        return count;
    }

    int minimumSwap(int arr[]){

        int count = 0;
        boolean visited[] = new boolean[arr.length + 1];

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 1; i <= arr.length; i++) // idx -> val
            map.put(i, arr[i-1]);

        for (int i = 1; i < map.size(); i++)
        {
            if(!visited[i]){

                visited[i] = true;

                if(i == map.get(i))
                    continue;
                else {

                    int valAtI = map.get(i);

                    while (!visited[valAtI]){

                        visited[valAtI] = true;
                        valAtI = map.get(valAtI);

                        count++;
                    }
                }
            }
        }

        return count;
    }
}
