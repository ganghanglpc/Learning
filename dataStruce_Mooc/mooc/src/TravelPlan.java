import java.util.Scanner;

/**
 * @Author lpc
 * 2018.5.3
 */
public class TravelPlan {
    private static int N;
    private static int M;
    private static int S;
    private static int D;

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        N = Integer.parseInt(in.next());
        M = Integer.parseInt(in.next());
        S = Integer.parseInt(in.next());
        D = Integer.parseInt(in.next());

        /**
         * 初始化
         */
        int[] distance = new int[N];
        boolean[] collected = new boolean[N];
        int[] path = new int[N];
        int[] fees = new int[N];

        MpNode map = new MpNode(N);
        for (int i = 0;i < N;i ++){
            for (int j = 0;j < N;j ++)
                map.Graph[i][j] = new MessageNodo();
        }

        EdNode edNode = new EdNode();
        for (int i = 0; i < M;i ++){
            MessageNodo messageNodo = new MessageNodo();
            edNode.V1 = Integer.parseInt(in.next());
            edNode.V2 = Integer.parseInt(in.next());
            messageNodo.distance = Integer.parseInt(in.next());
            messageNodo.fees = Integer.parseInt(in.next());
            edNode.messageNodo = messageNodo;
            insertEdge(map,edNode);
        }

        Dijkstra(map,distance,collected,path,fees,S,D);
        int road = D;
        int droad;
        int count = 0;
        while(road != -1){
            droad = path[road];
            if(droad == -1)
                break;
            road = droad;
            count++;
        }
        System.out.println(count + 1 + " " + fees[D]);
    }

    /**
     * Dijkstra算法
     * @param map
     * @param start
     * @param destination
     */
    public static void Dijkstra(MpNode map,int[] dist,boolean[] collected,int[] path,int[] fees,int start,int destination){
        for(int i = 0;i < map.Nv; i ++){
            dist[i] = map.Graph[start][i].distance;
            fees[i] = map.Graph[start][i].fees;
            if(dist[i] < 10000)
                path[i] = start;
            else
                path[i] = -1;
            collected[i] = false;
        }
        /* 初始化起点 */
        dist[start] = 0;
        collected[start] = true;

        while(true){
            start = FindMinDist(map,dist,collected);
            /* 找到终点，退出算法*/
            if(start >= destination)
                break;
            collected[start] = true;
            for (int j = 0;j < map.Nv; j ++){
                /* 未访问过且有边 */
                if(collected[j] == false && map.Graph[start][j].distance < 10000){
                    if(dist[start] + map.Graph[start][j].distance < dist[j] || (dist[start] + map.Graph[start][j].distance == dist[j] && fees[start] + map.Graph[start][j].fees < fees[j])){
                        dist[j] = dist[start] + map.Graph[start][j].distance;
                        path[j] = start;
                        fees[j] = fees[start] + map.Graph[start][j].fees;
                    }
                }
            }
        }
    }

    /**
     * 找到路径中最小值
     * @param map
     * @param dist
     * @param collected
     * @return
     */
    public static int FindMinDist(MpNode map,int[] dist,boolean collected[]){
        int MinV = 0;
        int V;
        int MinDist = 10000;
        for(V = 0;V < map.Nv; V++){
            if(collected[V] == false && dist[V] < MinDist){
                MinDist = dist[V];
                MinV = V;
            }
        }
        if(MinDist < 10000){
            return MinV;
        }else
            return -1;
    }
    /**
     * 插入边
     * @param map
     * @param edge
     */
    public static void insertEdge(MpNode map,EdNode edge){
        int V1 = edge.V1;
        int V2 = edge.V2;
        MessageNodo messageNodo = edge.messageNodo;
        map.Graph[V1][V2] = messageNodo;
        map.Graph[V2][V1] = messageNodo;
    }

}

/**
 * Some data struct  be used
 */
class MessageNodo{
    int distance;
    int fees;

    public MessageNodo(){
        this.distance = 10000;
        this.fees = 10000;
    }
}

class EdNode{
    int V1;
    int V2;
    MessageNodo messageNodo;
}

class MpNode{
    int Nv;
    int Ne;
    MessageNodo[][] Graph;

    public MpNode(int Nv){
        this.Nv = Nv;
        this.Graph = new MessageNodo[Nv][Nv];
    }
}

