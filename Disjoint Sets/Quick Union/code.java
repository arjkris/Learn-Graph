public class Main {
    public static void main(String[] args) {
        UnionFind uf = new UnionFind(10);
        // 1-2-5-6-7 3-8-9 4
        uf.union(1, 2);
        uf.union(2, 5);
        uf.union(5, 6);
        uf.union(6, 7);
        uf.union(3, 8);
        uf.union(8, 9);
        System.out.println(uf.connected(1, 5)); // true
        System.out.println(uf.connected(5, 7)); // true
        System.out.println(uf.connected(4, 9)); // false

        uf.union(9, 4);
        System.out.println(uf.connected(4, 9)); // true
    }
}

class UnionFind
{
    int[] arr;
    public UnionFind(int size)
    {
        arr = new int[size];
        for(int i = 0;i<size;i++)
            arr[i] = i;
    }

    private int find(int root)
    {
        if(root == arr[root])
            return root;
        return find(arr[root]);
    }

    void union(int x, int y)
    {
        int parentOfX = find(x);
        int parentOfY = find(y);
        if(parentOfX != parentOfY)
        {
            arr[parentOfY] = parentOfX;
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}
