public class code
{
    public static void main(String[] args) {
        UnionByRank ubr = new UnionByRank(10);
        // 1-2-5-6-7 3-8-9 4
        ubr.union(1, 2);
        ubr.union(2, 5);
        ubr.union(5, 6);
        ubr.union(6, 7);
        ubr.union(3, 8);
        ubr.union(8, 9);
        System.out.println(ubr.connected(1, 5)); // true
        System.out.println(ubr.connected(5, 7)); // true
        System.out.println(ubr.connected(4, 9)); // false

        ubr.union(9, 4);
        System.out.println(ubr.connected(4, 9)); // true
    }
}

class UnionByRank
{
    int[] parent;
    int[] rank;

    public UnionByRank(int size)
    {
        parent = new int[size];
        rank = new int[size];
        for(int i =0;i<size;i++)
        {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int node)
    {
        if(node == parent[node])
            return node;
        return find(parent[node]);
    }

    public void union(int node1, int node2)
    {
        int parentof1 = find(node1);
        int parentof2 = find(node2);
        if(parentof1 != parentof2)
        {
            if(rank[parentof1]>=rank[parentof2])
            {
                rank[parentof1]+=rank[parentof2];
                parent[parentof2] = parentof1;
            }
            else
            {
                rank[parentof2]+=rank[parentof1];
                parent[parentof1] = parentof2;
            }
        }
    }

    public boolean connected(int node1, int node2) {
        return find(node1) == find(node2);
    }
}