package DN05_2022;

import java.util.*;

class AddEdge {
    int from, to, cost;

    public AddEdge(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}

public class GRPH {
    int verticesCount;
    ArrayList<AddEdge> edges;
    int[] distance;

    public GRPH(int verticesCount) {
        this.verticesCount = verticesCount;
        edges = new ArrayList<AddEdge>();
        distance = new int[verticesCount];
    }

    public void addEdge(int from, int to, int cost) {
        AddEdge newEdge = new AddEdge(from, to, cost);
        if (!edges.contains(newEdge)) {
            edges.add(newEdge);
        }
    }

    public void getShortestPaths(int source, int[] distance) {
        int vertices = this.verticesCount;

        for(int i = 1; i < vertices; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        distance[source] = 0;
        for(int i = 1; i < vertices; i++) {
            for(AddEdge e: edges) {
                int u = e.from;
                int v = e.to;
                int w = e.cost;

                if(distance[u] != Integer.MAX_VALUE && distance[v] > distance[u] + w) {
                    distance[v] = distance[u] + w;
                }
            }
        }
    }

    void printShortestDistsFrom(int from) {
        getShortestPaths(from, distance);
        System.out.println("V .. Cena");
        System.out.println("0 .. 0");
        for(int i = 1; i < distance.length; i++) {
            System.out.println(i + " .. " + (distance[i] == Integer.MAX_VALUE ? "None" : distance[i]));
        }
    }
}

class LBR {
    int cells [][];

    LBR(int cells[][]) {
        this.cells = cells;
    }

    void printPath(int from, int to) {}
}


class Test {
    public static void main(String[] args) {
        GRPH g = new GRPH(4);
        g.addEdge(0, 1, 1);
        g.addEdge(0, 3, 2);
        g.addEdge(1, 2, 3);
        g.addEdge(1, 3, -1);
        g.addEdge(3, 2, 1);
        g.printShortestDistsFrom(0);
    }

}



