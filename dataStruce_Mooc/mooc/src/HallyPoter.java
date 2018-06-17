import java.util.Scanner;

public class HallyPoter {

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.next());
        int M = Integer.parseInt(in.next());

        if(N==1){
            System.out.print(0);
        }else {
            Graph graph = new Graph(N);
            graph = initialization(graph);
            for (int i = 0; i < M; i++) {
                Edge edge = new Edge();
                edge.V1 = Integer.parseInt(in.next()) - 1;
                edge.V2 = Integer.parseInt(in.next()) - 1;
                edge.Weight = Integer.parseInt(in.next());
                graph = insertEdge(graph, edge);
            }

            int D[][] = new int[N][N];
            D = Floyd(graph, D);

            int[] record = findMax(D);

            int flag = 0;
            int pos = 0;
            for (int i = 0; i < record.length - 1; i++) {
                int k = i;
                for (int j = i + 1; j < record.length; j++) {
                    if (record[k] > record[j]) k = j;
                }
                flag++;
                if (flag == 1) {
                    pos = k;
                }
                int temp = record[i];
                record[i] = record[k];
                record[k] = temp;
            }

            System.out.print(pos + 1 + " " + record[0]);
        }
    }

    public static Graph initialization(Graph graph){
        int Nv = graph.Nv;
        for (int i = 0; i < Nv;i ++){
            for (int j = 0;j < Nv;j ++){
                graph.map[i][j] = 65534;
            }
        }
        return graph;
    }

    public static Graph insertEdge(Graph graph,Edge edge){
        int V1 = edge.V1;
        int V2 = edge.V2;
        graph.map[V1][V2] = edge.Weight;
        graph.map[V2][V1] = edge.Weight;
        return graph;
    }

    public static int[][] Floyd(Graph graph,int D[][]){
        for(int i = 0; i < graph.Nv;i ++){
            for (int j = 0;j < graph.Nv; j ++){
                D[i][j] = graph.map[i][j];
            }
        }

        for(int k = 0; k < graph.Nv; k ++){
            for(int i = 0;i < graph.Nv; i ++){
                for (int j = 0; j < graph.Nv; j ++){
                    if((i!=k)&&(j!=i)&&(D[i][k] + D[k][j] < D[i][j])){
                        D[i][j] = D[i][k] + D[k][j];
                    }
                }
            }
        }
        return D;
    }

    public static int[] findMax(int D[][]){
        int[] record = new int[D.length];
        for(int i = 0; i < D.length; i ++){
            record[i] = -1;
            for (int j = 0;j < D[i].length; j ++){
                if (record[i] < D[i][j] && D[i][j] != 65534) record[i] = D[i][j];
            }
        }
        return record;
    }

}

class Edge{
    int V1;
    int V2;
    int Weight;
}

class Graph{
    int Ne;
    int Nv;
    int[][] map;

    public Graph(int Nv){
        this.Nv = Nv;
        this.map = new int[Nv][Nv];
    }
}
