package graphs;

public class NumberOfIslands
{
    public static void main(String[] args)
    {
        int M[][] = new int[][] {   { 1, 1, 0, 0, 0 },
                                    { 0, 1, 0, 0, 1 },
                                    { 1, 0, 0, 1, 1 },
                                    { 0, 0, 0, 0, 0 },
                                    { 1, 0, 1, 0, 1 } };

        Graph g = new Graph(0);

        System.out.println(g.numberOfIslands(M));
    }
}
