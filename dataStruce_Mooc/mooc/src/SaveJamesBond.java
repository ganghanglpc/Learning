import java.util.Scanner;

public class SaveJamesBond {
    private static boolean[] Visited = new boolean[101];
    private static int D;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.next());
        D = Integer.parseInt(in.next());
        CNode[] cNodes = new CNode[101];
        //StackNode stackNode = new StackNode(5);
        for(int i = 0; i < N; i ++){
            cNodes[i] = new CNode();
        }

        for(int i = 0; i < N; i ++){
            cNodes[i].x = Integer.parseInt(in.next());
            cNodes[i].y = Integer.parseInt(in.next());
            cNodes[i].pos = i;
        }

        for(int i = 0; i < N; i ++){
            Visited[i] = false;
        }

        CNode center = new CNode();
        center.x = 0;
        center.y = 0;
        center.pos = 100;
        if(DFS(center,N,cNodes)){
            System.out.print("Yes");
        }else {
            System.out.print("No");
        }

    }

    public static boolean DFS(CNode cNode,int N,CNode[] cNodes){
        Visited[cNode.pos] = true;
        boolean flag = false;
        if(isInCircle(cNode)){
            flag = true;
        }else {
            for (int i = 0; i < N; i++) {
                if(Visited[i] == false && isInJumpdis(cNode,cNodes[i])){
                    flag = DFS(cNodes[i], N,cNodes);
                    if(flag == true) break;
                }
            }
        }
        return flag;
    }

    public static boolean isInJumpdis(CNode cNode1,CNode cNode2){
        if((cNode1.x-cNode2.x)*(cNode1.x-cNode2.x) + (cNode1.y-cNode2.y)*(cNode1.y-cNode2.y) <= D*D ){
            return true;
        }else
            return false;
    }

    public static boolean isInCircle(CNode cNode){
        int x = cNode.x;
        int y = cNode.y;
        if((y-50)*(y-50) <= D*D || (50-x)*(50-x) <= D*D || (x+49)*(x+49) <= D*D || (y+49)*(y+49) <= D*D){
            return true;
        }else
            return false;
    }
}

class CNode{
    int x;
    int y;
    int pos;

    public CNode(){
        this.x = 0;
        this.y = 0;
        this.pos = 0;
    }
}
